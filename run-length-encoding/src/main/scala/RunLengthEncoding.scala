object RunLengthEncoding {
  
  val contiguousLettersSeparator = "(?<=(.))(?!\\1)"
  val letterNumberSeparator = "(?<=\\D)(?=\\d)|(?<=\\D)(?=\\D)"
  val multiplierPattern = "(\\d)+".r
  val letterPattern = "(\\D){1}".r

  def encode (str: String): String = {
    str.split(contiguousLettersSeparator)
       .map{ group => encodeGroup(group) }
       .mkString("")
  }
  
  def encodeGroup (group : String) : String = {
    if (group.length > 1) s"${group.length}${group.charAt(0)}"
    else if (group.length == 1) s"${group.charAt(0)}"
    else ""
  }

  def decode (str: String): String = {
    str.split(letterNumberSeparator)
       .map{ group => decodeGroup(group) }
       .mkString("")
  }
  
  def decodeGroup (group : String) : String = {
    val multiplier = multiplierPattern.findFirstIn(group).getOrElse("1").toInt
    val letter = letterPattern.findFirstIn(group).getOrElse("")
    letter * multiplier
  }
}
