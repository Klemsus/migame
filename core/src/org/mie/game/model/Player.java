package org.mie.game.model;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.Body;

public class Player extends AbstractModel {

  public Player(TextureRegion textureRegion, Body body) {
    super(textureRegion, body);
  }
  
  public enum State {
    STAND,
    WALKING,
    TIRED,
    RUNNING,
    FAST_RUNNING,
    WORKING
  }

}
