package jp._5000164.libgdx_fizzbuzz.models

class Question(status: Status) {
  def renderQuestion(): String = {
    "test"
  }

  def renderElapsedSeconds(): String = {
    ((status.nowMilliSeconds - status.startMilliSeconds) / 1000).toString
  }
}
