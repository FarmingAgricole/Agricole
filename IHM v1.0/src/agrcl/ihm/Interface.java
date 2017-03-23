package agrcl.ihm;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Interface extends JFrame{
	
	public Interface (){
		
		DrawGrid dashboard = new DrawGrid();
		this.setContentPane(dashboard);
		this.setLayout(null);
		this.setTitle("Agricole");
		this.setMinimumSize(new Dimension((ALparameters.WINDOW_WIDTH+15),ALparameters.WINDOW_HEIGHT+25));
		this.setLocationRelativeTo(null); // fenetre centrer
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	
	}
}
