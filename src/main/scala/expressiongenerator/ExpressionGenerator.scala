package expressiongenerator

import scala.io.StdIn

object ExpressionGenerator {
  def main(args: Array[String]): Unit = {
    println("Enter as many numbers as you want all separated by spaces")
    val bag: List[Int] = StdIn.readLine().asInstanceOf[String].split(" ").map(_.toInt).toList
    println("Enter a target integer to generate")
    val target: Int = StdIn.readLine().asInstanceOf[String].toInt

    val operation: Option[Result] = Solver.solve(bag, target)
    println(operation.fold("Sorry. There is no possible combination.")(op => s"A possible operation would be: $op"))
  }
}
