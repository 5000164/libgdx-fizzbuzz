package jp._5000164.libgdx_fizzbuzz

import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}
import com.badlogic.gdx.graphics.{Color, GL20}
import com.badlogic.gdx.utils.TimeUtils
import com.badlogic.gdx.{Game, Gdx}
import jp._5000164.libgdx_fizzbuzz.models.{Question, Status}

class View extends Game {
  var batch: SpriteBatch = _
  var font: BitmapFont = _
  var globalStatus: Status = _

  override def create(): Unit = {
    globalStatus = new Status(TimeUtils.millis(), TimeUtils.millis(), "")

    batch = new SpriteBatch
    font = new BitmapFont
    font.setColor(Color.RED)
  }

  override def dispose(): Unit = {
    batch.dispose()
    font.dispose()
  }

  override def render(): Unit = {
    Gdx.gl.glClearColor(1, 1, 1, 1)
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

    batch.begin()

    val status = new Status(globalStatus.startMilliSeconds, TimeUtils.millis(), globalStatus.displayString)
    val question = new Question(status)

    font.draw(batch, question.renderQuestion(), 390, 230)
    font.draw(batch, question.renderElapsedSeconds(), 780, 470)

    batch.end()
  }
}
