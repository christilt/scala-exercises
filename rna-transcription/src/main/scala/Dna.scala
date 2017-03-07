

object Dna {
  
  def toRna(x: String): Option[String] = x.foldRight(Option("")) {
    case (head, resultOpt) => for {
      nucleotide <- transcribe(head)
      result     <- resultOpt
    } yield nucleotide +: result
  }
  
  private def transcribe(x: Char): Option[Char] = x match {
    case 'G' => Some('C')
    case 'C' => Some('G')
    case 'T' => Some('A')
    case 'A' => Some('U')
    case _   => None
  }
  
}