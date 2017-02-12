package jp._5000164.libgdx_fizzbuzz.models

import scala.math.floor

class Status(
              val startMilliSeconds: Long,
              val nowMilliSeconds: Long,
              val lastInputMilliSeconds: Long,
              val displayString: String,
              val isInputKeyUp: Boolean,
              val isInputKeyRight: Boolean,
              val isInputKeyDown: Boolean,
              val isInputKeyLeft: Boolean,
              val isInputted: Boolean,
              val isInputting: Boolean,
              val isInitial: Boolean,
              val isCorrect: Boolean,
              val isExit: Boolean,
              val correctCount: Int
            ) {
  def getElapsedSeconds: Int = {
    floor(((nowMilliSeconds - startMilliSeconds) / 1000).toDouble).toInt
  }

  def getElapsedSecondsFromLastInput: Int = {
    floor(((nowMilliSeconds - lastInputMilliSeconds) / 1000).toDouble).toInt
  }
}
