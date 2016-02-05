package org.mie.game.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public interface Model {
  
  Rectangle getBounds();
  Vector2 getPosition();
  Texture getTexture();
  
}
