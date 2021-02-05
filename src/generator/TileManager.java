package generator;

import Objects.Player;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class TileManager {
    
    //create an array list for blocks
    public static ArrayList<Block> blocks = new ArrayList<Block>();
    
    //tick blocks
    public void tick(double deltaTime)
    {
        for(Block block : blocks){
            block.tick(deltaTime);
            if(Player.render.intersects(block)) {
                block.setAlive(true);
            }
            else {
                block.setAlive(false);
            }
            //block.pos.add(new Vector2F(0, 0));
        }
    }
    
    //render blocks
    public void render(Graphics2D g){
        for(Block block : blocks){
            block.render(g);
        }
    }
}
