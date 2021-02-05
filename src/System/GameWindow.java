package System;

import Menu_System.Pause;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class GameWindow extends JFrame{
    
    boolean fullScreenEnabled = false;
    int fullScreenMode = 0;
    GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0];
    
    //constructor for main game window
    public GameWindow(String title, int width, int height) {
        setTitle(title);
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }
    
    //set full screen modes for main game window
    private void setfullscreen() {
        switch(fullScreenMode) {
            case 0:
                System.out.println("No Full Screen");
                setUndecorated(false);
                break;
            case 1:
                setUndecorated(true);
                setExtendedState(JFrame.MAXIMIZED_BOTH);
                
                break;
            case 2:
                setUndecorated(true);
                device.setFullScreenWindow(this);
                
                break;
        }
    }
    
    public void setFullscreen(int fsm) {
        fullScreenEnabled = true;
        if (fullScreenMode <= 2) {
            this.fullScreenMode = fsm;
            setfullscreen();
        }
        else {
            System.err.println("Error " + fsm + " is not supported");
        }
    }
    
    //closes main game window
    public void close() {
        WindowEvent winclose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winclose);
    }

}
