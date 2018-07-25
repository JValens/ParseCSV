import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.typesafe.config.ConfigFactory
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.jsoup.Jsoup

case class InitialData(product_id: String, brand: String, product_name: String, short_description: String, lineage: String, long_description: String)

case class ProcessedData(product_id: String, brand: String, product_name: String, short_description: String, lineage: String,
                         long_description: String, lineage_1: String, lineage_2: String, lineage_3: String, lineage_4: String, lineage_5: String,
                         lineage_6: String, lineage_7: String, lineage_8: String, features: Map[String, String])

object ProcessData {

  def processMap(textToProcess: String) : Map[String, String] = {

    val allChildText = Jsoup.parse(textToProcess).body().select("ul").html()
    val childList = Jsoup.parse(allChildText).body().children().eachText().toArray().toList

    val mapToPrepare = childList map (t => {
      val processString = t.toString
      if(processString.contains(":")) {
        val splitValues = processString.split(":")
        splitValues(0).toString -> splitValues(1)
      } else {
        `processString` -> "true"
      }
    }) toMap

/*
    val processString = textToProcess
    val getTagChildren = Jsoup.parse(processString).select("ul")

    import scala.collection.JavaConversions._
    var mapToPrepare: Map[String, String] = Map[String, String]()

    import scala.collection.JavaConverters._
    for(outerElements <- getTagChildren.asScala) {
      val innerList = outerElements.children().asScala
      for(innerElements <- innerList) {
        val textToCheck = Jsoup.parse(innerElements.toString).text()
        if(textToCheck.contains(":")) {
          val splitedValues = textToCheck.split(":")
          mapToPrepare + (splitedValues(0) -> splitedValues(1))
        } else {
          mapToPrepare + (`textToCheck` -> "true")
        }
      }
    }


    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)
*/

    mapToPrepare
  }

  def processHTMLData(textToProcess: String, prependData: String, appendData: String): (String, Map[String, String]) = {
    (prependData + textToProcess + appendData, processMap(textToProcess))
  }

  def getElement(list: List[String], index: Integer): String = {
    try {
      list.apply(index)
    } catch {
      case a: IndexOutOfBoundsException => null
    }
  }

  def processMapData(textToProcess: String, separator: String): (String, String, String, String, String, String, String, String) = {
    val listToProcess = textToProcess.split(separator).toArray.toList
    val tupleToReturn = (
      getElement(listToProcess, 0), getElement(listToProcess, 1), getElement(listToProcess, 2),
      getElement(listToProcess, 3), getElement(listToProcess, 4), getElement(listToProcess, 5),
      getElement(listToProcess, 6), getElement(listToProcess, 7))
    tupleToReturn
  }
}

class Operations {
  def performParsingOperation(): Unit = {
    //Application Configuration
    val applicationConfig = ConfigFactory.load("application.conf")

    //Elastic Details
    val elasticURL: String = applicationConfig.getString("elastic_details.server_url")
    val elasticPort: String = applicationConfig.getString("elastic_details.port_number")
    val elasticIndex: String = applicationConfig.getString("elastic_details.index_name")
    val elasticType: String = applicationConfig.getString("elastic_details.mapping_type")

    //Spark Details
    val sparkAppName: String = applicationConfig.getString("spark_details.app_name")
    val sparkMaster: String = applicationConfig.getString("spark_details.master_url")

    //File_Details
    val filePath: String = applicationConfig.getString("file_details.file_URL")
    val colSeparator: String = applicationConfig.getString("file_details.column_separator")
    val quote: String = applicationConfig.getString("file_details.quote")

    //HTML edit details
    val prependData: String = applicationConfig.getString("html_data.prepend_data")
    val appendData: String = applicationConfig.getString("html_data.append_data")

    val listSeparator: String = applicationConfig.getString("list_separator")

    //New Field To Add
    val sparkConfig = new SparkConf()
      .setMaster(sparkMaster)
      .setAppName(sparkAppName)
      .set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
      .set("es.index.auto.create", "true")
      .set("es.read.metadata", "true")
      .set("es.nodes", elasticURL)
      .set("es.port", elasticPort)
      .set("es.net.http.auth.user", "")
      .set("es.net.http.auth.pass", "")
      .set("es.resource", elasticIndex)
      .set("es.nodes.wan.only", "true")

    val sparkSession = SparkSession.builder.config(sparkConfig).getOrCreate()
    val initialDataFrame = sparkSession.read.format("csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .option("delimiter", colSeparator)
      .option("quote", quote)
      .load(filePath)

    import sparkSession.implicits._
    val preparedDF = initialDataFrame.as[InitialData].mapPartitions(partition => {
      val newPartition = partition.map(row => {
        val dataToAdd = ProcessData.processMapData(row.lineage, listSeparator)
        val processedHTMLData = ProcessData.processHTMLData(row.long_description, prependData, appendData)
        ProcessedData(row.product_id, row.brand, row.product_name, row.short_description, row.lineage, processedHTMLData._1
          , dataToAdd._1, dataToAdd._2, dataToAdd._3, dataToAdd._4, dataToAdd._5, dataToAdd._6, dataToAdd._7, dataToAdd._8, processedHTMLData._2)
      })
      newPartition.toIterator
    })

    preparedDF.show()

    import org.elasticsearch.spark.sql._
    preparedDF.saveToEs(elasticIndex + "/" + elasticType)

  }
}

object TestOperations {
  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis()
    new Operations().performParsingOperation()
    val endTime = System.currentTimeMillis()
    println("start time ==> " + startTime)
    println("end time ==> " + endTime)
    println("Total time ==> " + (TimeUnit.MICROSECONDS.toSeconds(endTime) - TimeUnit.MICROSECONDS.toSeconds(startTime)))
  }
}
