package helpers

import org.apache.spark.sql.SparkSession

object Reader {

  def fromCsv(session: SparkSession, parentFolder: String, header: Boolean = false) = {

    import session.implicits._

    session
      .read
      .option("header", header)
      .csv(session.sparkContext.textFile(parentFolder).toDS())

  }

}
