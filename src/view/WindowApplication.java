/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;


import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Classe représentant la fenêtre de l'application. <br/>
 * Elle contient les métadonnées relatives à la fenêtre de l'application :
 * <ul>
 *  <li>Dimensions de la fenêtre</li>
 *  <li>Le titre de l'application</li>
 * </ul>
 * @author Nathan Salez
 */
public class WindowApplication extends JFrame {
    
    public static final Dimension frameDimension = new Dimension(600,450);
    
    public static final Font fontButton = new Font(null,Font.BOLD, 17);
    
    public WindowApplication()
    {
        setTitle("Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new PanelContainer(this));
        this.setLocationRelativeTo(null); 
    }

    public static void main(String [] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                WindowApplication example = new WindowApplication();
                example.pack();
                example.setVisible(true);
            }
        });
    }
}
