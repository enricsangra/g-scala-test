package lcs

trait Computation[A, B] {
  def initialValue: B
  def computeCellValue(top: B, left: B, diagonal: B, eq: Boolean): B

  def compute(left: Seq[A], right: Seq[A]): Vector[Vector[B]] = {
    val firstLine: Vector[B] = Vector.fill(right.length + 1)(initialValue)

    def nextLine(c: A, s: Seq[A], previousLine: Vector[B]): Vector[B] = {
      (1 until s.length + 1).foldLeft(Vector(initialValue)) { (acc, i) =>
        val value: B = computeCellValue(acc.last, previousLine(i), previousLine(i-1), s(i-1) equals c)
        acc :+ value
      }
    }

    left.foldLeft(Vector[Vector[B]](firstLine))((acc, c) => acc :+ nextLine(c, right, acc.last))
  }
}
