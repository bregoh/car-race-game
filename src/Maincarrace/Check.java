package Maincarrace;

import Objects.Player;
import generator.Block;
import generator.TileManager;
import java.awt.Point;

public class Check {
    
    //method to detech collision blocks
    public static boolean CollisionPlayerBlock(Point p1, Point p2) {
        for(Block block : TileManager.blocks){
            if(block.isSolid()){
                if(block.contains(p1) || block.contains(p2)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    //method to check collision against finish point
    public static boolean Finish(Point p1, Point p2) {
        for(Block block : TileManager.blocks){
            if(block.isFinishLine()){
                if(block.contains(p1) || block.contains(p2)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    //method to check collision against halfway point
    public static boolean HalfWay(Point p1, Point p2) {
        for(Block block : TileManager.blocks){
            if(block.isHalfWay()){
                if(block.contains(p1) || block.contains(p2)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
