package agrl.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public  class GridPane extends JPanel {

	public GridPane(int row, int col) {

		int count = 0 ; // use to give a name to each box so that you can refer to them later
		setLayout(new GridLayout(row, col));
		setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));

		for (int i = 1; i <= (row * col); i++) {
			JPanel pan = new JPanel();

			pan.setEnabled(true);
			pan.setBackground(Color.WHITE);
			pan.setPreferredSize(new Dimension(3, 3));
			pan.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			pan.addMouseListener(new BoxListener()); // add a mouse listener to make the panels clickable
			pan.setName(count+"");
			++count;
			add(pan);
		}
	}
	public  class BoxListener extends MouseAdapter	{
		public void mouseClicked(MouseEvent me)
		
		{
			JPanel clickedBox =(JPanel)me.getSource(); // get the reference to the box that was clicked 

			// insert here the code defining what happens when a grid is clicked
		}
	}
}

