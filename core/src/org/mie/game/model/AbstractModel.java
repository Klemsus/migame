package org.mie.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

public class AbstractModel implements Model {

  private final TextureRegion textureRegion;
  private final Body body;

  public AbstractModel(TextureRegion textureRegion, Body body) {
    this.textureRegion = textureRegion;
    this.body = body;
  }
  
  @Override
  public Rectangle getBounds() {
    return new Rectangle(0,0,textureRegion.getRegionWidth(), textureRegion.getRegionHeight());
  }

  @Override
  public Vector2 getPosition() {
    return body.getPosition();
  }

  @Override
  public Texture getTexture() {
    return textureRegion.getTexture();
  }

}
