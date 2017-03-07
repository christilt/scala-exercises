

case class Year (year : Int) {
  def isLeap: Boolean = 
    divisibleBy(400) ||
    divisibleBy(4) && !divisibleBy(100)
  def divisibleBy(x: Int): Boolean = 
    year % x == 0
}