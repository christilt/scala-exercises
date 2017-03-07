class DNA(input: String) {

  private val dna = Map('G'->0, 'A'->0, 'C'->0, 'T'->0)
  private val dna2 = Set('G','A','C','T')
  private val dna3 = "GACT"
  def nucleotideCounts: Either[String, Map[Char, Int]] = for {
    x <- input.map(validate)
    y <- x.right
  } yield tally(y)
  
  private def tally(validInput: Array[Char]) : Map[Char,Int] = {
    dna3.foldLeft(Map[Char, Int]()) { 
      (z, x) => z ++ Map[Char, Int](x -> validInput.count(_ == x))
    }
  }
  
  def count(x : Char): Either[String, Int] = for {
    validated <- validate(x).right
  } yield input.filter(_ == validated).length
  
  private def validate(x : Char) : Either[String,Char] = {
    if (dna.contains(x)) Right(x)
    else Left(s"invalid nucleotide \'${x}\'")
  }
  /*
  private def isInvalidNucleotide(char : Char) : Boolean = {
    !validNucleotides.contains(char)
  }
  
  private def findFirstInvalidNucleotideInDna : Option[Char] = {
    dna.filter(isInvalidNucleotide)
       .headOption
  }
  
  private def tallyValidNucleotide(char : Char) : Int = {
    dna.count(_ == char)
  }
  
  private def tallyValidNucleotides: Map[Char, Int] = {
    validNucleotides.toSeq
                    .groupBy(identity)
                    .mapValues(x => tallyValidNucleotide(x.head))
  }
  */
}
