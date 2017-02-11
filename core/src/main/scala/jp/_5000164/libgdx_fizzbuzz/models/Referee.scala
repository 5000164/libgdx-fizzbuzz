package jp._5000164.libgdx_fizzbuzz.models

import com.badlogic.gdx.utils.TimeUtils

class Referee(status: Status) {
  def judge(): Status = {
    val isInputted = status.isInputKeyUp || status.isInputKeyRight || status.isInputKeyDown || status.isInputKeyLeft
    val isCorrect = if (isInputted) true else false
    val lastInputMilliSeconds = if (isInputted) TimeUtils.millis() else status.lastInputMilliSeconds
    val isExit = if (isInputted) if (isCorrect) false else true else status.getElapsedSecondsFromLastInput >= 5
    new Status(
      status.startMilliSeconds,
      status.nowMilliSeconds,
      lastInputMilliSeconds,
      status.displayString,
      status.isInputKeyUp,
      status.isInputKeyRight,
      status.isInputKeyDown,
      status.isInputKeyLeft,
      status.isInitial,
      isCorrect,
      isExit
    )
  }
}
