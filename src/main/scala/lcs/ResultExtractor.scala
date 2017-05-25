package lcs

trait ResultExtractor[A, B, C] {
  def extract(left: Seq[A], right: Seq[A], matrix: Vector[Vector[B]]): C
}
