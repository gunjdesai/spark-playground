import data.constants.{App, Logs}
import helpers.Configuration
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object Session {

    def apply(env: String) = {

      val sparkConfig = new SparkConf()
      sparkConfig.setAll(Configuration.load(env, App.SPARK_CONFIG_FILE_NAME))

      val session = SparkSession
        .builder()
        .master("local[2]")
        .config(sparkConfig)
        .getOrCreate()

      session.sparkContext.setLogLevel(Logs.INFO)

      session

    }

}
