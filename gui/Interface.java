package agrl.ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Interface extends JFrame{

    
	public Interface(){
		JPanel ressPanel = new JPanel ();
		JLabel or = new JLabel ("or: ");
		ressPanel.add(or);
		this.add(ressPanel);
		this.setTitle("Agricole");	
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); //fullscreen
		this.setBackground(new Color (0,102,0)); // couleur verte en fond
		this.setMinimumSize(new Dimension(800, 650));
		this.setLocationRelativeTo(null); // fenetre centrer	
		this.setContentPane(new Grille());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}


}
