package Maincarrace;

import GameState.RaceLevelLoaderMP;
import System.GameWindow;
import System.SpriteSheet;
import gameloop.GameLoop;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class MainF extends JFrame{
    
    static SpriteSheet blocks = new SpriteSheet();

    //to set the screen to full screen
    public static final GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    public static int width = gd.getDisplayMode().getWidth();
    public static int height = gd.getDisplayMode().getHeight();
    
    public MainF(){
        GameWindow frame = new GameWindow("Car Race", width, height);
        frame.setFullscreen(1);
        frame.addKeyListener(RaceLevelLoaderMP.p1);
        frame.addKeyListener(RaceLevelLoaderMP.p2);
        frame.add(new GameLoop(width,height));
        frame.setVisible(true);
        
    }
    
    //to exit the Jframe
    public void close() {
        WindowEvent winclose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclose);
    }
    
}
