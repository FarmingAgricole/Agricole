package agrcl.ihm;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class DrawGrid extends JPanel{

	private int scale = ALparameters.SCALE;
	boolean drawglobalgrid = true;
	public DrawGrid(){


	}

	public void paintComponent (Graphics g){
		g.setColor(new Color(0, 102, 34));
		if(drawglobalgrid){
		globalGrid(g);
		}
		cropsGrid(g);
		cowGrid(g);
		pigGrid(g);
		chickenGrid(g);
		sheepGrid(g);
		ressources(g);
		timeInfos(g);
		shop(g);
		endTurn(g);


	}

	public void cropsGrid (Graphics g){

		int lign = ALparameters.cropLign;
		int col = ALparameters.cropCol;
		JPanel field = new JPanel();
		field.setBounds(scale, scale*4, scale*col, scale*lign);
		field.setLayout(new GridLayout(lign,col));
		field.setEnabled(true);

		for (int i = 1;i<=(lign*col);i++){

			JLabel cropsCase = new JLabel(new ImageIcon("CropDirt.png"));
			cropsCase.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			cropsCase.setName(i+"");
			cropsCase.addMouseListener(new CropsListener());
			field.add(cropsCase);

		}

		add(field);
	}

	public void globalGrid (Graphics g){

		int pixel_height = ALparameters.WINDOW_HEIGHT;
		int pixel_width =  ALparameters.WINDOW_WIDTH;

		/*JPanel globalgrid = new JPanel();
		globalgrid.setLayout(new GridLayout(pixel_height/scale, pixel_width/scale));

		for (int i = 0; i< (pixel_height*pixel_width);i++){

			JLabel grass = new JLabel ();//new ImageIcon("grass_texture.png")
			globalgrid.add(grass);

		}*/


		/*int width = getWidth();
		int height = getHeight();*/

		for (int i = scale; i <= pixel_width; i += scale) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(2));
			g2.drawLine(i, 1, i, pixel_height);
		}

		for (int i = scale; i <= pixel_height; i += scale) {

			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(2));
			g2.drawLine(1, i, pixel_width, i);
		}
	}

	public void cowGrid (Graphics g){

		int col = ALparameters.cowCol;
		int lign = ALparameters.cowLign;
		JPanel cowField = new JPanel();
		cowField.setLayout(new GridLayout(col, lign));
		cowField.setBounds(scale*7, scale*5, scale*lign, scale*col);
		cowField.setEnabled(true);

		for (int i = 1; i<= (col*lign);i++){

			JLabel cowCase = new JLabel(new ImageIcon("enclosure_text.png"));
			cowCase.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			cowCase.setName(i+"");
			cowField.add(cowCase);
		}

		add(cowField);

	}

	public void pigGrid (Graphics g){

		int col = ALparameters.pigCol;
		int lign = ALparameters.pigLign;
		JPanel pigField = new JPanel();
		pigField.setLayout(new GridLayout(col, lign));
		pigField.setBounds(scale*7, scale*10, scale*lign, scale*col);
		pigField.setEnabled(true);

		for (int i = 1; i<= (col*lign);i++){

			JLabel pigCase = new JLabel(new ImageIcon("enclosure_text.png"));
			pigCase.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			pigCase.setName(i+"");
			pigField.add(pigCase);
		}

		add(pigField);

	}

	public void chickenGrid (Graphics g){

		int col = ALparameters.chickenCol;
		int lign = ALparameters.chickenLign;
		JPanel chickenField = new JPanel();
		chickenField.setLayout(new GridLayout(col, lign));
		chickenField.setBounds(scale*15, scale*10, scale*lign, scale*col);
		chickenField.setEnabled(true);

		for (int i = 1; i<= (col*lign);i++){

			JLabel chickenCase = new JLabel(new ImageIcon("enclosure_text.png"));
			chickenCase.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			chickenCase.setName(i+"");
			chickenField.add(chickenCase);
		}

		add(chickenField);

	}
	
	public void sheepGrid (Graphics g){

		int col = ALparameters.sheepCol;
		int lign = ALparameters.sheepLign;
		JPanel sheepField = new JPanel();
		sheepField.setLayout(new GridLayout(col, lign));
		sheepField.setBounds(scale*15, scale*5, scale*lign, scale*col);
		sheepField.setEnabled(true);

		for (int i = 1; i<= (col*lign);i++){

			JLabel sheepCase = new JLabel(new ImageIcon("enclosure_text.png"));
			sheepCase.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			sheepCase.setName(i+"");
			sheepField.add(sheepCase);
		}

		add(sheepField);

	}
	
	public void ressources (Graphics g){
		
		JPanel ressources = new JPanel();
		ressources.setLayout(new GridLayout(1, 4));
		ressources.setBounds(0,0,scale*17,scale);
		ressources.setBackground(Color.gray);
		JLabel gold = new JLabel("Or:");
		JLabel milk = new JLabel("Milk:");
		JLabel wool = new JLabel("Wool:");
		JLabel meat = new JLabel("Meat:");
		ressources.add(gold);
		ressources.add(milk);
		ressources.add(wool);
		ressources.add(meat);
		add(ressources);
	}
	
	public void timeInfos (Graphics g){
		
		JPanel infos = new JPanel();
		infos.setBounds(scale*28, 0, scale*3, scale*2);
		infos.setBackground(Color.gray);
		add(infos);
	}
	
	public void shop (Graphics g){
		
		JButton shop = new JButton("Shop");
		shop.setBounds(scale*27, scale*4, scale*4, scale);
		add(shop);
	}
	
	public void endTurn (Graphics g){
		
		JButton end = new JButton("Go to bed");
		end.setBounds(scale*28, scale*2, scale*3, scale);
		add(end);
		
	}
}




