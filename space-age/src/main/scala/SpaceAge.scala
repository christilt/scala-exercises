

case class SpaceAge(seconds: Long) {
  val earthYears: Double = seconds/31557600.00
  val onEarth: Double = round(earthYears)
  val ratio = 
    Map("mercury"   -> 0.2408467,
        "venus"     -> 0.61519726,
        "mars"      -> 1.8808158,
        "jupiter"   -> 11.862615,
        "saturn"    -> 29.447498,
        "uranus"    -> 84.016846,
        "neptune"   -> 164.79132)
  def onMercury: Double = age("mercury")
  def onVenus: Double   = age("venus")
  def onMars: Double    = age("mars")
  def onJupiter: Double = age("jupiter")
  def onSaturn: Double  = age("saturn")
  def onUranus: Double  = age("uranus")
  def onNeptune: Double = age("neptune")
  def age(planet: String): Double =
    round(earthYears/ratio(planet))
  def round(result: Double): Double =
    BigDecimal(result)
      .setScale(2, BigDecimal.RoundingMode.HALF_UP)
      .toDouble
}