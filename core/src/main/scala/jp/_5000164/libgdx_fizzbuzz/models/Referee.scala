package jp._5000164.libgdx_fizzbuzz.models

import com.badlogic.gdx.utils.TimeUtils

class Referee(status: Status) {
  def judge(): Status = {
    val isInputted = status.isInputKeyUp || status.isInputKeyRight || status.isInputKeyDown || status.isInputKeyLeft
    val isInputting = status.isInputted && isInputted
    val isCorrect = if (isInputted && !isInputting) true else false
    val lastInputMilliSeconds = if (isInputted && !isInputting) TimeUtils.millis() else status.lastInputMilliSeconds
    val isExit = if (isInputting) {
      status.getElapsedSecondsFromLastInput >= 5
    } else {
      if (isInputted) {
        if (isCorrect) false else true
      } else {
        status.getElapsedSecondsFromLastInput >= 5
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
}
