package GameState;

import java.awt.Graphics2D;
import java.util.Stack;

public class GameStateManager{
    
    public static Stack<GameState> states;
    
    public GameStateManager(String state) {        
        if (state == "1p") {
            states = new Stack<GameState>();
            states.push(new RaceLevelLoader(this, "World 1"));
        }
        if (state == "2p") {
            states = new Stack<GameState>();
            states.push(new RaceLevelLoaderMP(this, "World 1"));
        }
    }
    
    //@Override
    public void tick(double deltaTime) {
        states.peek().tick(deltaTime);
        
    }
    
    //@Override
    public void render(Graphics2D g) {
        states.peek().render(g);
    }

    public void init() {
        states.peek().init();
    }
}
