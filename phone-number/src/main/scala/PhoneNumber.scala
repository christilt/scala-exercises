

class PhoneNumber(phoneNumber : String) {
  
  // Props to @bradfordboyle
  def number : Option[String] = {
    cleanNumber.toList match {
      case x if x.length < 10 => None
      case x if x.length == 10 => Some(x.mkString)
      case '1' :: x if x.length == 10 => Some(x.mkString)
      case _ => None
    }
  }
  
  def areaCode : Option[String] = {
    number.map(x => x.take(3))
  }
  
  def prettyPrint : Option[String] = {
    number.map(x => format(x))
  }
  
  private def cleanNumber : String = {
    phoneNumber.filter(_.isDigit)
  }
  
  private def format(raw : String) : String = {
    s"(${raw.take(3)}) ${raw.slice(3, 6)}-${raw.takeRight(4)}"
  }
}