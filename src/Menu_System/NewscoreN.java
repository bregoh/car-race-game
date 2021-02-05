/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu_System;

import com.sun.imageio.plugins.jpeg.JPEG;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import managers.HudManager;

/**
 *
 * @author EGUAVOEN BRIGHT
 */
public class NewscoreN extends JFrame {
    
    public NewscoreN() {
        JButton b1 = new JButton();
        JTextField jt = new JTextField("Your Score is "+HudManager.time);
         jt.setForeground(Color.MAGENTA);
        Font font = new Font("Bookman Old Style", Font.BOLD, 25);
        jt.setFont(font);
        
        
        
        JFrame jf = new JFrame();
        JPanel jp = new JPanel();
        jf.add(jp);
        jf.add(jp);
        jf.setSize(600,400);
        jp.add(jt);
        jp.add(b1);
        jf.setVisible(true);
    }
}
