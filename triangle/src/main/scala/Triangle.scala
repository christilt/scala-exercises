

case class Triangle(a: Int, b: Int, c: Int) {
  import TriangleType._
  def triangleType: TriangleType = (a,b,c) match {
    case _ if a+b<=c || b+c<=a || c+a<=b => Illogical
    case _ if a<1 || b<1 || c<1          => Illogical
    case _ if a==b && b==c               => Equilateral
    case _ if a==b || b==c || c==a       => Isosceles
    case _                               => Scalene
  }
}

object TriangleType extends Enumeration {
  type TriangleType = Value
  val Equilateral, Isosceles, Scalene, Illogical = Value
}
