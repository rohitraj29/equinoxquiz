/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package quizengineapp;

import java.awt.Toolkit;
import javax.swing.JFrame;

/**
 *
 * @author rohit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
         MasterController master=new MasterController();
         LoginFrame frm1= new LoginFrame(master);
         frm1.setSize(Toolkit.getDefaultToolkit().getScreenSize());
         
         
         frm1.setResizable(false);
         
         frm1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         frm1.setVisible(true);
    }

}
