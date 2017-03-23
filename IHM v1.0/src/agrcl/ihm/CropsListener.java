package agrcl.ihm;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.BorderFactory;
import javax.swing.JLabel;


public class CropsListener extends MouseAdapter {
	
	public void mouseClicked(MouseEvent me)	{
		
          JLabel clickedBox =(JLabel)me.getSource(); // get the reference to the box that was clicked 
          System.out.println(clickedBox.getName());
        
    }
	
	public void mouseEntered (MouseEvent me){
		  
		 JLabel clickedBox =(JLabel)me.getSource();
		 clickedBox.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
	}
	
	public void mouseExited (MouseEvent me){
		  
		 JLabel clickedBox =(JLabel)me.getSource();
		 clickedBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
	}
	
}

