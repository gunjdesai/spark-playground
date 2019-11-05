package helpers

import java.io.InputStream

object Configuration {

  def load(environment: String, filename: String) = {

    val propertyFileName = s"/${environment}/${filename}"
    val config = collection.mutable.Map[String, String]();
    val stream: InputStream = getClass.getResourceAsStream(propertyFileName)
    val lines = scala.io.Source.fromInputStream(stream).getLines

    val activeConfig = lines.map(_.trim)
      .filter(!_.startsWith("#"))
      .filter(_.contains("="))

    /*
     Add all active config items to a map
    */
    activeConfig.foreach(line => {
      val Array(a, b) = line.split("=", 2);
      config += (a.trim -> b.trim)
    })

    config

  }

}
