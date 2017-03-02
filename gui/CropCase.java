package agrl.ihm;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class CropCase extends MouseAdapter {
	private int scale = ALparameters.SCALE;

	public void mouseClicked(MouseEvent e){
		JPanel clickedBox =(JPanel)e.getSource();
		System.out.println("s");
	}
}
