package generator;

import Maincarrace.Assets;
import System.Vector2F;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage; 

public class Block extends Rectangle {
    
    Vector2F pos = new Vector2F();
    private int BlockSize = 28; //set block size
    private BlockType blocktype; 
    private BufferedImage block;
    private boolean isSolid, isHalfWay, isFinishLine; //detect collision
    private boolean isAlive; 
    
    //constructor
    public Block(Vector2F pos, BlockType blocktype) {
        setBounds((int)pos.xpos, (int)pos.ypos, BlockSize, BlockSize);
        this.pos = pos;
        isAlive = true;
        this.blocktype = blocktype;
        init();
    }
    
    //METHODS TO DETECT COLLISION
    public Block isSolid(boolean isSolid) {
        this.isSolid = isSolid;
        return this;
    }
    
    public Block isHalfWay(boolean isHalfWay) {
        this.isHalfWay = isHalfWay;
        return this;
    }
    
    public Block isFinishLine(boolean isFinishLine) {
        this.isFinishLine = isFinishLine;
        return this;
    }
    
    //call all block types
    public void init() {
      switch(blocktype) {
          case grass:
              block = Assets.getGrass(); 
              break;
          case road:
              block = Assets.getRoad();
              break;
          case whiteLine:
              block = Assets.getWhiteLine();
              break;
          case finishLine:
              block = Assets.getFinishLine();
              break;
          case sand:
              block = Assets.getSand();
              break;
          case halfWay:
              block = Assets.getHalfWay();
              break;
      }  
    }
    
    //tick method
    public void tick(double deltaTime) {
        if(isAlive){
            setBounds((int)pos.xpos, (int)pos.ypos, BlockSize, BlockSize);
        }
        
    }
    
    //RENDER
    public void render(Graphics2D g) {
        if(isAlive) {
        
            
            g.drawImage(block,(int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize,null );
            if(isSolid()) {
                g.drawRect((int)pos.getWorldLocation().xpos, (int)pos.getWorldLocation().ypos, BlockSize, BlockSize);
            }
        }
    }
    
    //ENUM
    public enum BlockType {
        grass,
        sand,
        road,
        whiteLine, 
        finishLine, 
        halfWay;
    }
    
    public boolean isSolid() {
        return isSolid;
    }
    
    public boolean isHalfWay(){
        return isHalfWay;
    }
    
    public boolean isFinishLine() {
        return isFinishLine;
    }
    
//    public boolean isSemiSolid() {
//        return isSemiSolid;
//    }
    
    public boolean isAlive() {
        return isAlive;
    }
    
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}