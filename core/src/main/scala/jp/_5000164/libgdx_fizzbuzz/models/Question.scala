package jp._5000164.libgdx_fizzbuzz.models

class Question(status: Status) {
  def generate(): Status = {
    new Status(
      status.startMilliSeconds,
      status.nowMilliSeconds,
      status.lastInputMilliSeconds,
      "test",
      status.isInputKeyUp,
      status.isInputKeyRight,
      status.isInputKeyDown,
      status.isInputKeyLeft,
      status.isExit
    )
  }
}
