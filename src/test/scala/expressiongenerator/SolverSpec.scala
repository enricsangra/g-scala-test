package expressiongenerator

import org.scalatest._

class SolverSpec extends WordSpec with Matchers {
  "Solver" should {
    "solve" should {
      "return empty when" should {
        "the input sequence is empty" in {
          Solver.solve(List(), 10) shouldBe None
        }
        "the there is no possible result" in {
          Solver.solve(List(1, 2, 3), 10) shouldBe None
        }
      }
      "return a valid result when" should {
        "the target is in the list" in {
          Solver.solve(List(1, 2), 2).get.value shouldBe 2
        }
        "a number is result of a simple operation" in {
          Solver.solve(List(3, 2), 6).get.value shouldBe 6
        }
        "multiple operations are needed in a simple tree (every node has only a tree and a literal)" in {
          Solver.solve(List(1, 2, 3, 5), 30).get.value shouldBe 30
          Solver.solve(List(10, 10, 50), 30).get.value shouldBe 30
        }
        "multiple operations are needed in a complex tree (ndoes can have trees in both sides)" in {
          Solver.solve(List(2, 2, 5, 5), 25).get.value shouldBe 25
        }
      }
    }
  }
}
