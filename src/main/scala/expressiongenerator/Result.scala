package expressiongenerator

sealed trait Result {
  def value: Int

  def multiply(right: Result): Result = Operation(this.value * right.value, "*", this, right)
  def add(right: Result): Result = Operation(this.value + right.value, "+", this, right)
  def subtract(right: Result): Result = Operation(this.value - right.value, "-", this, right)
}
object Result {
  def apply(value: Int): Result = Literal(value)
}

final case class Literal(override val value: Int) extends Result {
  override def toString: String = value.toString
}
final case class Operation(override val value: Int, op: String, left: Result, right: Result) extends Result {
  override def toString: String = s"(${left.toString} $op ${right.toString})"
}