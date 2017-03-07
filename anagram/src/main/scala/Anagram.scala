

class Anagram(anagram : String) {
  val preparedAnagram = anagram.toLowerCase.toSeq.sorted
  
  def matches(candidates : Seq[String]) : Seq[String] = {
    candidates.filter(isNotIdentical)
              .filter(lengthsMatch)
              .filter(lettersMatch)
  }
  
  private def isNotIdentical(candidate : String) : Boolean = {
    anagram.toLowerCase != candidate.toLowerCase
  }
  
  private def lengthsMatch(candidate : String) : Boolean = {
    anagram.length == candidate.length
  }
  
  private def lettersMatch(candidate : String) : Boolean = {
    val preparedCandidate = candidate.toLowerCase.toSeq.sorted
    preparedCandidate.zip(preparedAnagram)
                     .forall{
                        case (c1,c2) => c1 == c2
                      }
  }
}