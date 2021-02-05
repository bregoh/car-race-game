/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Menu_System;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author HP
 */
public class Help extends JFrame {

    /**
     * Creates new form Help
     */
    public Help() {
        setUndecorated(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        turboRacing = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Race against your friends! on the same network over IP");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(510, 220, 420, 20);

        jLabel2.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("  <W>      <S>             <A>         <D>");
        jLabel2.setToolTipText("");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(580, 430, 220, 20);

        jLabel3.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("SINGLE PLAYER MODE:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(610, 120, 180, 20);

        jLabel4.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Beat your own time and make it to the high scores!");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(510, 140, 380, 30);

        jLabel5.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("MULTIPLAYER MODE:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(620, 200, 180, 20);

        jLabel6.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("KEYS: ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(660, 410, 60, 20);

        jLabel7.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("OTHER OPTIONS:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(630, 300, 130, 20);

        jLabel8.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Select your maps!");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(630, 360, 140, 20);

        jLabel9.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("<UP> <DOWN> <LEFT> <RIGHT>");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(580, 450, 250, 20);

        turboRacing.setFont(new java.awt.Font("Tekton Pro Cond", 3, 48)); // NOI18N
        turboRacing.setForeground(new java.awt.Color(255, 0, 51));
        turboRacing.setText("TURBO RACING");
        turboRacing.setToolTipText("");
        turboRacing.setName(""); // NOI18N
        jPanel2.add(turboRacing);
        turboRacing.setBounds(580, 10, 260, 70);

        back.setBackground(new java.awt.Color(-16776961,true));
        back.setFont(new java.awt.Font("Monospaced", 1, 18));
        back.setForeground(new java.awt.Color(-16711681,true));
        back.setText("BACK");
        back.setToolTipText("");
        back.setContentAreaFilled(false);
        back.setPreferredSize(new java.awt.Dimension(153, 33));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backmousePressed(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel2.add(back);
        back.setBounds(610, 550, 160, 23);

        jLabel10.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Press <esc> to PAUSE the game!");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(560, 320, 260, 20);

        jLabel11.setFont(new java.awt.Font("Tekton Pro", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Select your cars!");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(630, 340, 140, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 944, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backmousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backmousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_backmousePressed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        close();
//        Pause pause = new Pause();
//        pause.setVisible(true);
        
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Help().setVisible(true);
            }
        });
    }
    
    private void close() {
        WindowEvent winClose = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClose);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel turboRacing;
    // End of variables declaration//GEN-END:variables
}
