package jp._5000164.libgdx_fizzbuzz.models

class FizzBuzz() {
  val fizz = 1
  val buzz = 2
  val fizzbuzz = 3
  val neither = 4

  def calculateFizzBuzz(i: Int): Int = {
    def f(j: Int, r: Int) = { (k: Int) => if (k % j == 0) r else 0 }

    val fizzFunction = f(3, fizz)
    val buzzFunction = f(5, buzz)
    val fizzbuzzResult = fizzFunction(i) + buzzFunction(i)

    if (fizzbuzzResult != 0) fizzbuzzResult else neither
  }
}