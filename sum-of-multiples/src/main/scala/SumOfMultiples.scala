object SumOfMultiples {
  def sumOfMultiples(factors: Set[Int], limit: Int): Int = {
    factors.flatMap { x => multiples(x, limit) }
           .sum
  }
  
  def multiples (factor : Int, limit : Int) : Set[Int] = {
    (factor to limit-1 by factor).toSet
  }
}

