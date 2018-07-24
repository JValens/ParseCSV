import java.util.concurrent.TimeUnit
import java.util.regex.Pattern

import com.typesafe.config.ConfigFactory
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

case class InitialData(product_id: String, brand: String, product_name: String, short_description: String, lineage: String, long_description: String)

case class ProcessedData(product_id: String, brand: String, product_name: String, short_description: String, lineage: String,
                         long_description: String, lineage_1: String, lineage_2: String, lineage_3: String, lineage_4: String, lineage_5: String,
                         lineage_6: String, lineage_7: String, lineage_8: String)

object ProcessData {
  def addHtmlTags(textToProcess: String, prependData: String, appendData: String): String = {


    val p = Pattern.compile("<ul>(\\S+)</ul>")
    val m = p.matcher(textToProcess)

    if(m.find()) {
      val group = m.group(1)

      println("extractedData ==> " + group)
    }
    prependData + textToProcess + appendData
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
        ProcessedData(row.product_id, row.brand, row.product_name, row.short_description, row.lineage,
          ProcessData.addHtmlTags(row.long_description, prependData, appendData)
          , dataToAdd._1, dataToAdd._2, dataToAdd._3, dataToAdd._4, dataToAdd._5, dataToAdd._6, dataToAdd._7, dataToAdd._8)
      })
      newPartition.toIterator
    })

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
