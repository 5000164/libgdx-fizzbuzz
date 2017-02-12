package jp._5000164.libgdx_fizzbuzz.models

import com.badlogic.gdx.utils.TimeUtils

class Referee(status: Status) {
  def judge(): Status = {
    val isInputted = status.isInputKeyUp || status.isInputKeyRight || status.isInputKeyDown || status.isInputKeyLeft
    val isInputting = status.isInputted && isInputted
    val isCorrect = if (isInputted && !isInputting) checkingAnswers(status.isInputKeyUp, status.isInputKeyRight, status.isInputKeyDown, status.isInputKeyLeft, status.displayString) else false
    val lastInputMilliSeconds = if (isInputted && !isInputting) TimeUtils.millis() else status.lastInputMilliSeconds
    val isExit = if (status.getElapsedSeconds >= 10) {
      true
    } else {
      if (isInputting) {
        status.getElapsedSecondsFromLastInput >= 5
      } else {
        if (isInputted) {
          if (isCorrect) false else true
        } else {
          status.getElapsedSecondsFromLastInput >= 5
        }
      }
    }

    new Status(
      status.startMilliSeconds,
      status.nowMilliSeconds,
      lastInputMilliSeconds,
      status.displayString,
      status.isInputKeyUp,
      status.isInputKeyRight,
      status.isInputKeyDown,
      status.isInputKeyLeft,
      isInputted,
      isInputting,
      status.isInitial,
      isCorrect,
      isExit,
      if (isCorrect) status.correctCount + 1 else status.correctCount
    )
  }

  def checkingAnswers(isInputKeyUp: Boolean, isInputKeyRight: Boolean, isInputKeyDown: Boolean, isInputKeyLeft: Boolean, displayString: String): Boolean = {
    val fizzBuzz = new FizzBuzz
    val answer = fizzBuzz.calculateFizzBuzz(displayString.toInt)
    answer match {
      case fizzBuzz.fizz => isInputKeyLeft
      case fizzBuzz.buzz => isInputKeyRight
      case fizzBuzz.fizzbuzz => isInputKeyUp
      case fizzBuzz.neither => isInputKeyDown
      case _ => false
    }
  }
}
