/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Pedro
 */
public class Fenetre extends JFrame {
    public Fenetre(){
        this.setTitle("RushHour Game");
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pan=new JPanel();
        pan.setBackground(java.awt.Color.GREEN);
        this.setContentPane(new Panneau());
        this.setVisible(true);
    }
}
