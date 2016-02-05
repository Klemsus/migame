package org.mie.game.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import org.mie.game.generators.LandscapeGenerator;

import static com.badlogic.gdx.physics.box2d.BodyDef.BodyType.StaticBody;

public class Island {

  private final int WORLD_SIZE = 1000;
  private final int PLAYER_W = 10;
  private final int PLAYER_H = 10;
  private final int BLOCK_W = 2;
  private final int BLOCK_H = 2;
  
  private final World world;
  private final LandscapeGenerator generator;
  private List<Model> map;
  private Player player;

  public Island() {
    world = new World(new Vector2(0, -98f), true);
    generator = new LandscapeGenerator(WORLD_SIZE);
    create();
  }
  
  private void create() {
    long[] blocks = generator.generate();
    Vector2 playerPos = generator.getPlayerPosition();
    player = new Player(null, makeBody(BodyType.DynamicBody, new Rectangle(playerPos.x, playerPos.y, 10, 10), 100));
    map = IntStream.range(0, blocks.length)
            .mapToObj(
              n -> new AbstractModel(null, makeBody(StaticBody, new Rectangle(n*BLOCK_W, blocks[n]*BLOCK_H, BLOCK_W, BLOCK_H), 100)))
            .collect(Collectors.<Model>toList());
  }
  
  private Body makeBody(BodyType type, Rectangle rect, float density) {
    BodyDef bd = new BodyDef();
    bd.type = type;
    Body body = world.createBody(bd);
    body.setTransform(rect.x, rect.y, 0);
    PolygonShape shape = new PolygonShape();
    shape.setAsBox(rect.width/2, rect.height/2);
    body.createFixture(shape, density);
    return body;
  }

  public List<Model> getMap() {
    return map;
  }

  public Player getPlayer() {
    return player;
  }
  
}
