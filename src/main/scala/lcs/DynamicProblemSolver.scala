package lcs

trait DynamicProblemSolver[A, B, C] {
  def computation: Computation[A, B]
  def extractor: ResultExtractor[A, B, C]

  def solve(left: Seq[A], right: Seq[A]): C = extractor.extract(left, right, computation.compute(left, right))
}
