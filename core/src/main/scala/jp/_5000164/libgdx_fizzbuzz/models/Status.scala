package jp._5000164.libgdx_fizzbuzz.models

import scala.math.floor

class Status(
              val startMilliSeconds: Long,
              val nowMilliSeconds: Long,
              val displayString: String
            ) {
  def getElapsedSeconds: Int = {
    floor(((nowMilliSeconds - startMilliSeconds) / 1000).toDouble).toInt
  }
}
