package org.mie.game;



import org.mie.game.model.Island;
import org.mie.game.view.IslandRenderer;

import com.badlogic.gdx.ApplicationAdapter;

public class MIGame extends ApplicationAdapter {

  private float elapsedTime = 0;
  
  private IslandRenderer renderer;
  private Island island;

  @Override
  public void create() {
    island = new Island();
    renderer = new IslandRenderer(island, 800, 600);
  }

  @Override
  public void render() {
    // Advance the world, by the amount of time that has elapsed since the last frame
    // Generally in a real game, dont do this in the render loop, as you are tying the physics
    // update rate to the frame rate, and vice versa
    //world.step(Gdx.graphics.getDeltaTime(), 6, 2);

    //elapsedTime += Gdx.graphics.getDeltaTime();
    // You know the rest...

    renderer.render();
  }

  @Override
  public void dispose() {
    island.dispose();
  }
  
  

}
