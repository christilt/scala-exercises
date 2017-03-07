

class Bob {
  def hey (message : String) : String = {
    message match {
      case m if ignoring(m) => "Fine. Be that way!"
      case m if shouting(m) => "Whoa, chill out!"
      case m if questioning(m) => "Sure."
      case _ => "Whatever."
    }
  }
  
  private def ignoring (message : String) : Boolean = {
    message.trim().length() == 0
  }
  
  private def shouting (message : String) : Boolean = {
    message != message.toLowerCase() && message == message.toUpperCase()
  }
  
  private def questioning (message : String) : Boolean = {
    message.endsWith("?")
  }
}