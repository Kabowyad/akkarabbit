import java.io.File

import kantan.csv._
import kantan.csv.ops._
import kantan.csv.generic._

case class Heart(age: Int, sex: Int, cp: Int, trestbps: Int, chol: Int, fbs: Int,
                 restecg: Int, thalach: Int, exang: Int, oldpeak: Double, slope: Int,
                 ca: Int, thal: Int, target: Int)


object Main extends App {
  implicit val heartDecoder: RowDecoder[Heart] = RowDecoder.ordered {
    (age: Int, sex: Int, cp: Int, trestbps: Int, chol: Int, fbs: Int,
     restecg: Int, thalach: Int, exang: Int, oldpeak: Double, slope: Int,
     ca: Int, thal: Int, target: Int) =>

      new Heart(age: Int, sex: Int, cp: Int, trestbps: Int, chol: Int, fbs: Int,
        restecg: Int, thalach: Int, exang: Int, oldpeak: Double, slope: Int,
        ca: Int, thal: Int, target: Int)
  }
  val pathToFile = "/titanic.csv"
  override def main(args: Array[String]): Unit = {
    val fieldName = args(0)
    val count = args(1)
    processCsv(pathToFile, fieldName, count.toInt)
  }

  def processCsv(pathToFile: String, fieldName: String, count: Int) = {
    var rawData: java.net.URL = getClass.getResource(pathToFile)
    var rawList = rawData.readCsv[List, Heart](rfc.withHeader)
    var list = rawList.map(x => x.getOrElse(Heart(0,0,0,0,0,0,0,0,0,0.0,0,0,0,0)))
    var finalList = fieldName match {
      case "age" => list.sortWith(_.age > _.age)
      case "sex" => list.sortWith(_.sex > _.sex)
      case "cp" => list.sortWith(_.cp > _.cp)
      case "oldpeak" => list.sortWith(_.oldpeak > _.oldpeak)
    }
    writeToCsv(finalList.take(count))
  }

  def writeToCsv(list: List[Heart]): Unit = {
    val out = new File("kantan.csv")
    val writer = out.asCsvWriter[Heart](rfc.withHeader("Age", "Sex", "Cp"))
    writer.write(list).close()
    println(out.toPath.toAbsolutePath)
  }
}