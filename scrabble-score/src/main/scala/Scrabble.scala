

object Scrabble {
  def scoreLetter(l: Char): Int = l.toLower match {
    case 'a' | 'e' | 'i' | 'o' | 'u' |
         'l' | 'n' | 'r' | 's' | 't'   => 1
    case 'd' | 'g'                     => 2
    case 'b' | 'c' | 'm' | 'p'         => 3
    case 'f' | 'h' | 'v' | 'w' | 'y'   => 4
    case 'k'                           => 5
    case 'j' | 'x'                     => 8
    case 'q' | 'z'                     => 10
  }
  def scoreWord(w: String): Int =
    w.map(scoreLetter).sum
}