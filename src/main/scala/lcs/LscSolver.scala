package lcs

object LscSolver extends DynamicProblemSolver[Char, Int, String] {
  override val computation: Computation[Char, Int] = LscComputation
  override val extractor: ResultExtractor[Char, Int, String] = LscResultExtractor

  def lsc(left: String, right: String): String = this.solve(left, right)
}

