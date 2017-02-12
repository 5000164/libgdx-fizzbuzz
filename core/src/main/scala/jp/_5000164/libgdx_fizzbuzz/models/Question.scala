package jp._5000164.libgdx_fizzbuzz.models

import scala.util.Random

class Question(status: Status) {
  def generate(): Status = {
    if (!status.isInputting && status.isCorrect || status.isInitial) {
      new Status(
        status.startMilliSeconds,
        status.nowMilliSeconds,
        status.lastInputMilliSeconds,
        generateNewNumber().toString,
        status.isInputKeyUp,
        status.isInputKeyRight,
        status.isInputKeyDown,
        status.isInputKeyLeft,
        status.isInputted,
        status.isInputting,
        false,
        false,
        status.isExit
      )
    } else {
      status
    }
  }

  def generateNewNumber(): Int = {
    (new Random).nextInt(30) + 1
  }
}
