package org.mie.game.view;

import java.util.stream.IntStream;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import org.mie.game.model.Island;

public class IslandRenderer {
  private final OrthographicCamera camera;
  private final ShapeRenderer renderer = new ShapeRenderer();
  private final Island island;

  public IslandRenderer(Island island, int screen_w, int screen_h) {
    this.island = island;
    camera = new OrthographicCamera();
    camera.setToOrtho(false, screen_w, screen_h);
  }
  
  public void setCamera(float x, float y) {
    camera.position.set(x, y, 0);
    camera.update();
  }
  
  public void render() {
    renderer.setProjectionMatrix(camera.combined);
    drawBlocks();
    drawPlayer();
  }

  private void drawBlocks() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  private void drawPlayer() {
    island.getPlayer()
  }
  
  private void drawBlock(Body body, Color col) {
    renderer.begin(ShapeType.Filled);
    renderer.setColor(col);
    PolygonShape shape = (PolygonShape) body.getFixtureList().get(0).getShape();
    IntStream.range(0, shape.getVertexCount()).map(shape.)
    renderer.polygon(((PolygonShape)body.getFixtureList().first().getShape())., offset, count);
    renderer.end();
  }
  
}
