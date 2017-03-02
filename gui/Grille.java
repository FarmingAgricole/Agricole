package agrl.ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class Grille extends JPanel{
	private boolean drawGrille = true;
	private int scale = ALparameters.SCALE;

	public void paintComponent(Graphics g){
		
		addMouseListener(new CropCase());
		g.setColor(new Color (153,102,0));
		drawField(g);
		g.setColor(Color.YELLOW);
		drawChickenEnclosure(g);
		g.setColor(Color.WHITE);
		drawCowEnclosure (g);
		g.setColor(Color.PINK);
		drawPigEnclosure(g);
		g.setColor(Color.GRAY);
		drawSheepEnclosure(g);
		
		if (drawGrille){
			g.setColor(Color.gray);
			drawGrid (g);
		}
		
	} 
	public void drawGrid(Graphics g){
		
		int width = getWidth();
		int height = getHeight();

		for (int i = scale; i <= width; i += scale) {
			g.drawLine(i, 1, i, height);
		}

		for (int i = scale; i <= height; i += scale) {
			g.drawLine(1, i, width, i);
		}
	}

	public void drawField (Graphics g) {

		g.drawRect(scale,4*scale,2*scale,10*scale);
		g.fillRect(scale,4*scale,2*scale,10*scale);
		g.drawRect(4*scale, 4*scale , 2*scale ,10*scale);
		g.fillRect(4*scale, 4*scale , 2*scale ,10*scale);
	}
	
	public void drawChickenEnclosure (Graphics g) {
		g.drawRect(7*scale, 4*scale, 7*scale, 4*scale);
		g.fillRect(7*scale, 4*scale, 7*scale, 4*scale);
	}
	
	public void drawCowEnclosure (Graphics g){
		g.drawRect(7*scale, 9*scale, 7*scale, 4*scale);
		g.fillRect(7*scale, 9*scale, 7*scale, 4*scale);
	}
	
	public void drawPigEnclosure (Graphics g){
		g.drawRect(15*scale, 4*scale, 7*scale, 4*scale);
		g.fillRect(15*scale, 4*scale, 7*scale, 4*scale);
	}
	
	public void drawSheepEnclosure (Graphics g){
		g.drawRect(15*scale, 9*scale, 7*scale, 4*scale);
		g.fillRect(15*scale, 9*scale, 7*scale, 4*scale);
	}
}