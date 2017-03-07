import scala.math.ScalaNumber

object Grains {
  def square(x: Int): Option[BigInt] = {
    if (x <= 0 || x > 64) None
    else Some(BigInt(2).pow(x-1))
  }
  def total: BigInt = {
    def totalR(tally: BigInt, x: Int): BigInt = x match {
      case 0 => tally
      case _ => totalR(tally + square(x).get, x-1)
    }
    totalR(0,64)
  }
}