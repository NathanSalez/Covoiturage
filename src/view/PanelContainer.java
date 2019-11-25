/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Cette classe détermine la structure graphique de la fenêtre de l'application.<br/>
 * Elle contient les vues de l'application.<br/>
 * @author Nathan Salez
 */
public class PanelContainer extends JPanel {
    
    CardLayout layoutManager;
    
    private WindowApplication p;
    
    private JComboBox listTraduction;
    
    private JLabel subtitle;
    
    private JPanel bottomPanel;
    
    private JPanel centerPanel;
    
    private JPanel topPanel;
    
    private JButton quitButton;
    
    public PanelContainer(WindowApplication p)
    {
        this.p = p;
        
        buildTopPanel();
        
        buildBottomPanel();
        
        layoutManager = new CardLayout();
        centerPanel = new JPanel();
        centerPanel.setLayout(layoutManager);
        centerPanel.add( new WelcomePanel(this),"welcome");
        switchTo("welcome",WelcomePanel.SUBTITLE);
        
        this.setLayout( new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.add(centerPanel,BorderLayout.CENTER);
        this.add(bottomPanel,BorderLayout.PAGE_END);
        this.setPreferredSize(WindowApplication.frameDimension);
    }
    
    private void buildSubtitle()
    {
        this.subtitle = new JLabel("",JLabel.CENTER);
        this.subtitle.setFont(new Font(null, Font.PLAIN, 40));
    }
    
    protected void setSubtitle(String text)
    {
        this.subtitle.setText(text);
    }
    
    private void buildTopPanel()
    {
        buildSubtitle();
        topPanel = new JPanel();
        topPanel.add(this.subtitle);
        topPanel.setBackground( new Color(254, 254, 226));
        topPanel.setBorder( BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black) );
    }
    
    private void buildBottomPanel()
    {
        buildQuitButton();
        
        buildListTraduction();
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));
        bottomPanel.setBackground( new Color(254, 254, 226));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bottomPanel.add(Box.createHorizontalGlue());
        bottomPanel.add(listTraduction);
        bottomPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        bottomPanel.add(quitButton);
    }
    
    private void buildQuitButton()
    {
        this.quitButton = new JButton("Exit");
        this.quitButton.setFont( WindowApplication.fontButton );
        this.quitButton.addActionListener((ActionEvent e) -> {p.dispose();});
    }
    
    private void buildListTraduction()
    {
        this.listTraduction = new JComboBox();
        this.listTraduction.addItem( new String("Français"));
        this.listTraduction.addItem( new String("English"));
        this.listTraduction.setFont( WindowApplication.fontButton);
    }

    /**
     * Permet de naviguer d'une vue à une autre dans la fenêtre de l'application.<br/>
     * Elle est à utiliser depuis les vues créées.
     * @param page Le nom de la vue à afficher.
     * @param subtitle Les sous titres à insérer. 
     */
    public void switchTo(String page, String subtitle)
    {
        setSubtitle(subtitle);
        layoutManager.show( centerPanel, page );
    }

}
