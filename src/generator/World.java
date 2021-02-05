package generator;


import Maincarrace.MainF;
import Objects.Player;
import System.LoadImage;
import System.Vector2F;
import gameloop.GameLoop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class World {
    
    public static Vector2F map_pos = new Vector2F(250,2180);;//(250)x{110 - 350}, y{1250}
    
    
    private String worldName;
    private BufferedImage map;
    private int worldWidth, worldHeight;
    private int size = 28;//make it 28 //5 //blocksize
        
    private TileManager tiles;
    private Player player;
    private Player player2;
    private String type = GameLoop.type;
    
    //constructor for world class
    public World(String worldName) {
        this.worldName = worldName;
    }
    
    //initializes the world
    public void init() {
        tiles = new TileManager();
        player.init(this);
        if(type.equals("2p")){
            player2.init(this);
        }
    }
    
    //ticks world
    public void tick(double deltaTime) {
        Vector2F.setWorldVariables(map_pos.xpos, map_pos.ypos);
        tiles.tick(deltaTime);
        player.tick(deltaTime);
        if(type.equals("2p")){
            player2.tick(deltaTime);
        }
    }
    
    //renders world and objects in world
    public void render(Graphics2D g) {
        tiles.render(g);
        player.render(g);
        if(type.equals("2p")){
            player2.render(g);
        }
    }
    
    public void generate(String worldImageName) {
        
        try {
            map = LoadImage.LoadImageFrom(MainF.class, "images/" + worldImageName + ".png");
        }
        catch(Exception e){   
            System.out.println("Error in World Map");
        }
        
        for(int x = 0; x < worldWidth; x++) {//800
            for(int y = 0; y < worldHeight; y++) {//800

                int col = map.getRGB(x, y);

                switch(col & 0xFFFFFF) {
                    case 0xBFBFBF:
                        tiles.blocks.add(new Block(new Vector2F(x * size, y * size), Block.BlockType.grass)); 
                        break;
                    case 0xFFD800:
                        tiles.blocks.add(new Block(new Vector2F(x * size, y * size), Block.BlockType.road)); 
                        break;
                    case 0xFF6A00:
                        tiles.blocks.add(new Block(new Vector2F(x * size, y * size), Block.BlockType.sand).isSolid(true)); 
                        break;
                    case 0x00137F:
                        tiles.blocks.add(new Block(new Vector2F(x * size, y * size), Block.BlockType.whiteLine)); 
                        break;
                    case 0xFF0000:
                        tiles.blocks.add(new Block(new Vector2F(x * size, y * size), Block.BlockType.finishLine).isFinishLine(true)); 
                        break;
                    case 0x7F0000:
                        tiles.blocks.add(new Block(new Vector2F(x * size, y * size), Block.BlockType.halfWay).isHalfWay(true)); 
                        break;
                }
            }
        }
        
        player.init(this);
    }
    
    public String getWorldName() {
        return this.worldName;
    }
    
    public BufferedImage getWorldImage() {
        return map;
    }

    public void setSize(int worldW, int worldH) {
        this.worldWidth = worldW;
        this.worldHeight = worldH;
    }
    
    public void addPlayer(Player player, Player p2) {

        this.player = player;
        this.player2 = p2;
    }
    
    public void addPlayer(Player player) {
        if(Player.server) {
            map_pos = new Vector2F(250,2180);
        }
        if(!Player.server){
            map_pos = new Vector2F(150,2180);
        }
        this.player = player;
    }
}
