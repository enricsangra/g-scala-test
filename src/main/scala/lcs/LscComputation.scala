package lcs


object LscComputation extends Computation[Char, Int] {
  override val initialValue: Int = 0
  override def computeCellValue(top: Int, left: Int, diagonal: Int, eq: Boolean): Int = {
    if (eq)
      diagonal + 1
    else
      Math.max(left, top)
  }
}
