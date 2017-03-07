import scala.annotation.tailrec

object Hamming {
  
  def compute(a : String, b : String) : Option[Int] = {
    tallyDifferences(a.toList, b.toList, 0)
  }

  @tailrec
  private def tallyDifferences(a : List[Char], b : List[Char], tally : Int) : Option[Int] = {
    (a, b) match {
      case (Nil, Nil) => Some(tally)
      case (a :: aTail, b :: bTail) if (a == b) => tallyDifferences(aTail, bTail, tally)
      case (a :: aTail, b :: bTail) if (a != b) => tallyDifferences(aTail, bTail, tally+1)
      case _ => None
    }
  }
}