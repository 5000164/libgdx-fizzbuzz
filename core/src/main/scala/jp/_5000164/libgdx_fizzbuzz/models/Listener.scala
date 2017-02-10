package jp._5000164.libgdx_fizzbuzz.models

import com.badlogic.gdx.Gdx

class Listener(status: Status) {
  def continueOrExit(): Unit = {
    if (status.getElapsedSeconds >= 5) {
      Gdx.app.exit()
    }
  }
}
