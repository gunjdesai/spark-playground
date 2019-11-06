import helpers.Reader
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.types.DataTypes
import org.apache.spark.sql.functions._

object Application {

  def apply(env: String, session: SparkSession) = {

    import session.implicits._

    val folderPath = "~/Desktop/spark/files"
    val df = Reader.fromCsv(session, folderPath)
    

  }

}
