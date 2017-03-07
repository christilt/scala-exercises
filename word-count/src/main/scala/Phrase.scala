

class Phrase (content : String) {
  val divider = "[\\W&&[^']]+"
  def wordCount() : Map[String,Int] = {
    content.toLowerCase()
           .split(divider)
           .groupBy(identity)
           .mapValues(_.size)
  }
}