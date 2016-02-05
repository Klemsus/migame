package org.mie.game;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class MIGame extends ApplicationAdapter {

  private float elapsedTime = 0;
  
  private final ShapeRenderer renderer = new ShapeRenderer();

  @Override
  public void create() {
  }

  @Override
  public void render() {
    // Advance the world, by the amount of time that has elapsed since the last frame
    // Generally in a real game, dont do this in the render loop, as you are tying the physics
    // update rate to the frame rate, and vice versa
    world.step(Gdx.graphics.getDeltaTime(), 6, 2);

    elapsedTime += Gdx.graphics.getDeltaTime();
    // You know the rest...
    Gdx.gl.glClearColor(1, 1, 1, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    renderer.begin(ShapeType.Filled);
    renderer.setColor(new Color(0, 0, 0, 1));
    map.forEach((l) -> renderer.rect(elapsedTime, elapsedTime, elapsedTime, elapsedTime));
    renderer.end();
  }
}
