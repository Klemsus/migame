package org.mie.game.generators;

import java.util.Random;
import java.util.stream.LongStream;

import com.badlogic.gdx.math.Vector2;

        
/**
 *
 * @author Cerber
 */
public class LandscapeGenerator {

  private final int width;

  public LandscapeGenerator(int width) {
    this.width = width;
  }
  
  public Vector2 getPlayerPosition() {
    return null;
  }
  
  public long[] generate() {
    return generate(System.currentTimeMillis());
  }
  
  public long[] generate(long seed) {
    double random = new Random(seed).nextDouble();
    return LongStream.range(0, width).map((l) -> (long) PerlinNoise.of(random + l)).toArray();
  }
  
  
//std::vector<std::vector<int> > GenerateMap(int seed, int width, int height, int &playerx, int &playery)
//{
//    std::vector<std::vector<int> > map = std::vector<std::vector<int> >(height,std::vector<int>(width,0));
//    int step = width/50;
//    int empty = height/1.5;
//    int soil = height/10;
//    int sand = height/20;
//    int clay = height/20;
//    int rock = height/5;
//    if (!seed) seed=clock();
//    srand(seed);
//    int random=rand()%width;
//    int prev_limit=height, max_limit=0, min_limit=height;
//    //Main landscape generation
//    for (int j=0; j<width; j++)
//    {
//        int limit=PerlinNoise(float(j+random)/step+1)*empty/2+empty/2;
//        if (limit<min_limit)
//        {
//            playerx=j;
//            playery=limit-1;
//        }
//        max_limit=std::max(limit,max_limit);
//        min_limit=std::min(limit,min_limit);
//        for (int i=0;i<limit-1;i++)
//        {
//            map[i][j]=BLK_EMPTY;//blockName["empty"];
////            physic_map[i][j].light_power=0;
//        }
//        //map[limit-1][j]=blockName["grass"];
//        map[limit][j]=BLK_HUMUS;//blockName["humus"];
//        //Random water block if landscape goes down
//        if ((prev_limit<limit)&&((rand()%100)<=2))
//        {
//            map[limit-1][j]=BLK_WATER;//blockName["water"];
//        }
//        prev_limit=limit;
//        //soil layer
//        int soil_limit=PerlinNoise(float(j+random+width)/step+1)*soil/2+soil/2;
//        for (int i=limit+1;i<limit+soil_limit+1;i++) map[i][j]=BLK_SOIL;//blockName["soil"];
//        //sand layer
//        limit+=soil_limit;
//        int sand_limit=PerlinNoise(float(j+random+2*width)/step+1)*(sand+soil)/2;//+sand/2;
//        for (int i=std::min(limit,limit+sand_limit)+1;i<std::max(limit,limit+sand_limit)+1;i++) map[i][j]=BLK_SAND;//blockName["sandstone"];
//        //clay layer
//        limit=std::max(limit,limit+sand_limit);
//        int clay_limit=PerlinNoise(float(j+random+3*width)/step+1)*(clay+sand)/2;//+clay/2;
//        for (int i=std::min(limit,limit+clay_limit)+1;i<std::max(limit,limit+clay_limit)+1;i++) map[i][j]=BLK_CLAY;//blockName["clay"];
//        //rock layer
//        limit=std::max(limit,limit+clay_limit);
//        int rock_limit=PerlinNoise(float(j+random+4*width)/step+1)*(rock+clay)/2;//+limestone/2;
//        for (int i=std::min(limit,limit+rock_limit)+1;i<height;i++) map[i][j]=BLK_ROCK;
//    }
////    selectx=playerx;
////    selecty=playery;
//    /*/Water spread
//    for (int j=0; j<width; j++)
//        for (int i=min_limit; i<max_limit; i++)
//        {
//            if (map[i][j]==BLK_WATER)//blockName["water"])
//            {
//                //if ((map[i-1][j]==blockName["swamp"])||(map[i+1][j]==blockName["swamp"])||
//                //    (map[i][j-1]==blockName["swamp"])||(map[i][j+1]==blockName["swamp"])) map[i][j]=blockName["swamp"];
//                if (map[i+1][j]<100) map[i+1][j]=BLK_WATER;//blockName["water"];
//                if (map[i][j+1]<100) map[i][j+1]=BLK_WATER;//blockName["water"];
//            }
//        }
//*/
//    return map;
//}

}
