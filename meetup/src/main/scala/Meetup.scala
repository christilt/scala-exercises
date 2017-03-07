import java.time.LocalDate

case class Meetup(month: Int, year : Int) {
  
  import java.time.{DayOfWeek => dow}
  
  val firstOfMonth = LocalDate.of(year,month,1)
  val length = firstOfMonth.lengthOfMonth
  val lastOfMonth = firstOfMonth.withDayOfMonth(length)
  
  def teenth(weekday: dow) : LocalDate = {
    def teenthR(result: LocalDate, weekday: dow): LocalDate =
      result.getDayOfMonth match {
        case n if (n >= 13 && n <= 19) => result
        case _ => teenthR(result.plusDays(7L),weekday)
      }
    teenthR(first(weekday),weekday)
  }
  
  def first(weekday : dow) : LocalDate = {
    def firstR(result: LocalDate, weekday: dow): LocalDate = {
        if (result.getDayOfWeek == weekday) result
        else firstR(result.plusDays(1L), weekday)
    }
    firstR(firstOfMonth, weekday)
  }
  
  def second(weekday: dow): LocalDate =
    first(weekday).plusDays(7L)
    
  def third(weekday: dow): LocalDate =
    second(weekday).plusDays(7L)
    
  def fourth(weekday: dow): LocalDate =
    third(weekday).plusDays(7L)
    
  def last(weekday: dow): LocalDate = {
    def lastR(result: LocalDate, weekday: dow): LocalDate =
        if (result.getDayOfWeek == weekday) result
        else lastR(result.minusDays(1L), weekday)
    lastR(lastOfMonth, weekday)
  }
}

object Meetup {
  val Mon = java.time.DayOfWeek.MONDAY
  val Tue = java.time.DayOfWeek.TUESDAY
  val Wed = java.time.DayOfWeek.WEDNESDAY
  val Thu = java.time.DayOfWeek.THURSDAY
  val Fri = java.time.DayOfWeek.FRIDAY
  val Sat = java.time.DayOfWeek.SATURDAY
  val Sun = java.time.DayOfWeek.SUNDAY
}