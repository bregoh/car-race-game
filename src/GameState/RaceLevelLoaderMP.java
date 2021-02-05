package GameState;

//import Maincarrace.MainF;
import Objects.Player;
import generator.World;
import java.awt.Graphics2D;

public class RaceLevelLoaderMP extends GameState{
    
    World world;
    private static String mapName = "Level1", worldName; //create var for world name and set map name
    public static Player p1 = new Player(true); //player 1
    public static Player p2 = new Player(false); //player 2
    
    public RaceLevelLoaderMP(GameStateManager gsm, String worldName) {
        super(gsm);
        this.worldName = worldName;
    }
    

    @Override
    public void init() {
        
        world = new World(worldName);
        world.setSize(130,130);
        
        
        world.addPlayer(p1, p2);
        
        world.init();
        world.generate(mapName);
    }

    @Override
    public void tick(double deltaTime) {
        world.tick(deltaTime);
    }

    @Override
    public void render(Graphics2D g) {
        world.render(g);
    }
}
