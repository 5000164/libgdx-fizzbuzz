package jp._5000164.libgdx_fizzbuzz

import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}
import com.badlogic.gdx.graphics.{Color, GL20}
import com.badlogic.gdx.utils.TimeUtils
import com.badlogic.gdx.{Game, Gdx, Input}
import jp._5000164.libgdx_fizzbuzz.models.{Question, Referee, Status}

class View extends Game {
  var batch: SpriteBatch = _
  var font: BitmapFont = _
  var globalStatus: Status = _

  override def create(): Unit = {
    globalStatus = new Status(
      TimeUtils.millis(),
      TimeUtils.millis(),
      TimeUtils.millis(),
      "",
      false,
      false,
      false,
      false,
      false,
      false,
      true,
      false,
      false,
      0
    )

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

    globalStatus = new Status(
      globalStatus.startMilliSeconds,
      TimeUtils.millis(),
      globalStatus.lastInputMilliSeconds,
      globalStatus.displayString,
      Gdx.input.isKeyPressed(Input.Keys.UP),
      Gdx.input.isKeyPressed(Input.Keys.RIGHT),
      Gdx.input.isKeyPressed(Input.Keys.DOWN),
      Gdx.input.isKeyPressed(Input.Keys.LEFT),
      globalStatus.isInputted,
      globalStatus.isInputting,
      globalStatus.isInitial,
      globalStatus.isCorrect,
      globalStatus.isExit,
      globalStatus.correctCount
    )

    val referee = new Referee(globalStatus)
    globalStatus = referee.judge()
    if (globalStatus.isExit) {
      Gdx.app.exit()
    }

    val question = new Question(globalStatus)
    globalStatus = question.generate()

    font.draw(batch, globalStatus.displayString, 390, 230)
    font.draw(batch, globalStatus.correctCount.toString, 20, 470)
    font.draw(batch, globalStatus.getElapsedSeconds.toString, 780, 470)

    batch.end()
  }
}
