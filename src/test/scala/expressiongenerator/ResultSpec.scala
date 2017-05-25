package expressiongenerator

import org.scalatest._

class ResultSpec extends WordSpec with Matchers{
  "Result" should {
    "constructor" should {
      "create a Result with the value passed" in {
        Result(1).value shouldBe 1
      }
    }
    "Multiply" should {
      "create a Result with the value of both trees multiplied" in {
        (Result(4) multiply Result(5)).value shouldBe 20
      }
    }
    "Add" should {
      "create a Result with the value of both trees added" in {
        (Result(3) add Result(8)).value shouldBe 11
      }
    }
    "Subtract" should {
      "create a Result with the value of both trees subtracted" in {
        (Result(11) subtract Result(6)).value shouldBe 5
      }
    }
    "toString" should {
      "when the Result is a" should {
        "literal" should {
          "writes the value" in {
            Result(4).toString shouldBe "4"
          }
        }
        "simple tree" should {
          "mulitplication writes both values with the * sign between them" in {
            (Result(4) multiply Result(5)).toString shouldBe "(4 * 5)"
          }
          "addition writes both values with the + sign between them" in {
            (Result(4) add Result(5)).toString shouldBe "(4 + 5)"
          }
          "substraction writes both values with the + sign between them" in {
            (Result(4) subtract Result(5)).toString shouldBe "(4 - 5)"
          }
        }
        "complex tree" should {
          "writes left and right trees together" in {
            (Result(2) add Result(4) multiply Result(3)).toString shouldBe "((2 + 4) * 3)"
          }
        }
      }
    }
  }
}
