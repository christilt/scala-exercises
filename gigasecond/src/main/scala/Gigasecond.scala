import java.time.{LocalDate => LD}
import java.time.{LocalDateTime => LDT}

object Gigasecond {
  def addGigaseconds(x: LD): LDT = addGigaseconds(x.atStartOfDay)
  def addGigaseconds(x: LDT): LDT = x.plusSeconds(1000000000)
}