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
  val csv = processCsv(pathToFile)

  def processCsv(pathToFile: String) = {
    val rawData: java.net.URL = getClass.getResource(pathToFile)
    val rawList = rawData.readCsv[List, Heart](rfc.withHeader)
    val list = rawList.map(x => x.getOrElse(Heart(0,0,0,0,0,0,0,0,0,0.0,0,0,0,0)))
    writeToCsv(list)
  }

  def writeToCsv(list: List[Heart]): Unit = {
    val out = new File("kantan.csv")
    val writer = out.asCsvWriter[Heart](rfc.withHeader("Age", "Sex", "Cp", "Trestbps", "Chol", "fbs", "restecg", "thalach", "exang",
      "oldpeak", "slope", "ca", "thal", "target"))
    writer.write(list).close()
  }
}