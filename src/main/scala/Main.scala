import kantan.csv._
import kantan.csv.ops._

case class Heart(age: Int, sex: Int, cp: Int, trestbps: Int, chol: Int, fbs: Int,
                   restecg: Int, thalach: Int, exang: Int, oldpeak: Float, slope: Int,
                   ca: Int, thal: Int, target: Int)


object Main extends App {
  implicit val heartDecoder: RowDecoder[Heart] = RowDecoder.ordered {
    (age: Int, sex: Int, cp: Int, trestbps: Int, chol: Int, fbs: Int,
     restecg: Int, thalach: Int, exang: Int, oldpeak: Float, slope: Int,
     ca: Int, thal: Int, target: Int) =>

      new Heart(age: Int, sex: Int, cp: Int, trestbps: Int, chol: Int, fbs: Int,
        restecg: Int, thalach: Int, exang: Int, oldpeak: Float, slope: Int,
        ca: Int, thal: Int, target: Int)
  }
  val pathToFile = "/titanic.csv"
  val csv = processCsv(pathToFile)

  def processCsv(pathToFile: String) = {
    val rawData: java.net.URL = getClass.getResource(pathToFile)
    val list = rawData.asCsvReader[Heart](rfc.withHeader).toList
    list
  }
}