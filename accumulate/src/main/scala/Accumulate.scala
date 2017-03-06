

class Accumulate {
  def accumulate[A,B](f: A => B, x: List[A]): List[B] = {
    def loop(result: List[B], f: A => B, x: List[A]): List[B] =
      x match {
        case Nil => result.reverse
        case h :: tail => loop(f(h) :: result, f, tail)
      }
    loop(List[B](),f,x)
  }
}