package agrl;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class IHM_Demo extends JFrame {
	Garage garages = new Garage();
	RepairVehicle rp = new RepairVehicle();

	Enclosure enclosures = new Enclosure();

	Field fields = new Field();
	Hay hay = new Hay();
	Grain grain = new Grain();
	Milk milk = new Milk();
	Egg egg = new Egg();
	Wool wool = new Wool();

	Wallet wallet = new Wallet(100000);
	Shop shop = new Shop();
	Turn turn = new Turn();

	int weight = 16;
	Position[] cases = new Position[weight*weight];
	Case caseOp = new Case();
	Integer[] possibilities = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};

	JButton[] casesLabel = new JButton[weight*weight];

	//Garage Button
	protected JButton buyTractorX1Button = new JButton("Buy TractorX1(-1500)");
	protected JButton buyTractorX2Button = new JButton("Buy TractorX2(-3000)");
	protected JButton sellTractorButton = new JButton("Sell Vehicle");
	protected JButton repairVehicleButton = new JButton("Repair Vehicle");
	protected JButton updateInfoGarageButton = new JButton("Update info garage");
	protected JButton harvestButton = new JButton("Harvest");

	protected JLabel messageLabel = new JLabel("Message");
	protected JLabel hayLabel = new JLabel("Hay: " + String.valueOf(hay.getHay()));
	protected JLabel grainLabel = new JLabel("Grain: " + String.valueOf(grain.getGrain()));
	protected JLabel milkLabel = new JLabel("Milk: " + String.valueOf(milk.getMilk()));
	protected JLabel woolLabel = new JLabel("Wool: " + String.valueOf(wool.getWool()));
	protected JLabel eggLabel = new JLabel("Egg: " + String.valueOf(egg.getEgg()));
	protected JLabel infoLabel = new JLabel("Info: ");
	protected JLabel goldLabel = new JLabel("Gold: "+String.valueOf(wallet.getGold()));
	protected JLabel turnLabel = new JLabel("Turn: "+String.valueOf(turn.getTurn()));

	//Field Button
	protected JButton plantCarrotButton = new JButton("Plant carrot");
	protected JButton plantStrawberryButton = new JButton("Plant strawberry");
	protected JButton updateInfoFieldButton = new JButton("Update info field");
	protected JButton nextTurnButton = new JButton("nextTurn");
	protected JButton buyHayButton = new JButton("Buy Hay (-10)");

	//Enclousure Button
	protected JButton buyCowButton = new JButton("Buy Cow");
	protected JButton buyPigButton = new JButton("Buy Pig");
	protected JButton buySheepButton = new JButton("Buy Sheep");
	protected JButton buyChickenButton = new JButton("Buy Chicken");

	protected JButton feedAllCowButton = new JButton("Feed All Cow");
	protected JButton feedAllChickenButton = new JButton("Feed All Chicken");
	protected JButton feedAllSheepButton = new JButton("Feed All Sheep");
	protected JButton feedAllPigButton = new JButton("Feed All Pig");
	protected JButton updateInfoAnimalButton = new JButton("update Info A");
	protected JButton sellMilkButton = new JButton("Sell Milk");
	protected JButton sellEggButton = new JButton("Sell Egg");
	protected JButton sellWoolButton = new JButton("Sell Wool");

	protected JOptionPane dialog = new JOptionPane();
	private static final Font LABEL_FONT = new Font(Font.MONOSPACED, Font.BOLD, 90);
	private static final Font BUTTON_FONT = new Font(Font.DIALOG, Font.BOLD, 20);
	private static final Font TEXT_FIELD_FONT = new Font(Font.DIALOG, Font.BOLD, 20);

	private CardLayout cardLayout = new CardLayout();
	private  JPanel centerPanel;       // container panel for the top
	private  JPanel fieldPanel;    // container panel for the bottom
	private  JPanel bottomPanel;
	private  JPanel shopPanel;
	private JPanel cardPanel, buttonPanel;
	private JButton btn1, btn2;
	
	
	public IHM_Demo(String title) throws IOException {
		super(title);
		initFunction();
		initStyle();
		initLayout();
		initActions();
	}

	protected void initFunction() {
		for (int i = 0; i< casesLabel.length; i++) {
			casesLabel[i] = new JButton(new ImageIcon("blank.png"));
		}
		
		for (int x=1; x<=2; x++) {
			for (int y=9; y<=16; y++) {
				int i = caseOp.findIndex(x, y);
				casesLabel[i] = new JButton(new ImageIcon("grass.jpg"));
			}
			}
		
		for (int x=4; x<=5; x++) {
			for (int y=9; y<=16; y++) {
				int i = caseOp.findIndex(x, y);
				casesLabel[i] = new JButton(new ImageIcon("straw.jpg"));
			}
			}
		
		for (int x=7; x<=8; x++) {
			for (int y=9; y<=16; y++) {
				int i = caseOp.findIndex(x, y);
				casesLabel[i] = new JButton(new ImageIcon("soli.jpg"));
			}
			}

		for (int x=10; x<=11; x++) {
			for (int y=9; y<=16; y++) {
				int i = caseOp.findIndex(x, y);
				casesLabel[i] = new JButton(new ImageIcon("grass.jpg"));
			}
			}
		
		for (int x=1; x<=2; x++) {
			for (int y=1; y<=6; y++) {
				int i = caseOp.findIndex(x, y);
				casesLabel[i] = new JButton(new ImageIcon("road.jpg"));
				casesLabel[i].putClientProperty("x", x);
				casesLabel[i].putClientProperty("y", y);
				casesLabel[i].addActionListener(new UpdateInfoGarageAction2());
				
			}
			}
		
		for (int x=4; x<=13; x++) {
			for (int y=1; y<=6; y++) {
				int i = caseOp.findIndex(x, y);
				casesLabel[i] = new JButton(new ImageIcon("ground.jpg"));
			}
			}
	}

	protected void initActions(){
		plantCarrotButton.addActionListener(new plantCarrotAction());
		plantStrawberryButton.addActionListener(new plantStrawberryAction());
		updateInfoFieldButton.addActionListener(new updateInfoFieldAction());
		nextTurnButton.addActionListener(new nextTurnAction());

		buyTractorX1Button.addActionListener(new buyTractorX1Action());
		buyTractorX2Button.addActionListener(new buyTractorX2Action());
		sellTractorButton.addActionListener(new sellTractorAction());
		repairVehicleButton.addActionListener(new repairVehicleAction());
		updateInfoGarageButton.addActionListener(new UpdateInfoGarageAction());
		buyHayButton.addActionListener(new buyHayAction());
		harvestButton.addActionListener(new harvestAction());

		buyCowButton.addActionListener(new buyCowAction());
		buyChickenButton.addActionListener(new buyChickenAction());
		buySheepButton.addActionListener(new buySheepAction());
		buyPigButton.addActionListener(new buyPigAction());
		feedAllCowButton.addActionListener(new feedAllCowAction());
		feedAllChickenButton.addActionListener(new feedAllChickenAction());
		feedAllSheepButton.addActionListener(new feedAllSheepAction());
		feedAllPigButton.addActionListener(new feedAllPigAction());
		updateInfoAnimalButton.addActionListener(new updateInfoAnimalAction());
		
		
		/*for (int i = 0; i< casesLabel.length; i++) {
			casesLabel[i].addActionListener(new UpdateInfoGarageAction());
		}*/

	}


	protected void initLayout() throws IOException{
		centerPanel = new JPanel();         
		shopPanel = new JPanel();   
		bottomPanel = new JPanel();
		fieldPanel = new JPanel();
		buttonPanel = new JPanel();
		
		setLayout(new BorderLayout());
		centerPanel.setLayout(new GridBagLayout());
		shopPanel.setLayout(new GridLayout(5,3));
		bottomPanel.setLayout(new GridLayout(3,3));
		fieldPanel.setLayout(new GridLayout(4,3));
        cardPanel = new JPanel();
		cardPanel.setLayout(cardLayout);
		

		
		add(centerPanel, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
       add(cardPanel, BorderLayout.EAST);
       add(buttonPanel, BorderLayout.NORTH);

		//Bottom Panel
		bottomPanel.add(goldLabel);
		bottomPanel.add(messageLabel);
		bottomPanel.add(hayLabel);
		bottomPanel.add(milkLabel);
		bottomPanel.add(grainLabel);
		bottomPanel.add(woolLabel);
		bottomPanel.add(eggLabel);
		bottomPanel.add(turnLabel);

		//Left Panel
		fieldPanel.setPreferredSize(new Dimension(600,400));
				fieldPanel.add(feedAllCowButton);
				fieldPanel.add(feedAllChickenButton);
				fieldPanel.add(feedAllPigButton);
				fieldPanel.add(feedAllSheepButton);
				fieldPanel.add(updateInfoAnimalButton);
				fieldPanel.add(sellMilkButton);
				fieldPanel.add(sellEggButton);
				fieldPanel.add(sellWoolButton);
				fieldPanel.add(updateInfoFieldButton);
				fieldPanel.add(nextTurnButton);
				fieldPanel.add(updateInfoGarageButton);

				
				//Right Panel
				shopPanel.setPreferredSize(new Dimension(500,500));
				shopPanel.add(buyTractorX1Button);
				shopPanel.add(buyTractorX2Button);
				shopPanel.add(sellTractorButton);
				shopPanel.add(repairVehicleButton);
				

				shopPanel.add(plantCarrotButton);
				shopPanel.add(plantStrawberryButton);
				
				
				shopPanel.add(buyHayButton);

				shopPanel.add(buyCowButton);
				shopPanel.add(buyChickenButton);
				shopPanel.add(buyPigButton);
				shopPanel.add(buySheepButton);
				shopPanel.add(harvestButton);
				
				
				//Center Panel
		GridBagConstraints gbc = new GridBagConstraints();
		centerPanel.setLayout(new GridBagLayout());
		int u = 0;
		while (u<=(casesLabel.length-1)) {
			for (int  p = 0; p < weight; p++) {
				for (int i = 0; i < weight; i++) {
					gbc.gridx = i;
					gbc.gridy = p;
					casesLabel[u].setBorder(null);
					casesLabel[u].setBorderPainted(false);
					casesLabel[u].setMargin(new Insets(0,0,0,0));
					centerPanel.add( casesLabel[u], gbc);
					u++;
				}
			}
		}
	      cardPanel.add(fieldPanel, "MAIN");
	        cardPanel.add(shopPanel, "SHOP");

		 btn1 = new JButton("FIELD");
	        btn1.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                cardLayout.show(cardPanel, "MAIN");
	            }
	        });
	        btn2 = new JButton("GO TO SHOP");
	        btn2.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                cardLayout.show(cardPanel, "SHOP");
	            }
	        });
	        buttonPanel.add(btn1);
	        buttonPanel.add(btn2);

	
			
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		pack();
	}



	protected void initStyle() {
		for (int i =0; i< casesLabel.length; i++) {
			casesLabel[i].setFont(LABEL_FONT);
		}
		ImageIcon icon = new ImageIcon("yoyo.png");
		Image im = icon.getImage();
		Image im2 = im.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		
		buyTractorX1Button.setIcon(new ImageIcon(im2));
		
		buyTractorX1Button.setHorizontalTextPosition(JButton.CENTER);
		buyTractorX1Button.setVerticalTextPosition(JButton.CENTER);
		buyTractorX1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//buyTractorX1Button.setFocusPainted(false);
		//buyTractorX1Button.setBorder(new LineBorder(Color.RED));


		buyTractorX1Button.setFont(BUTTON_FONT);
		buyTractorX2Button.setFont(BUTTON_FONT);
		sellTractorButton.setFont(BUTTON_FONT);
		repairVehicleButton.setFont(BUTTON_FONT);
		updateInfoGarageButton.setFont(BUTTON_FONT);

		plantCarrotButton.setFont(BUTTON_FONT);
		plantStrawberryButton.setFont(BUTTON_FONT);
		nextTurnButton.setFont(BUTTON_FONT);
		harvestButton.setFont(BUTTON_FONT);
	}


	//FIELD ACTION
	private class buyCowAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (wallet.getGold()<500){
				System.out.println("money<500");
				messageLabel.setText("Not enough money to buy cow");
				showError("NOT ENOUGH MONEY TO PROCESS");
			} else {
				int x = userChoice("Please select rows", "ADD COWS");
				int y = userChoice("Please select columns", "ADD COWS");
				if (x<=2 && y>=9 && y<= 16) {
					if (enclosures.whichAnimal(caseOp.findCase(x, y)) == 0) {
						shop.buyCow(wallet, enclosures, caseOp.findCase(x, y));
						showInfo("Cow bought", "Purchased confirmation");
						messageLabel.setText("Cow bought");
						actualizeWallet();
					} else {
						showError("ALREADY ADDED");
					}
				} else {
					messageLabel.setText("CANNOT ADD COW");
					showError("CANNOT ADD COW");
					System.out.println("CANNOT ADD COW");
				}
			}
			actualizeWallet();
			actualizeAll();
		}
	}

	private class buyChickenAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (wallet.getGold()<500){
				System.out.println("money<500");
				messageLabel.setText("Not enough money to buy chicken");
				showError("NOT ENOUGH MONEY TO PROCESS");
			} else {
				int x = userChoice("Please select rows", "ADD CHICKEN");
				int y = userChoice("Please select columns", "ADD CHICKEN");
				if (x<=5 && x>=4 && y>=9 && y<= 16) {
					if (enclosures.whichAnimal(caseOp.findCase(x, y)) == 0) {
						shop.buyChicken(wallet, enclosures, caseOp.findCase(x, y));
						showInfo("Chicken bought", "Purchased confirmation");
						messageLabel.setText("Chicken bought");
						actualizeWallet();
					} else {
						showError("ALREADY ADDED");
					}
				} else {
					messageLabel.setText("CANNOT ADD CHICKEN");
					showError("CANNOT ADD CHICKEN");
					System.out.println("CANNOT ADD CHICKEN");
				}
			}
			actualizeWallet();
			actualizeAll();
		}
	}

	private class buyPigAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (wallet.getGold()<500){
				System.out.println("money<500");
				messageLabel.setText("Not enough money to buy pig");
				showError("NOT ENOUGH MONEY TO PROCESS");
			} else {
				int x = userChoice("Please select rows", "ADD PIG");
				int y = userChoice("Please select columns", "ADD PIG");
				if (x<=8 && x>=7 && y>=9 && y<= 16) {
					if (enclosures.whichAnimal(caseOp.findCase(x, y)) == 0) {
						shop.buyPig(wallet, enclosures, caseOp.findCase(x, y));
						showInfo("Pig bought", "Purchased confirmation");
						messageLabel.setText("Pig bought");
						actualizeWallet();
					} else {
						showError("ALREADY ADDED");
					}
				} else {
					messageLabel.setText("CANNOT ADD PIG");
					showError("CANNOT ADD PIG");
					System.out.println("CANNOT ADD PIG");
				}
			}
			actualizeWallet();
			actualizeAll();
		}
	}

	private class buySheepAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (wallet.getGold()<500){
				System.out.println("money<500");
				messageLabel.setText("Not enough money to buy sheep");
				showError("NOT ENOUGH MONEY TO PROCESS");
			} else {
				int x = userChoice("Please select rows", "ADD SHEEP");
				int y = userChoice("Please select columns", "ADD SHEEP");
				if (x<=11 && x>=10 && y>=9 && y<= 16) {
					if (enclosures.whichAnimal(caseOp.findCase(x, y)) == 0) {
						shop.buySheep(wallet, enclosures, caseOp.findCase(x, y));
						showInfo("Sheep bought", "Purchased confirmation");
						messageLabel.setText("Sheep bought");
						actualizeWallet();
					} else {
						showError("ALREADY ADDED");
					}
				} else {
					messageLabel.setText("CANNOT ADD SHEEP");
					showError("CANNOT ADD SHEEP");
					System.out.println("CANNOT ADD SHEEP");
				}
			}
			actualizeWallet();
			actualizeAll();
		}
	}

	private class feedAllCowAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (hay.getHay() > enclosures.totalCow()) {
				enclosures.feedAllCow();
				hay.removeHay(enclosures.totalCow());
				actualizeHay();
			}	
		}	
	}

	private class feedAllSheepAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (hay.getHay() > enclosures.totalSheep()) {
				enclosures.feedAllSheep();
				hay.removeHay(enclosures.totalSheep());
				actualizeHay();
			}	
		}	
	}

	private class feedAllChickenAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (grain.getGrain() > enclosures.totalChicken()) {
				enclosures.feedAllChicken();
				grain.removeGrain(enclosures.totalChicken());
				actualizeHay();
			}	
		}	
	}
	
	private class feedAllPigAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			if (grain.getGrain() > enclosures.totalPig()) {
				enclosures.feedAllPig();
				grain.removeGrain(enclosures.totalPig());
				actualizeHay();
			}	
		}	
	}
	
	private class updateInfoAnimalAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int x = userChoice("Please select rows", "INFO ANIMAL");
			int y = userChoice("Please select columns", "ADD ANIMAL");
			if (enclosures.whichAnimal(caseOp.findCase(x, y)) == 0) {
				showError("ANIMAL NOT FOUND");
			} else {
				Animal animal =enclosures.accesValue(caseOp.findCase(x, y));
				showInfo(animal.toString(), "info");
			}
		}
		}


	//Repair
	private class repairVehicleAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int x = userChoice("Please select rows", "REPAIR VEHICLE");
			int y = userChoice("Please select columns", "REPAIR VEHICLE");
			if (x<=2 && y<=6) {
				showError("OUT ZONE");
			}
			else if (garages.whichVehicle(caseOp.findCase(x, y)) == 0) {
				showError("TRACTOR NOT FOUND");
			} else {
				shop.repairTractor(wallet, garages, caseOp.findCase(x, y));
				showInfo("Tractor repaired", "Repair confirmation");
				messageLabel.setText("Tractor repaired");
				actualizeWallet();
				actualizeAll();
			}
		}
	}

	//Buy TractorX1
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
					int x = userChoice("Please select rows", "ADD TRACTOR X1");
					int y = userChoice("Please select columns", "ADD TRACTOR X1");
					if (x<=2 && y<=6) {
						if (garages.whichVehicle(caseOp.findCase(x, y)) == 0) {
							shop.buyTractorX1(wallet,garages, caseOp.findCase(x, y));
							showInfo("Tractor X1 bought", "Purchased confirmation");
							messageLabel.setText("Tractor X1 bought");
							actualizeWallet();
						} else {
							showError("ALREADY ADDED");
						}
					} else {
						messageLabel.setText("CANNOT ADD TRACTOR");
						showError("CANNOT ADD TRACTOR");
						System.out.println("CANNOT ADD TRACTOR");
					}
				} 
			}
			actualizeWallet();
			actualizeAll();
		}
	}

	//Buy TractorX2
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
					int x = userChoice("Please select rows", "ADD TRACTOR X2");
					int y = userChoice("Please select columns", "ADD TRACTOR X2");
					if (x<=2 && y<=6) {
						if (garages.whichVehicle(caseOp.findCase(x, y)) == 0) {
							shop.buyTractorX2(wallet,garages, caseOp.findCase(x, y));
							showInfo("Tractor X2 bought", "Purchased confirmation");
							messageLabel.setText("Tractor X2 bought");
							actualizeWallet();
						}  else {
							showError("ALREADY ADDED");
						}
					} else {
						messageLabel.setText("CANNOT ADD TRACTOR");
						showError("CANNOT ADD TRACTOR");
						System.out.println("CANNOT ADD TRACTOR");
					}
				} 
			}
			actualizeWallet();
			actualizeAll();
		}
	}

	// Sell Tractor
	private class sellTractorAction implements ActionListener {
		public void actionPerformed(ActionEvent e){

			if (garages.getNumberVehicle()==0){
				System.out.println("No item to sell");
				messageLabel.setText("No item to sell");
				showError("TRACTOR NOT FOUND");
			}
			else {
				int x = userChoice("Please select rows", "SELL TRACTOR");
				int y = userChoice("Please select columns", "SELL TRACTOR");
				shop.sellTractor(wallet,garages, caseOp.findCase(x,y));
				System.out.println("Item sold");
				System.out.println("Current number of vehicle: " + garages.getNumberVehicle());
				showInfo("Tractor removed", "Sold confirmation");
				messageLabel.setText("Item sold");
			}
			actualizeWallet();
			actualizeAll();
		}
	}



	private class UpdateInfoGarageAction implements ActionListener {

		public void actionPerformed(ActionEvent e){
			int x = userChoice("Please select rows", "UPDATE INFO TRACTOR");
			int y = userChoice("Please select columns", "UPDATE INFO TRACTOR");
			if (garages.whichVehicle(caseOp.findCase(x,y)) == 0) {
				showError("TRACTOR NOT FOUND");
			} else {
				messageLabel.setText(garages.updateStatus(caseOp.findCase(x,y)));
				showInfo(garages.updateStatus(caseOp.findCase(x,y)), "Infomation");
			}
		}
	}
	
	

	private class UpdateInfoGarageAction2 implements ActionListener {

		public void actionPerformed(ActionEvent e){
			int x = (int)((JComponent) e.getSource()).getClientProperty( "x" );
			int y =  (int)((JComponent) e.getSource()).getClientProperty( "y" );
			if (garages.whichVehicle(caseOp.findCase(x,y)) == 0) {
				showError("TRACTOR NOT FOUND");
			} else {
				messageLabel.setText(garages.updateStatus(caseOp.findCase(x,y)));
				showInfo(garages.updateStatus(caseOp.findCase(x,y)), "Infomation");
			}
		}
	}

	private class harvestAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int x = userChoice("Please select rows", "TRACTOR TO BE USED");
			int y = userChoice("Please select columns", "TRACTOR TO BE USED");
			Vehicle v = garages.accesValue(caseOp.findCase(x,y));
			int z = userChoice("Please select rows", "CROP TO BE HARVESTED");
			int t = userChoice("Please select columns", "CROP TO BE HARVESTED");
			if (fields.accesValue(caseOp.findCase(z,t)).isHarvested()) {
				fields.removeCrop(caseOp.findCase(z,t));
				v.harvestStatus();
				showInfo("HARVESTED", "Infomation");
			} else {
				showInfo("NOT ENOUGH AGE TO HARVEST", "Information");
			}
			actualizeWallet();
			actualizeAll();
		}
	}

	public void actualizeTractor() {
		ImageIcon tractor = new ImageIcon("tractorx1road.jpg");
		ImageIcon tractor1 = new ImageIcon("tractorx2road.jpg");
		ImageIcon blank = new ImageIcon("road.jpg");
		for (int x=1; x<=2; x++) {
			for (int y=1; y<=6; y++) {
				int valV = garages.whichVehicle(caseOp.findCase(x, y));
				int i = caseOp.findIndex(x, y);
			if (valV == 1) {
				casesLabel[i].setIcon(tractor);
				casesLabel[i].setBorder(null);
				casesLabel[i].setBorderPainted(false);
				casesLabel[i].setMargin(new Insets(0,0,0,0));
			} else if (valV == 2) {
				casesLabel[i].setIcon(tractor1);
				casesLabel[i].setBorder(null);
				casesLabel[i].setBorderPainted(false);
				casesLabel[i].setMargin(new Insets(0,0,0,0));
			} else {
					casesLabel[i].setIcon(blank);
					casesLabel[i].setBorder(null);
					casesLabel[i].setBorderPainted(false);
					casesLabel[i].setMargin(new Insets(0,0,0,0));
				}
			}
		}
	}
	
	public void actualizeAnimal() {
		ImageIcon cow = new ImageIcon("cowgrass.jpg");
		ImageIcon chicken = new ImageIcon("chickenstraw.jpg");
		ImageIcon pig = new ImageIcon("pigsoli.jpg");
		ImageIcon sheep = new ImageIcon("sheepgrass.jpg");
		ImageIcon grass = new ImageIcon("grass.jpg");
		ImageIcon straw = new ImageIcon("straw.jpg");
		ImageIcon soli = new ImageIcon("soli.jpg");
		//For Cow
		for (int x=1; x<=2; x++) {
			for (int y=9; y<=16; y++) {
				int valE = enclosures.whichAnimal(caseOp.findCase(x, y));
				int i = caseOp.findIndex(x, y);
				if (valE == 1) {
					casesLabel[i].setIcon(cow);
					casesLabel[i].setBorder(null);
					casesLabel[i].setBorderPainted(false);
					casesLabel[i].setMargin(new Insets(0,0,0,0));
				} else {
					casesLabel[i].setIcon(grass);
					casesLabel[i].setBorder(null);
					casesLabel[i].setBorderPainted(false);
					casesLabel[i].setMargin(new Insets(0,0,0,0));
				}
			}
			}
		//For Chicken
		for (int x=4; x<=5; x++) {
			for (int y=9; y<=16; y++) {
				int valE = enclosures.whichAnimal(caseOp.findCase(x, y));
				int i = caseOp.findIndex(x, y);
				if (valE == 2) {
					casesLabel[i].setIcon(chicken);
					casesLabel[i].setBorder(null);
					casesLabel[i].setBorderPainted(false);
					casesLabel[i].setMargin(new Insets(0,0,0,0));
				} else {
					casesLabel[i].setIcon(straw);
					casesLabel[i].setBorder(null);
					casesLabel[i].setBorderPainted(false);
					casesLabel[i].setMargin(new Insets(0,0,0,0));
				}
			}
			}
		//For Pig
				for (int x=7; x<=8; x++) {
					for (int y=9; y<=16; y++) {
						int valE = enclosures.whichAnimal(caseOp.findCase(x, y));
						int i = caseOp.findIndex(x, y);
						if (valE == 3) {
							casesLabel[i].setIcon(pig);
							casesLabel[i].setBorder(null);
							casesLabel[i].setBorderPainted(false);
							casesLabel[i].setMargin(new Insets(0,0,0,0));
						} else {
							casesLabel[i].setIcon(soli);
							casesLabel[i].setBorder(null);
							casesLabel[i].setBorderPainted(false);
							casesLabel[i].setMargin(new Insets(0,0,0,0));
						}
					}
					}
				//For Sheep
				for (int x=10; x<=11; x++) {
					for (int y=9; y<=16; y++) {
						int valE = enclosures.whichAnimal(caseOp.findCase(x, y));
						int i = caseOp.findIndex(x, y);
						if (valE == 4) {
							casesLabel[i].setIcon(sheep);
							casesLabel[i].setBorder(null);
							casesLabel[i].setBorderPainted(false);
							casesLabel[i].setMargin(new Insets(0,0,0,0));
						} else {
							casesLabel[i].setIcon(grass);
							casesLabel[i].setBorder(null);
							casesLabel[i].setBorderPainted(false);
							casesLabel[i].setMargin(new Insets(0,0,0,0));
						}
					}
					}
		
	}

	public void actualizeCrop() {
		ImageIcon carrot = new ImageIcon("carrotground.jpg");
		ImageIcon strawberry = new ImageIcon("strawberryground.jpgg");
		ImageIcon ground = new ImageIcon("ground.jpg");
		for (int x=4; x<=13; x++) {
			for (int y=1; y<=6; y++) {
				int valF = fields.whichCrop(caseOp.findCase(x, y));
				int i = caseOp.findIndex(x, y);
				if (valF == 3) {
					casesLabel[i].setIcon(carrot);
					casesLabel[i].setBorder(null);
					casesLabel[i].setBorderPainted(false);
					casesLabel[i].setMargin(new Insets(0,0,0,0));
				} else if (valF == 4) {
					casesLabel[i].setIcon(strawberry);
					casesLabel[i].setBorder(null);
					casesLabel[i].setBorderPainted(false);
					casesLabel[i].setMargin(new Insets(0,0,0,0));
			} else {
				casesLabel[i].setIcon(ground);
				casesLabel[i].setBorder(null);
				casesLabel[i].setBorderPainted(false);
				casesLabel[i].setMargin(new Insets(0,0,0,0));
			}
			}
	}
	}
	
	public void actualizeAll() {
		actualizeTractor();
		actualizeAnimal();
		actualizeCrop();
	}


	public void actualizeWallet(){
		goldLabel.setText("Gold : "+String.valueOf(wallet.getGold()));
	}

	public void showError(String custom) {
		JOptionPane.showMessageDialog(new JFrame(), custom, "Error",
				JOptionPane.ERROR_MESSAGE);
	}


	// Turn management
	private class nextTurnAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			turn.goTurn();
			turn.turnCrops(fields, caseOp);
			turn.turnAnimal(enclosures, caseOp, milk, egg, wool);
			actualizeAll();
			actualizeMilk();
			actualizeEgg();
			actualizeWool();
			actualizeTurn();
		}
	}


	private class updateInfoFieldAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int x = userChoice("Please select rows", "UPDATE INFO CROP");
			int y = userChoice("Please select columns", "UPDATE INFO CROP");
			if (fields.whichCrop(caseOp.findCase(x,y)) == 0) {
				showError("CROP NOT FOUND");
			} else {
				messageLabel.setText(fields.updateStatus(caseOp.findCase(x,y)));
				showInfo(fields.updateStatus(caseOp.findCase(x,y)), "Infomation");
			}
		}
	}

	//Plant carrot
	private class plantCarrotAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int x = userChoice("Please select rows", "PLANT CARROT");
			int y = userChoice("Please select columns", "PLANT CARROT");
			if (x >=4 && x <= 13 && y <= 6) {
				if (fields.whichCrop(caseOp.findCase(x,y))==0) {
					fields.addCrop(caseOp.findCase(x,y), 1);
					messageLabel.setText("ADDED");
					actualizeAll();
				} else {
					showError("ALREADY ADDED");
				}
			} else {
				messageLabel.setText("CANNOT ADD CARROT");
				showError("CANNOT ADD CARROT");
				System.out.println("CANNOT ADD CARROT");
			}
		}	
	}


	//Plant strawberry
	private class plantStrawberryAction implements ActionListener {
		public void actionPerformed(ActionEvent e){
			int x = userChoice("Please select rows", "PLANT STRAWBERRY");
			int y = userChoice("Please select columns", "PLANT STRAWBERRY");
			if (x >=4 && x <= 13 && y <= 6) {
				if (fields.whichCrop(caseOp.findCase(x,y))==0) {
					fields.addCrop(caseOp.findCase(x,y), 2);
					messageLabel.setText("ADDED");
					actualizeAll();
				} else {
					showError("ALREADY ADDED");
				}
			} else {
				messageLabel.setText("CANNOT ADD STRAWBERRY");
				showError("CANNOT ADD STRAWBERRY");
				System.out.println("CANNOT ADD STRAWBERRY");
			}
		}
	}

	public int userChoice(String info, String title) {
		try {
			Integer index = (Integer)JOptionPane.showInputDialog(new JFrame(), info, title,
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), possibilities, 1);
			return index; 
		} catch(NullPointerException e) {
			return 0;
		}
	}
	
	//add this method
	/*public int userChoice(String info, String title, Integer[] possibilities) {
		try {
			Integer index = (Integer)JOptionPane.showInputDialog(new JFrame(), info, title,
					JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), possibilities, 1);
			return index; 
		} catch(NullPointerException e) {
			return 0;
		}
	}*/
	/*
	//Example to use it
	Integer[] xlimitedpossibilities={1,2};
	int x = userChoice("Please select rows", "PLANT STRAWBERRY", xlimitedpossibilities);
	Integer[] ylimitedpossibilities={1,2,3,4,5,6};
	int y = userChoice("Please select columns", "PLANT STRAWBERRY", ylimitedpossibilities);
	*/
	

	//Buy hay
	private class buyHayAction implements ActionListener {

		public void actionPerformed(ActionEvent e){
			if (wallet.getGold()<(hay.getHay()*10)){ 
				showError("NOT ENOUGH MONEY TO BUY HAY");
			} else{
			shop.buyHay(wallet, hay);
			actualizeHay();
			actualizeWallet();
			messageLabel.setText("Hay Bought");
		}
	}
	}

	public void actualizeHay(){
		hayLabel.setText("Hay : "+String.valueOf(hay.getHay()));
	}

	public void showInfo(String custom, String title) {
		JOptionPane.showMessageDialog(new JFrame(), custom, title,
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void showInfo(String custom, String title, int i) {
		JOptionPane.showMessageDialog(new JFrame(), custom+"a", title,
				JOptionPane.INFORMATION_MESSAGE);
	}



	public Position getPosition(int index) {
		return caseOp.accesValue(index);
	}

	public void actualizeMilk(){
		milkLabel.setText("Milk : "+String.valueOf(milk.getMilk()));
	}
	
	public void actualizeEgg(){
		eggLabel.setText("Egg : "+String.valueOf(egg.getEgg()));
	}
	
	public void actualizeWool(){
		woolLabel.setText("Wool : "+String.valueOf(wool.getWool()));
	}
	
	public void actualizeGrain(){
		grainLabel.setText("Grain : "+String.valueOf(grain.getGrain()));
	}
	
	public void actualizeTurn(){
		turnLabel.setText("Turn : "+String.valueOf(turn.getTurn()));
	}

	public static void main(String[] args) throws IOException {
		new IHM_Demo("Demo");
	}
}
