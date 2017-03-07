

object Sublist extends Enumeration {
  type Sublist = Value
  val Equal, Sublist, Superlist, Unequal = Value
  def sublist[T](a: List[T], b: List[T]): Sublist =
    (a,b) match {
      case (x,y) if x eq y   => Equal
      case (x,y) if sub(x,y) => Sublist
      case (x,y) if sub(y,x) => Superlist
      case _                 => Unequal
    }
  private def sub[T](a: List[T], b: List[T]): Boolean = {
    val intersect = a.intersect(b)
    a == intersect && b.containsSlice(intersect)
  }
}