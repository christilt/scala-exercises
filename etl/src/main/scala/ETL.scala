

object ETL {
  def transform(old : Map[Int, Seq[String]]) : Map[String, Int] = {
    old.flatMap{ case (k,v) => v.map(_.toLowerCase -> k) }
  }
}