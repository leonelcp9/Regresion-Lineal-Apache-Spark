import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._

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
      .add("Block",StringType,true)
      .add("IUCR",IntegerType,true)
      .add("Primary Type",StringType,true)
      .add("Description",StringType,true)
      .add("Location Description",StringType,true)
      .add("Arrest",BooleanType,true)
      .add("Domestic",BooleanType,true)
      .add("Beat",IntegerType,true)
      .add("District",DoubleType,true)
      .add("Ward",DoubleType,true)
      .add("Community Area",FloatType,true)
      .add("FBI Code",IntegerType,true)
      .add("X Coordinate",DoubleType,true)
      .add("Y Coordinate",DoubleType,true)
      .add("Year",IntegerType,true)
      .add("Updated On",StringType,true)
      .add("Latitude",DoubleType,true)
      .add("Longitude",DoubleType,true)
      .add("Location",StringType,true)

    val df = spark.read.format("csv").option("header","true").schema(schema).load(path)
    df.printSchema()
    df.show()
  }
}