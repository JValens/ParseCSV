import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.jsoup.Jsoup
import org.jsoup.select.Evaluator.Tag

import scala.xml.XML


class ProcessString {

}


object ProcessString {
  def main(args: Array[String]): Unit = {
//    val stringToProcess = "Product # RC9485T-LMB <ul> <li>GPS Vehicle : Navigation System</li> <li><span class=\"redbold\">7\"</span> High Definition Touchscreen</span></li> <li><span class=\"diff1\"><a href=\"javascript:popSize('/content/images/gps/pop_ups/html/Bluetooth.html',500,250);\"  class=\"included_popup\">Bluetooth</a> Enabled</span></li> <li><span class=\"blackbold\">Free Lifetime Traffic Alerts</span></li> <li><span class=\"blackbold\">Free Lifetime Map Updates</span></li> <li><span class=\"redbold\">Truck Specific Routing</span></li> <li>Vehicle Profile Setting</li> <li><span class=\"redbold\">Landmark Guidance</span></li> <li>OneTouch&trade; Menu</li> <li><span class=\"bluebold\">Free Lifetime Map Updates</span></li> <li><span class=\"redbold\">7</span> Million Points of Interest</li> </ul>Product # RC9485T-LMB <br /> <br /> The <strong>Magellan Roadmate RC9485T-LMB</strong> automotive GPS system features a <strong>7\" high-definition touchscreen</strong> to provide an instant access to navigation features. The integrated Bluetooth&reg; wireless technology enables hands-free communication and enter in Hours Of Service whether off duty, sleeping, driving, or on-duty not driving. This GPS provides some superior features for the needs of Professional drivers, including: multi-destination routing, custom vehicle profiles, and driver profiles, while an internal computer calculates IFTA relevant mileage allowing easy retrieval for tax purposes. It also provides free lifetime traffic alerts that give real-time traffic information and free lifetime map updates.  <br /> <br /> The RC9485T-LMB GPS features <strong>Truck Specific Routing </strong> and vehicle profile setting that allows you to set your vehicles length, width, weight and height to be able to customize your route. The system provides data feeds that point out the lowest fuel prices, weigh stations and toll booth alerts, and weather information. It ensures safer roadway transitions while on the road with premium features including highway lane assist, multi-destination routing, <strong>pre-loaded maps of United States, Canada, and Puerto Rico</strong>. The spoken street name guidance announces the street name and direction for each turn. <br /> <br /> <span class=\"bigredbold\">RoadMate RC9485T-LMB Features:</span> <br /> <br /> <ul> <li>GPS Vehicle Navigation System</li> <li><span class=\"redbold\">7\"</span> High Definition Touchscreen</li> <li><span class=\"diff1\"><a href=\"javascript:popSize('/content/images/gps/pop_ups/html/Bluetooth.html',500,250);\" class=\"included_popup\">Bluetooth</a> Enabled</span></li> <li>Android 4.0 OS</li> <li><span class=\"blackbold\">Free Lifetime Traffic Alerts</span> <br />- Provides Real-Rime Traffic Information <br />- Avoid Traffic Jams, Detours &amp; Construction Zones</li> <li><span class=\"bluebold\">Traffic Camera Alerts by PhantomALERT</span></li> <li><span class=\"blackbold\">Free Lifetime Map Updates</span></li> <li><span class=\"redbold\">Landmark Guidance</span> <br /> - Easy Navigation by Familiar Landmarks</li> <li><span class=\"redbold\">Truck Specific Routing</span> <br /> - Customize Routes Using Your Vehicle Profile</li> <li>Vehicle Profile Setting <br /> - Set Your Vehicles Length, Width, Weight & Height</li> <li><span class=\"blackbold\">Hands-Free Calls</span> w/ Your Compatible Cell Phone</li> <li>OneTouch&trade; Menu</li> <li><span class=\"blackbold\">Junction View</span></li> <li>Alerts For Weigh Station/Toll Booth/Camera</li> <li>Yellow Sign Alerts</li> <li>Speed Limit Warning</li> <li><span class=\"bluebold\">Spoken Street Name Guidance</span></li> <li>Preloaded Maps <br />- United States, Canada, &amp; Puerto Rico</li> <li>Multi-Destination Routing w/ Route Optimization</li> <li>Highway Lane Assist <br />- Shows Realistic Highway Signs</li> <li><span class=\"redbold\">7</span> Million Points of Interest <br />- Truck Stops, Restaurants, ATM's, etc. <br /> - Branded POIs <br /> - POIs Along Route</li> <li>Highway Exit POIs Search <br />- Finds Gas Stations, Hotels, etc.</li> <li>QuickSpell&reg; with SmartCity Search <br />- Narrows Address & City Searches <br />- Makes Destination Entry Easy </li> <li>Geo Reminders <br /> - Custom Location-based Reminders</li> <li>QuickSpell <br />- Guesses the Address Based on Your Location <li>Turn-by-Turn Routing</li> <li>Yelp Integration</li> <li>RV/Truck Route</li> <li>QWERTY/ABCD Keyboard</li> <li>Smart Detour</li> <li>HOS and IFTA Logbook</li> <li>Automatic Re-route</li> <li>SmartGPS Eco Cloud Content: Fuel Price &amp; Weather Information <br /> - Real-Time, Detailed Graphic Overlays &amp; Fuel Prices</li> <li>A/V Input</li> <li>Multiple Drivers Login</li> <li>Rechargable Battery</li> <li>Micro SD Card Compatible</li> </ul> <br /> <br /> <span class=\"bigbold\">Key Definitions:</span> <br /> <br /> <strong>Truck Specific Routing:</strong> <br />Customize routes using your Truck's length, width, weight and height. <br /><br /> <strong>Vehicle Profile Setting:</strong> <br />Set your vehicles length, width, weight and height to be able to customize your route. <br /><br /> <strong>A/V Input:</strong> <br />Easy connection to external devices such as back-up cameras, DVD players, and iPods. <br /><br /> <strong>Smart Detour:</strong> <br />Immediate detour option if you are suddenly caught in traffic. <br /><br /> <strong>Multiple Drivers Login:</strong> <br />Log your hours of service and driving status, tracks your hours and records state mileage for IFTA fuel logging. Conveniently export all logs for reporting and tracking of each trip <br /><br /> <strong>Junction View:</strong> <br />Realistic images of freeway signs and arrows guide you to the correct lane to   make driving easier, safer and less stressful. <br /><br /> <strong>Automatic Re-Route:</strong> <br />Never miss a turn and quickly get back on track whenever you take a detour. <br /><br /> <strong>Branded POIs:</strong> <br />Display your favorite coffee shops, restaurants, and more by their respective   logos.  <br /><br /> <strong>Customizable Route Method:</strong> <br />Choose the way you want to navigate to use the most freeways, least freeways, fastest time, shortest distance and avoid toll roads. Exclude specific streets or freeways after a route is calculated to get there the way you want. <br /><br /> <strong>Preloaded Maps:</strong> <br />Gives you the latest maps and directions as you travel the United States, Canada, and Puerto Rico. <br /><br /> <strong>Free Lifetime Traffic Alerts:</strong> <br />Provides real-time traffic information. Avoid traffic jams, detours and construction zones. <br /><br /> <strong>Multi-destination Routing:</strong> <br />Select up to 20 destinations and choose the order to plan a trip in advance and repeat the same trip again. Easily reorganize, add or remove destinations. <br /><br /> <strong>Points of Interest:</strong> <br />Easily find what you need. Gas stations, restaurants, hotels, ATMs and hundreds of other businesses and services are intuitively categorized and searchable from the built-in POI database. Most include the phone number. <br /><br /> <strong>QuickSpell&reg::</strong> <br />Narrows your address and city searches, making destination entry easy.  <br /><br /> <strong>Spoken Street Name Guidance:</strong> <br />Hear street names with every voice direction and have a clear understanding of when to make the next turn while you keep your eyes on the road. <br /><br /> <strong>Highway Lane Assist:</strong> <br />Shows realistic highway signs to guide you and ensure that you'll choose the correct lane. <br /><br /> <strong>Highway Exit POIs Search:</strong> <br />Finds gas stations, restaurants, hotels, and more near upcoming highway exits. <br /><br /> <strong>OneTouch&trade; Menu:</strong> <br />Offers instant access to your personalized bookmarks of favorite places and searches anywhere you travel. With a single touch, find your favorite café or restaurant in any city.<br /> <br /> <span class=\"blackbold\">Includes:</span> <br /> <br /> <ul> <li>Magellan RoadMate GPS Receiver</li> <li>Vehicle Power Adapter</li> <li>Windshield Mount</li> <li>USB Cable</li> <li>Product Handbook</li>  </ul>, Screen Size:7\" Display, RoadMate Series:RoadMate RC9000, GPS FM Traffic Included:Lifetime Maps &amp;amp; Traffic, GPS:Trucking GPS, Touchscreen:GPS Touchscreen, Watches &amp; Computers Type:Touchscreen, Vehicle Specialty:Truck&#x0D; \n"

//    val stringToProcess = "<ul><li>test1</li><li>test2</li><li>test3</li><li>test4</li></ul><ul><li>best1</li><li>best2</li><li>best3</li><li>best4</li></ul>"


//    val stringToProcess = "<ul> <li>GPS Vehicle : Navigation System</li> <li><span class=\"redbold\">7\"</span> High Definition Touchscreen</span></li> <li>Bluetooth Enabled</li> <li><span class=\"blackbold\">Free Lifetime Traffic Alerts</span></li> <li><span class=\"blackbold\">Free Lifetime Map Updates</span></li> <li>Truck Specific Routing</li> <li>Vehicle Profile Setting</li> <li><spanLandmark Guidance</li> <li>OneTouch&trade; Menu</li> <li>Free Lifetime Map Updates</li> <li>Million Points of Interest</li> </ul> <ul> <li>Magellan RoadMate GPS Receiver</li> <li>Vehicle Power Adapter</li> <li>Windshield Mount</li> <li>USB Cable</li> <li>Product Handbook</li> </ul>"

    val stringToProcess = "Product # RC9485T-LMB <ul> <li>GPS Vehicle Navigation System</li> <li><span class=\"redbold\">7\"</span> High Definition Touchscreen</span></li> <li><span class=\"diff1\"><a href=\"javascript:popSize('/content/images/gps/pop_ups/html/Bluetooth.html',500,250);\"  class=\"included_popup\">Bluetooth</a> Enabled</span></li> <li><span class=\"blackbold\">Free Lifetime Traffic Alerts</span></li> <li><span class=\"blackbold\">Free Lifetime Map Updates</span></li> <li><span class=\"redbold\">Truck Specific Routing</span></li> <li>Vehicle Profile Setting</li> <li><span class=\"redbold\">Landmark Guidance</span></li> <li>OneTouch&trade; Menu</li> <li><span class=\"bluebold\">Free Lifetime Map Updates</span></li> <li><span class=\"redbold\">7</span> Million Points of Interest</li> </ul>Product # RC9485T-LMB <br /> <br /> The <strong>Magellan Roadmate RC9485T-LMB</strong> automotive GPS system features a <strong>7\" high-definition touchscreen</strong> to provide an instant access to navigation features. The integrated Bluetooth&reg; wireless technology enables hands-free communication and enter in Hours Of Service whether off duty, sleeping, driving, or on-duty not driving. This GPS provides some superior features for the needs of Professional drivers, including: multi-destination routing, custom vehicle profiles, and driver profiles, while an internal computer calculates IFTA relevant mileage allowing easy retrieval for tax purposes. It also provides free lifetime traffic alerts that give real-time traffic information and free lifetime map updates.  <br /> <br /> The RC9485T-LMB GPS features <strong>Truck Specific Routing </strong> and vehicle profile setting that allows you to set your vehicles length, width, weight and height to be able to customize your route. The system provides data feeds that point out the lowest fuel prices, weigh stations and toll booth alerts, and weather information. It ensures safer roadway transitions while on the road with premium features including highway lane assist, multi-destination routing, <strong>pre-loaded maps of United States, Canada, and Puerto Rico</strong>. The spoken street name guidance announces the street name and direction for each turn. <br /> <br /> <span class=\"bigredbold\">RoadMate RC9485T-LMB Features:</span> <br /> <br /> <ul> <li>GPS Vehicle Navigation System</li> <li><span class=\"redbold\">7\"</span> High Definition Touchscreen</li> <li><span class=\"diff1\"><a href=\"javascript:popSize('/content/images/gps/pop_ups/html/Bluetooth.html',500,250);\" class=\"included_popup\">Bluetooth</a> Enabled</span></li> <li>Android 4.0 OS</li> <li><span class=\"blackbold\">Free Lifetime Traffic Alerts</span> <br />- Provides Real-Rime Traffic Information <br />- Avoid Traffic Jams, Detours &amp; Construction Zones</li> <li><span class=\"bluebold\">Traffic Camera Alerts by PhantomALERT</span></li> <li><span class=\"blackbold\">Free Lifetime Map Updates</span></li> <li><span class=\"redbold\">Landmark Guidance</span> <br /> - Easy Navigation by Familiar Landmarks</li> <li><span class=\"redbold\">Truck Specific Routing</span> <br /> - Customize Routes Using Your Vehicle Profile</li> <li>Vehicle Profile Setting <br /> - Set Your Vehicles Length, Width, Weight & Height</li> <li><span class=\"blackbold\">Hands-Free Calls</span> w/ Your Compatible Cell Phone</li> <li>OneTouch&trade; Menu</li> <li><span class=\"blackbold\">Junction View</span></li> <li>Alerts For Weigh Station/Toll Booth/Camera</li> <li>Yellow Sign Alerts</li> <li>Speed Limit Warning</li> <li><span class=\"bluebold\">Spoken Street Name Guidance</span></li> <li>Preloaded Maps <br />- United States, Canada, &amp; Puerto Rico</li> <li>Multi-Destination Routing w/ Route Optimization</li> <li>Highway Lane Assist <br />- Shows Realistic Highway Signs</li> <li><span class=\"redbold\">7</span> Million Points of Interest <br />- Truck Stops, Restaurants, ATM's, etc. <br /> - Branded POIs <br /> - POIs Along Route</li> <li>Highway Exit POIs Search <br />- Finds Gas Stations, Hotels, etc.</li> <li>QuickSpell&reg; with SmartCity Search <br />- Narrows Address & City Searches <br />- Makes Destination Entry Easy </li> <li>Geo Reminders <br /> - Custom Location-based Reminders</li> <li>QuickSpell <br />- Guesses the Address Based on Your Location <li>Turn-by-Turn Routing</li> <li>Yelp Integration</li> <li>RV/Truck Route</li> <li>QWERTY/ABCD Keyboard</li> <li>Smart Detour</li> <li>HOS and IFTA Logbook</li> <li>Automatic Re-route</li> <li>SmartGPS Eco Cloud Content: Fuel Price &amp; Weather Information <br /> - Real-Time, Detailed Graphic Overlays &amp; Fuel Prices</li> <li>A/V Input</li> <li>Multiple Drivers Login</li> <li>Rechargable Battery</li> <li>Micro SD Card Compatible</li> </ul> <br /> <br /> <span class=\"bigbold\">Key Definitions:</span> <br /> <br /> <strong>Truck Specific Routing:</strong> <br />Customize routes using your Truck's length, width, weight and height. <br /><br /> <strong>Vehicle Profile Setting:</strong> <br />Set your vehicles length, width, weight and height to be able to customize your route. <br /><br /> <strong>A/V Input:</strong> <br />Easy connection to external devices such as back-up cameras, DVD players, and iPods. <br /><br /> <strong>Smart Detour:</strong> <br />Immediate detour option if you are suddenly caught in traffic. <br /><br /> <strong>Multiple Drivers Login:</strong> <br />Log your hours of service and driving status, tracks your hours and records state mileage for IFTA fuel logging. Conveniently export all logs for reporting and tracking of each trip <br /><br /> <strong>Junction View:</strong> <br />Realistic images of freeway signs and arrows guide you to the correct lane to   make driving easier, safer and less stressful. <br /><br /> <strong>Automatic Re-Route:</strong> <br />Never miss a turn and quickly get back on track whenever you take a detour. <br /><br /> <strong>Branded POIs:</strong> <br />Display your favorite coffee shops, restaurants, and more by their respective   logos.  <br /><br /> <strong>Customizable Route Method:</strong> <br />Choose the way you want to navigate to use the most freeways, least freeways, fastest time, shortest distance and avoid toll roads. Exclude specific streets or freeways after a route is calculated to get there the way you want. <br /><br /> <strong>Preloaded Maps:</strong> <br />Gives you the latest maps and directions as you travel the United States, Canada, and Puerto Rico. <br /><br /> <strong>Free Lifetime Traffic Alerts:</strong> <br />Provides real-time traffic information. Avoid traffic jams, detours and construction zones. <br /><br /> <strong>Multi-destination Routing:</strong> <br />Select up to 20 destinations and choose the order to plan a trip in advance and repeat the same trip again. Easily reorganize, add or remove destinations. <br /><br /> <strong>Points of Interest:</strong> <br />Easily find what you need. Gas stations, restaurants, hotels, ATMs and hundreds of other businesses and services are intuitively categorized and searchable from the built-in POI database. Most include the phone number. <br /><br /> <strong>QuickSpell&reg::</strong> <br />Narrows your address and city searches, making destination entry easy.  <br /><br /> <strong>Spoken Street Name Guidance:</strong> <br />Hear street names with every voice direction and have a clear understanding of when to make the next turn while you keep your eyes on the road. <br /><br /> <strong>Highway Lane Assist:</strong> <br />Shows realistic highway signs to guide you and ensure that you'll choose the correct lane. <br /><br /> <strong>Highway Exit POIs Search:</strong> <br />Finds gas stations, restaurants, hotels, and more near upcoming highway exits. <br /><br /> <strong>OneTouch&trade; Menu:</strong> <br />Offers instant access to your personalized bookmarks of favorite places and searches anywhere you travel. With a single touch, find your favorite café or restaurant in any city.<br /> <br /> <span class=\"blackbold\">Includes:</span> <br /> <br /> <ul> <li>Magellan RoadMate GPS Receiver</li> <li>Vehicle Power Adapter</li> <li>Windshield Mount</li> <li>USB Cable</li> <li>Product Handbook</li>  </ul>, Screen Size:7\" Display, RoadMate Series:RoadMate RC9000, GPS FM Traffic Included:Lifetime Maps &amp;amp; Traffic, GPS:Trucking GPS, Touchscreen:GPS Touchscreen, Watches &amp; Computers Type:Touchscreen, Vehicle Specialty:Truck&#x0D; \n"

    val allChildText = Jsoup.parse(stringToProcess).body().select("ul").html()
    val childsList = Jsoup.parse(allChildText).body().children().eachText().toArray().toList

    val mapToPrepare = childsList map (t => {
      val processString = t.toString
      if(processString.contains(":")) {
        val splitedValues = processString.split(":")
        splitedValues(0).toString -> splitedValues(1)
      } else {
        `processString` -> "true"
      }
    }) toMap

    mapToPrepare.map(e => {
      println("key ==> " + e._1 + "   value ==> " + e._2)
      e
    })


    println("maptoPrepare ==> " + mapToPrepare)
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)

    println(mapper.writeValueAsString(mapToPrepare))

    /*import scala.collection.JavaConversions._
    childList.map(e => {
      println("element ==> " + e)
      e
    })*/

    /*.toList

    val test = childList.map(value => value -> "true").toMap

    test.map(e => {
      println(e._1 + " === " + e._2)
      e
    })*/
    /*

    import scala.collection.JavaConversions._
    val newList = getTagChildrens.map(outerElement => {
      outerElement.children().eachText()
    })

    val finalList = newList.map(e => {
      e
    })

    finalList.map(e => {
      println(e)
      e
    })*/
/*
    println("maptoPrepare ==> " + mapToPrepare)
    val mapper = new ObjectMapper()
    mapper.registerModule(DefaultScalaModule)

    println(mapper.writeValueAsString(mapToPrepare))
*/

    /*for(outerElements <- getTagChildrens.asScala) {
      val innerList = outerElements.children().asScala
      for(innerElements <- innerList) {
        val textToCheck = Jsoup.parse(innerElements.toString).text()
        if(textToCheck.contains(":")) {
          val splitedValues = textToCheck.split(":")
          mapToPrepare = mapToPrepare + (splitedValues(0) -> splitedValues(1))
        } else {
          mapToPrepare = mapToPrepare + (textToCheck -> "true")
        }
      }
    }*/
    /*

    getTagChildrens.toList.map(outerElement => {
      println(outerElement)
      outerElement
    })
*/

    import scala.collection.JavaConversions._
    /*getTagChildrens.toList.map(outerElements => {
      outerElements.children().toList.map(innerElements => {
        val textToCheck = Jsoup.parse(innerElements.toString).text()
        if(textToCheck.contains(":")) {
          val splitedValues = textToCheck.split(":")
          mapToPrepare = mapToPrepare + (splitedValues(0) -> splitedValues(1))
        } else {
          mapToPrepare = mapToPrepare + (textToCheck -> "true")
        }
        innerElements
      })
    })*/



  }
}