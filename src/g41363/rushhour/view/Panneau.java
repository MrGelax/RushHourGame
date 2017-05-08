/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g41363.rushhour.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;/**
 *
 * @author Pedro
 */
public class Panneau extends JPanel{
    public void paintComponent (Graphics g){
        try{
            // Indiquer tout le chemin de l'image afin de ne par avoir de erreurs
            BufferedImage img=ImageIO.read(new File("C:\\Users\\Pedro\\Desktop\\RushHour\\g41363\\img\\parking.gif"));
            g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
