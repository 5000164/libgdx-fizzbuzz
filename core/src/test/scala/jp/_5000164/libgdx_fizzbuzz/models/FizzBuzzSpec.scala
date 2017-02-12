package jp._5000164.libgdx_fizzbuzz.models

import org.scalatest.FreeSpec

class FizzBuzzSpec extends FreeSpec {

  trait Fixture {
    val fizzBuzz = new FizzBuzz
  }

  "FizzBuzz" - {
    "calculateFizzBuzz" - {
      "1 を渡したら 4 が返される" in new Fixture {
        assert(4 == fizzBuzz.calculateFizzBuzz(1))
      }

      "3 を渡したら 1 が返される" in new Fixture {
        assert(1 == fizzBuzz.calculateFizzBuzz(3))
      }

      "5 を渡したら 2 が返される" in new Fixture {
        assert(2 == fizzBuzz.calculateFizzBuzz(5))
      }

      "15 を渡したら 3 が返される" in new Fixture {
        assert(3 == fizzBuzz.calculateFizzBuzz(15))
      }

      "6 を渡したら 1 が返される" in new Fixture {
        assert(1 == fizzBuzz.calculateFizzBuzz(6))
      }

      "10 を渡したら 2 が返される" in new Fixture {
        assert(2 == fizzBuzz.calculateFizzBuzz(10))
      }

      "30 を渡したら 3 が返される" in new Fixture {
        assert(3 == fizzBuzz.calculateFizzBuzz(30))
      }
    }
  }
}