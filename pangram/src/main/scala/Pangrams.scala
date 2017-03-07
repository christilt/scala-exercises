

object Pangrams {
  def isPangram(pangram : String) : Boolean = {
    ('a' to 'z').forall(pangram.toLowerCase.contains(_))
  }
}