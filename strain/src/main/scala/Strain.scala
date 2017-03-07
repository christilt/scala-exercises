

object Strain {
  
  def keep[T](seq : Seq[T], f : T => Boolean) : Seq[T] = {
    seq match {
      case Nil => seq
      case _ if f(seq.head) => seq.head +: keep(seq.tail, f)
      case _ if !f(seq.head) => keep(seq.tail, f)
    }
  }
  
  def discard[T](seq : Seq[T], f : T => Boolean) : Seq[T] = {
    seq.diff(keep(seq, f))
  }
  
}