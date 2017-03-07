class Robot {
  private var state = Robot.randomName(2,3)
  def name : String = state
  def reset() : Unit = { state = Robot.randomName(2,3) }
}

object Robot {
  def randomName(noLetters : Int, noNumbers : Int) : String = {
    def randomNameR(name : String, n: Int): String = n match {
      case n if n > noNumbers => randomNameR(name + randomChar(('A' to 'Z')), n-1)
      case n if n > 0 => randomNameR(name + randomChar(('0' to '9')), n-1)
      case _ => name
    }
    def randomChar(chars : Seq[Char]): Char =
      chars(util.Random.nextInt(chars.length))
    randomNameR("", noLetters + noNumbers) 
  }
}
