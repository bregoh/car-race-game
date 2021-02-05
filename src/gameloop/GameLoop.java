package gameloop;

import GameState.GameStateManager;
import Maincarrace.Assets;
import System.TheGameLoop;
import System.Vector2F;

public class GameLoop extends TheGameLoop {
    
    GameStateManager gsm;
    public static Assets assets = new Assets();
    public static String type;
    
    //constructor
    public GameLoop(int fwidth, int fheight) {
        super(fwidth, fheight);
        
    }

    @Override
    public void init() {
        assets.init();
        gsm = new GameStateManager(type);
        gsm.init();
        super.init();
    }
    
    @Override
    public void tick(double deltaTime) {
        
        gsm.tick(deltaTime);
    } 
    
    @Override
    public void render() {
        super.render(); //To change body of generated methods, choose Tools | Templates.
        gsm.render(graphics2D);
        clear();
    }
    
    @Override
    public void clear() {
        super.clear(); //To change body of generated methods, choose Tools | Templates.
    }
}
