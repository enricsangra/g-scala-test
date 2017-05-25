package expressiongenerator

object Solver {
  def combineWithSeq(r1: (Result, Seq[Int]), r2: (Result, Seq[Int])): Seq[(Result, Seq[Int])] = List(
    (r1._1 multiply r2._1, r1._2 ++ r2._2),
    (r1._1 add r2._1, r1._2 ++ r2._2),
    (r1._1 subtract r2._1, r1._2 ++ r2._2)
  )
  def isValidIntermediateResult(r: Result): Boolean = r.value >= 0
  def isFinalResult(target: Int)(r: Result): Boolean = r.value == target

  def allCombinations(is: Seq[Int], target: Int): Seq[(Result, Seq[Int])] = is flatMap { i =>
    val trees = for {
      (r1, s1) <- allCombinations(is diff Seq(i), target) if isValidIntermediateResult(r1)
      (r2, s2) <- allCombinations(is diff s1, target) if isValidIntermediateResult(r2)
      (r, s) <- combineWithSeq((r1, s1), (r2, s2)) if isValidIntermediateResult(r)
    } yield (r, s)

    (Result(i), Seq(i)) +: trees
  }

  def solve(is: Seq[Int], target: Int): Option[Result] = {
    allCombinations(is, target).map(_._1).find(isFinalResult(target))
  }
}
