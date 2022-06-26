import com.sun.jdi.{IntegerType, LongType}
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types.DataType
import org.apache.spark.sql.types.DataType._

object RegresionLineal {
  def main(args: Array[String]) {
    val spark = SparkSession.builder().master("local[1]").appName("Regresion Lineal para Crimenes en la ciudad de Chicago").getOrCreate();
    val path = "Chicago_Crimes_2012_to_2017.csv" // Should be some file on your system
    /*
    val logData = sc.textFile(logFile,2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println(s"Lines with a: $numAs, Lines with b: $numBs")
     */
    val schema = new StructType()
      .add("Number",LongType,true)
      .add("ID",LongType,true)
      .add("Date",StringType,true)
      .add("Block",,true)
    val df = spark.read.csv(path)
    df.show()
  }
}