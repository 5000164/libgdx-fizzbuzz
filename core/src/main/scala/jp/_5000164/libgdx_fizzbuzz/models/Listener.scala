package jp._5000164.libgdx_fizzbuzz.models

import com.badlogic.gdx.utils.TimeUtils

class Listener(status: Status) {
  def updateStatus(): Status = {
    val lastInputMilliSeconds = if (status.isInputKeyUp || status.isInputKeyRight || status.isInputKeyDown || status.isInputKeyLeft) TimeUtils.millis() else status.lastInputMilliSeconds
    val isExit = status.getElapsedSecondsFromLastInput >= 5
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
      status.isCorrect,
      isExit
    )
  }
}
