package lcs

import scala.annotation.tailrec

object LscResultExtractor extends ResultExtractor[Char, Int, String] {
  override def extract(left: Seq[Char], right: Seq[Char], matrix: Vector[Vector[Int]]): String = {

    @tailrec
    def loop(pos: (Int, Int), acc: Seq[Char]): Seq[Char] = pos match {
      case (i, j) if i > 0 && j > 0 =>
        val (nextPos, letter) =
          if (matrix(i-1)(j-1) == matrix(i)(j) - 1) ((i-1, j-1), Some(left(i - 1)))
          else ((i-1, j), Option.empty[Char])

        loop(nextPos, letter.map(_.toString).fold(acc)(c => c + acc))
      case _ => acc
    }

    loop((left.length, right.length), "").toString
  }
}
