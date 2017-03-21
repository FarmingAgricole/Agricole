package agrl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class IHM_Vehicle extends JFrame {
	Vehicle tractorX1 = new Vehicle("Tractor1", 150);
	Vehicle tractorX2 = new Vehicle("Tractor2", 300);
	RepairVehicle rp = new RepairVehicle();
	Garage garages = new Garage();
	Wallet wallet = new Wallet(100000);
	Shop shop = new Shop();
	Field fields = new Field();
	Integer[] possibilities = {1,2,3,4,5,6};


	ImageIcon blankIcon = new ImageIcon("/Users/hongphucvu/blank.png");

	protected JLabel case1 = new JLabel(blankIcon);
	protected JLabel case2 = new JLabel(blankIcon);
	protected JLabel case3 = new JLabel(blankIcon);
	protected JLabel case4 = new JLabel(blankIcon);
	protected JLabel case5 = new JLabel(blankIcon);
	protected JLabel case6 = new JLabel(blankIcon);
	
	JLabel[] cases = {case1, case2, case3, case4, case5, case6};
	

	protected JButton buyTractorX1Button = new JButton("Buy TractorX1(-1500)");
	protected JButton buyTractorX2Button = new JButton("Buy TractorX2(-3000)");
	protected JButton sellTractorButton = new JButton("Sell Vehicle");
	protected JButton repairVehicleButton = new JButton("Repair Vehicle");
	protected JButton updateInfoButton = new JButton("Update information");
	protected JButton harvestButton = new JButton("Harvest");

	protected JLabel messageLabel = new JLabel("Message");
	protected JLabel walletLabel = new JLabel("Wallet: ");
	protected JLabel infoLabel = new JLabel("Info: ");
	protected JLabel goldLabel = new JLabel("Gold : "+String.valueOf(wallet.getGold()));
	
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

	public IHM_Vehicle(String title) throws IOException {

		super(title);

		initStyle();

		initLayout();

		initActions();

	}
	
	

	protected void initLayout() throws IOException{
		GridBagConstraints gbc = new GridBagConstraints();
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
		
		gbc.gridx = 0;
	    gbc.gridy = 1;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    add( buyTractorX1Button, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    gbc.fill = GridBagConstraints.VERTICAL;
	    add( buyTractorX2Button, gbc);
	    
	    gbc.gridx = 0;
	    gbc.gridy = 5;
	    add( sellTractorButton, gbc);
	    
	    
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
	    
	    gbc.gridx = 1;
	    gbc.gridy = 4;
	    gbc.gridwidth = 3;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	   add( updateInfoButton, gbc);
	   
	    gbc.gridx = 1;
	    gbc.gridy = 5;
	   add( repairVehicleButton, gbc);
	   
	   gbc.gridx = 0;
	    gbc.gridy = 4;
	    gbc.fill = GridBagConstraints.HORIZONTAL;
	    add(goldLabel, gbc);
	
	    
	    gbc.gridx = 0;
	    gbc.gridy = 6;
	    gbc.anchor = GridBagConstraints.NORTH;
	    add(messageLabel, gbc);
	    
	    gbc.gridx = 1;
	    gbc.gridy = 6;
	    gbc.anchor = GridBagConstraints.NORTH;
	    add(harvestButton, gbc);
	    
	    

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
		buyTractorX1Button.setFont(BUTTON_FONT);
		buyTractorX2Button.setFont(BUTTON_FONT);
		sellTractorButton.setFont(BUTTON_FONT);
		repairVehicleButton.setFont(BUTTON_FONT);
		updateInfoButton.setFont(BUTTON_FONT);
	}

	protected void initActions(){
		buyTractorX1Button.addActionListener(new buyTractorX1Action());
		buyTractorX2Button.addActionListener(new buyTractorX2Action());
		sellTractorButton.addActionListener(new sellTractorAction());
		repairVehicleButton.addActionListener(new repairVehicleAction());
		updateInfoButton.addActionListener(new updateInfoAction());
		harvestButton.addActionListener(new harvestAction());
	}

	private class repairVehicleAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int index = userChoice();
			if (garages.whichVehicle(index) == 0) {
				showError("TRACTOR NOT FOUND");
			} else {
				shop.repairTractor(wallet, garages, index);
				showInfo("Tractor repaired", "Repair confirmation");
				messageLabel.setText("Tractor repaired");
				actualizeWallet();
			}
		}
		}
	
	private class buyTractorX1Action implements ActionListener {

		public void actionPerformed(ActionEvent e){
			if (wallet.getGold()<1500){
				System.out.println("money<1500");
				messageLabel.setText("Not enough money to buy this item");
				showError("NOT ENOUGH MONEY TO PROCESS");
			} else {
				if (garages.addMore() == false)  {
					System.out.println("Cannot add more vehicle");
					messageLabel.setText("Cannot buy anymore");
					showError("CANNOT ADD MORE VEHICLE");
				} else {
					System.out.println("Current number of vehicle: " + (garages.getNumberVehicle()+1));
					int index = userChoice();
					shop.buyTractorX1(wallet,garages, index);
					if (shop.purchased()) {
						showInfo("Tractor X1 bought", "Purchased confirmation");
						messageLabel.setText("Tractor X1 bought");
						actualizeWallet();
					} else {
						messageLabel.setText("CANNOT ADD TRACTOR");
						showError("CANNOT ADD TRACTOR");
						System.out.println("CANNOT ADD TRACTOR");
					}
				} 
			}
			actualizeVehicle();
		}
	}

	private class buyTractorX2Action implements ActionListener {

		public void actionPerformed(ActionEvent e){
			if (wallet.getGold()<3000){
				System.out.println("money<3000");
				messageLabel.setText("Not enough money to buy this item");
				showError("NOT ENOUGH MONEY TO PROCESS");
			} else {
				if (garages.addMore() == false) {
					System.out.println("Cannot add more vehicle");
					messageLabel.setText("Cannot buy anymore");
					showError("CANNOT ADD MORE VEHICLE");
				} else {
					System.out.println("Current number of vehicle: " + garages.getNumberVehicle());
					int index = userChoice();
					shop.buyTractorX2(wallet,garages, index);
					if (shop.purchased()) {
						showInfo("Tractor X2 bought", "Purchased confirmation");
						messageLabel.setText("Tractor X2 bought");
						actualizeWallet();
					} else {
						messageLabel.setText("CANNOT ADD TRACTOR");
						showError("CANNOT ADD TRACTOR");
						System.out.println("CANNOT ADD TRACTOR");
					}
				} 
			}
			actualizeVehicle();
		}
	}

	private class sellTractorAction implements ActionListener {
		public void actionPerformed(ActionEvent e){

			if (garages.getNumberVehicle()==0){
				System.out.println("No item to sell");
				messageLabel.setText("No item to sell");
				showError("TRACTOR NOT FOUND");
			}
			else {
				int index = userChoice();
				shop.sellTractor(wallet,garages, index);
				System.out.println("Item sold");
				System.out.println("Current number of vehicle: " + garages.getNumberVehicle());
				showInfo("Tractor removed", "Sold confirmation");
				messageLabel.setText("Item sold");
			}
			actualizeWallet();
			actualizeVehicle();
		}
	}
	
	
	
	private class updateInfoAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int index = userChoice();
			if (garages.whichVehicle(index) == 0) {
			showError("TRACTOR NOT FOUND");
			} else {
			messageLabel.setText(garages.updateStatus(index));
			showInfo(garages.updateStatus(index), "Infomation");
		}
		}
	}
	
	private class harvestAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int index = userChoice();
			Vehicle v = garages.accesValue(index);
			v.harvestStatus();
			int f = fields.whichCrop(index);
			if (f == 0) {
				System.out.println("NULL");
			} else if (f == 1) {
				System.out.println("1");
			}else if (f == 1) {
				System.out.println("2");
			}
			fields.removeCrop(index);
			showInfo("HARVESTED", "Infomation");
			actualizeWallet();
			actualizeVehicle();
		}
	}

	public void actualizeVehicle() {
		ImageIcon blank = new ImageIcon("/Users/hongphucvu/blank.png");
		ImageIcon tractor = new ImageIcon("/Users/hongphucvu/tractor.png");
		ImageIcon tractor1 = new ImageIcon("/Users/hongphucvu/tractor1.png");
		for (int i=1; i<= garages.getMaxPlace(); i++) {
			int val = garages.whichVehicle(i);
			if (val == 0) {
				cases[i-1].setIcon(blank);
			} else if (val == 1) {
			cases[i-1].setIcon(tractor);
			} else if (val == 2) {
				cases[i-1].setIcon(tractor1);
			}
		}
	}
	
	
	public void actualizeWallet(){
		goldLabel.setText("Gold : "+String.valueOf(wallet.getGold()));
	}

	public void showError(String custom) {
		JOptionPane.showMessageDialog(new JFrame(), custom, "Error",
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void showInfo(String custom, String title) {
		JOptionPane.showMessageDialog(new JFrame(), custom, title,
				JOptionPane.INFORMATION_MESSAGE);
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
	
	public static void main(String[] args) throws IOException {
		new IHM_Vehicle("Garage Manage");

	    }
}
