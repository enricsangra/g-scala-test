package lcs

import org.scalatest._

class LscSolverSpec extends WordSpec with Matchers {
  "lsc solver" should {
    "solve the problem with empty inputs" in {
      LscSolver.lsc("", "") shouldBe ""
    }
    "solve a simple no common sequence" in {
      LscSolver.lsc("A", "B") shouldBe ""
    }
    "solve a simple common sequence" in {
      LscSolver.lsc("A", "A") shouldBe "A"
    }
    "solve a straight common sequence in the beginning" in {
      LscSolver.lsc("AAA", "AABB") shouldBe "AA"
    }
    "solve a straight common sequence in the middle" in {
      LscSolver.lsc("AAA", "BAABB") shouldBe "AA"
    }
    "solve a straight common sequence in the end" in {
      LscSolver.lsc("AAA", "BCBAA") shouldBe "AA"
    }
    "solve a substring problem" in {
      LscSolver.lsc("AAA", "BCCEAAABB") shouldBe "AAA"
    }
    "solve a common sequence which is not together" in {
      LscSolver.lsc("ABA", "CACBCAC") shouldBe "ABA"
    }
  }
}
