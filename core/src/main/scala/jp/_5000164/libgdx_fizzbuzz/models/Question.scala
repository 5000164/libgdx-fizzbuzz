package jp._5000164.libgdx_fizzbuzz.models

class Question(status: Status) {
  def renderQuestion(): String = {
    "test"
  }

  def renderElapsedSeconds(): String = {
    status.getElapsedSeconds.toString
  }
}
