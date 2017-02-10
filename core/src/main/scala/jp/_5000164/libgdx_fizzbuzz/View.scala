package jp._5000164.libgdx_fizzbuzz

import com.badlogic.gdx.graphics.g2d.{BitmapFont, SpriteBatch}
import com.badlogic.gdx.graphics.{Color, GL20}
import com.badlogic.gdx.{Game, Gdx}

class View extends Game {
  var batch: SpriteBatch = _
  var font: BitmapFont = _

  override def create(): Unit = {
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
    batch.end()
  }
}
