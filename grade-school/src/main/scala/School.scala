import scala.collection.immutable.SortedMap

class School {
  
  private var internalDb = Map[Int, Seq[String]]()
  
  def db: Map[Int, Seq[String]] = internalDb
  
  def add(name: String, gradeNo: Int) : Unit = {
    val gradeNames = grade(gradeNo) :+ name
    internalDb += (gradeNo -> gradeNames)
  }
  
  def grade(x: Int) : Seq[String] = {
    internalDb.getOrElse(x, Seq.empty[String])
  }
  
  def sorted : Map[Int, Seq[String]] = {
    SortedMap(internalDb.toArray:_*).mapValues(_.sorted)
  }
}