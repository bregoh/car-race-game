package Maincarrace;

import System.LoadImage;
import System.SpriteSheet;
import java.awt.image.BufferedImage;

public class Assets {

    //create spritesheet object
    SpriteSheet blocks = new SpriteSheet();
    public static SpriteSheet player = new SpriteSheet();
    
    //buffered images for block types
    public static BufferedImage grass;
    public static BufferedImage sand;
    public static BufferedImage road;
    public static BufferedImage whiteLine;
    public static BufferedImage finishLine, halfWay;
    
    public void init() {
        
        //load spritesheet
        blocks.setSpriteSheet(LoadImage.LoadImageFrom(MainF.class, "images/spritesheet.png"));
        player.setSpriteSheet(LoadImage.LoadImageFrom(MainF.class, "images/Player.png"));
        
        //load map block images
        grass = blocks.getTile(0, 0, 16, 16);
        sand = blocks.getTile(16, 16, 16, 16);
        road = blocks.getTile(16, 0, 16, 16);
        whiteLine = blocks.getTile(0, 16, 16, 16);
        finishLine = blocks.getTile(32, 0, 16, 16);
        halfWay = blocks.getTile(32, 16, 16, 16);
        
    }
    
    //METHODS TO GET BLOCK TYPES
    public static BufferedImage getGrass(){
        return grass;
    }
    
    public static BufferedImage getSand(){
        return sand;
    }
    
    public static BufferedImage getRoad(){
        return road;
    }
    
    public static BufferedImage getWhiteLine(){
        return whiteLine;
    }
    
    public static BufferedImage getHalfWay() {
        return halfWay;
    }
    public static BufferedImage getFinishLine() {
        return finishLine;
    }
}
