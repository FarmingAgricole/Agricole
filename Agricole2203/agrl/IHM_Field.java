package agrl;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;



public class IHM_Field extends JFrame {
	Carrot carrot = new Carrot(100,2);
	Strawberry strawberry = new Strawberry(70,2);
	Field fields = new Field();
	Turn turn = new Turn();
	Integer[] possibilities = {1,2,3,4,5,6};
	
	ImageIcon blankIcon = new ImageIcon("/Users/hongphucvu/blank.png");

	protected JLabel case1 = new JLabel(blankIcon);
	protected JLabel case2 = new JLabel(blankIcon);
	protected JLabel case3 = new JLabel(blankIcon);
	protected JLabel case4 = new JLabel(blankIcon);
	protected JLabel case5 = new JLabel(blankIcon);
	protected JLabel case6 = new JLabel(blankIcon);
	
	JLabel[] cases = {case1, case2, case3, case4, case5, case6};
	
	protected JButton plantCarrotButton = new JButton("Plant carrot");
	protected JButton plantStrawberryButton = new JButton("Plant strawberry");
	protected JButton updateInformationButton = new JButton("Update information");
	protected JButton nextTurnButton = new JButton("nextTurn");
	//protected JButton updateInfoButton = new JButton("Update information");
	
	protected JLabel messageLabel = new JLabel("Message");
	
	protected JLabel position1 = new JLabel("1");
	protected JLabel position2 = new JLabel("2");
	protected JLabel position3 = new JLabel("3");
	protected JLabel position4 = new JLabel("4");
	protected JLabel position5 = new JLabel("5");
	protected JLabel position6 = new JLabel("6");
	protected JLabel[] positions = {position1, position2, position3, position4,
			position5, position6};
	
	
	protected JOptionPane dialog = new JOptionPane();

	private static final Font LABEL_FONT = new Font(Font.MONOSPACED, Font.BOLD, 90);
	private static final Font BUTTON_FONT = new Font(Font.DIALOG, Font.BOLD, 20);
	private static final Font TEXT_FIELD_FONT = new Font(Font.DIALOG, Font.BOLD, 20);

	public IHM_Field(String title) throws IOException {
		super(title);

		initStyle();

		initLayout();

		initActions();
	}
	
	protected void initLayout() throws IOException{
		GridBagConstraints gbc = new GridBagConstraints();
		GridBagConstraints gbc1 = new GridBagConstraints();
		setLayout(new GridBagLayout());
		gbc.insets = new Insets(1,1,1,1);
		
		for (int i=0; i<=2; i++) {
			gbc.gridx = (i+1);
		    gbc.gridy = 0;
		    add( positions[i], gbc);
		}
		
		for (int i=3; i<=5; i++) {
			gbc.gridx = (i-2);
		    gbc.gridy = 2;
		    add( positions[i], gbc);
		}
		
		
		 for (int i = 1; i<=3; i++) {
		    	gbc.gridx = (i);
			    gbc.gridy = 1;
			    add(cases[i-1], gbc);
		    }
		    
		    for (int i = 4; i<=6; i++) {
		    	gbc.gridx = (i-3);
			    gbc.gridy = 3;
			    add(cases[i-1], gbc);
		    }
		    
		    
		    gbc.gridx = 0;
		    gbc.gridy = 4;
		    gbc.anchor = GridBagConstraints.NORTH;
		    add(messageLabel, gbc);
		    
		    gbc.gridx = 0;
		    gbc.gridy = 5;
		    gbc.anchor = GridBagConstraints.NORTH;
		    add(updateInformationButton, gbc);
		    
		    gbc.gridx = 0;
		    gbc.gridy = 6;
		    gbc.anchor = GridBagConstraints.NORTH;
		    add(nextTurnButton, gbc);
		    
			gbc.gridx = 0;
		    gbc.gridy = 1;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    add( plantCarrotButton, gbc);
		    
		    gbc.gridx = 0;
		    gbc.gridy = 3;
		    gbc.fill = GridBagConstraints.VERTICAL;
		    add( plantStrawberryButton, gbc);
		    
		    
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,600);
		setResizable(false);
		setVisible(true);
	}
	

	protected void initStyle() {

		case1.setFont(LABEL_FONT);
		case2.setFont(LABEL_FONT);
		case3.setFont(LABEL_FONT);
		case4.setFont(LABEL_FONT);
		case5.setFont(LABEL_FONT);
		case6.setFont(LABEL_FONT);
		plantCarrotButton.setFont(BUTTON_FONT);
		plantStrawberryButton.setFont(BUTTON_FONT);
		updateInformationButton.setFont(BUTTON_FONT);
		nextTurnButton.setFont(BUTTON_FONT);
		//updateInfoButton.setFont(BUTTON_FONT);
	}
	
	protected void initActions(){
		plantCarrotButton.addActionListener(new plantCarrotAction());
		plantStrawberryButton.addActionListener(new plantStrawberryAction());
		updateInformationButton.addActionListener(new updateInformationAction());
		nextTurnButton.addActionListener(new nextTurnAction());
		//updateInfoButton.addActionListener(new updateInfoAction());
	}
		
	
	private class nextTurnAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
		turn.goTurn();
			turn.turnCrops(fields);
			actualizeCrop();
		}
		}
	
	
	private class updateInformationAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int index = userChoice();
			showInfo(fields.updateStatus(index), "Infomation");
		}
		}
		
	private class plantCarrotAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int x = userChoice();
			fields.addCrop(x, 1);
			messageLabel.setText("ADDED");
			actualizeCrop();
		}
	}
	
	private class plantStrawberryAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int x = userChoice();
			fields.addCrop(x, 2);
			messageLabel.setText("ADDED");
			actualizeCrop();
		}
	}
	
	
	
	public int userChoice() {
		try {
		Integer index = (Integer)JOptionPane.showInputDialog(new JFrame(), "Please select position", "Get information",
				JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), possibilities, 1);
		return index; }
		catch(NullPointerException e) {
			return 0;
		}
	}
	
	
	public void actualizeCrop() {
		ImageIcon blank = new ImageIcon("blank.png");
		ImageIcon carrotimage = new ImageIcon("tractor.png");
		ImageIcon strawberryimage = new ImageIcon("tractor1.png");
		for (int i=1; i<= 6; i++) {
			int val = fields.whichCrop(i);
			if (val == 0) {
				cases[i-1].setIcon(blank);
			} else if (val == 1) {
			cases[i-1].setIcon(carrotimage);
			} else if (val == 2) {
				cases[i-1].setIcon(strawberryimage);
			}
		}
	}
	
	public void showInfo(String custom, String title) {
		JOptionPane.showMessageDialog(new JFrame(), custom, title,
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void main(String[] args) throws IOException {
		new IHM_Field("Field Manage");
		new IHM_Vehicle("Garage Manage");
	    }
}
