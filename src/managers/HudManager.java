package managers;

//import Maincarrace.MainF;
import Maincarrace.MainF;
import Menu_System.Help;
import Menu_System.NewscoreN;
import Objects.Player;
import System.GameWindow;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HudManager {
    public static int time;
    private Player player; //create player object
    private int score = 0; //create score to print time
    public HudManager(Player player) {
        this.player = player; //initialize player
        
    }
    
    //updates the time on the game
    public void updateScore() {
        score++;
    }
    public void gotoScore(){
        MainF k = new MainF();
        NewscoreN n = new NewscoreN(); 
        n.setVisible(true);
        WindowEvent winClose = new WindowEvent(k,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClose); 
    }
    
    public void render(Graphics2D g) {
        //block to print the strings
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, MainF.width, MainF.height / 9);
        
        //set font and color for strings
        g.setColor(Color.MAGENTA);
        Font font = new Font("Bookman Old Style", Font.BOLD, 25);
        g.setFont(font);
        
        //print current lap
        g.drawString("Lap:    " + player.getLap2()+"/1", 100, 50);
//        if(player.getLap2() == 1 && player.getLapZero2() == 1){
//            int time = score;
//            Newscore n = new Newscore();
//            n.setVisible(true);
//            //player.setLap2(2);
//            
//            
//        }
        
        //print speed from player class
        g.drawString("Speed:  " + player.getSpeed(), 600, 50);
        
        //runs score as long as lap is not over
        if(player.getLap2() != 1 && player.getLapZero2() != 1 && player.esc == false){
           updateScore(); 
        }else{
            time = score;
            gotoScore();
            }
        
        
        //prints score
        g.drawString("Time:   "+ score +" seconds", 1050, 50);
        
        //set color to yellow so collision blocks have yellow lines between them 
        g.setColor(Color.YELLOW);
    }
    
    private void close(GameWindow k) {
        WindowEvent winClose = new WindowEvent(k,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClose);
    }

}
