package GameState;

//import Maincarrace.MainF;
import Menu_System.CarSelect;
import Objects.Player;
import generator.World;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;


public class RaceLevelLoader extends GameState{
    
    World world;
    private static String mapName = "Level1", worldName;//set map name and init world name
    
    //constructor
    public RaceLevelLoader(GameStateManager gsm, String worldName) {
        super(gsm);
        this.worldName = worldName;
        
    }
    

    @Override
    public void init() {
        world = new World(worldName);
        world.setSize(130,130); //set the size of the map
        world.addPlayer(new Player(true)); //add player to world
        world.init(); //init world
        world.generate(mapName); //generate world
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
