package agrl;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class IHM extends JFrame {
	
	EnclosureCow enclosvaches = new EnclosureCow();
	Wallet wallet = new Wallet(1500); // ARGENT DE DEPART
	Shop shop = new Shop();
	Turn turn = new Turn();
	Milk milk = new Milk();
	Hay hay = new Hay();
	
	ImageIcon grassIcon = new ImageIcon("grass.jpg");
	
	protected JLabel case0 = new JLabel(grassIcon);
	protected JLabel case1 = new JLabel(grassIcon);
	protected JLabel case2 = new JLabel(grassIcon);
	protected JLabel case3 = new JLabel(grassIcon);
	
	protected JButton buyCowButton = new JButton("BuyCow(-500)");
	protected JButton sellCowButton = new JButton("SellCow(+250)");
	protected JButton feedCowButton = new JButton("FeedCow");
	protected JButton nextTurnButton = new JButton("nextTurn");
	
	protected JLabel turnLabel = new JLabel("Turn : "+turn.getTurn());
	protected JLabel messageLabel = new JLabel("message");
	protected JLabel walletLabel = new JLabel("Wallet :");
	protected JLabel goldLabel = new JLabel("Gold : "+String.valueOf(wallet.getGold()));
	
	protected JLabel milkLabel = new JLabel("Milk : "+milk.getMilk());
	protected JButton sellMilkButton = new JButton("Sell Milk(+50)");
	protected JLabel hayLabel = new JLabel("Hay : "+hay.getHay());
	protected JButton buyHayButton = new JButton("Buy Hay(-10)");
	
	private static final Font LABEL_FONT = new Font(Font.MONOSPACED, Font.BOLD, 40);
	private static final Font BUTTON_FONT = new Font(Font.DIALOG, Font.BOLD, 20);
	
	public IHM(String title) throws IOException {
		
		super(title);
		
		initStyle();
	
		initLayout();
		
		initActions();
	
	}
	
	protected void initLayout() throws IOException{
		
		GridLayout grid = new GridLayout(4,4);
		Container contentPane = getContentPane();
		contentPane.setLayout(grid);
		
		
		contentPane.add(case0);
		contentPane.add(case1);
		contentPane.add(case2);
		contentPane.add(case3);
		
		contentPane.add(buyCowButton);
		contentPane.add(sellCowButton);
		contentPane.add(feedCowButton);
		contentPane.add(nextTurnButton);
		
		contentPane.add(turnLabel);
		contentPane.add(messageLabel);
		contentPane.add(walletLabel);
		contentPane.add(goldLabel);
		
		contentPane.add(milkLabel);
		contentPane.add(sellMilkButton);
		contentPane.add(hayLabel);
		contentPane.add(buyHayButton);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 600);
		setResizable(false);
		setVisible(true);
		
	}
	
	protected void initStyle() {

		case0.setFont(LABEL_FONT);
		case1.setFont(LABEL_FONT);
		case2.setFont(LABEL_FONT);
		case3.setFont(LABEL_FONT);
		buyCowButton.setFont(BUTTON_FONT);
		sellCowButton.setFont(BUTTON_FONT);
		feedCowButton.setFont(BUTTON_FONT);
		nextTurnButton.setFont(BUTTON_FONT);
	}
	
	protected void initActions(){
		buyCowButton.addActionListener(new BuyCowAction());
		sellCowButton.addActionListener(new SellCowAction());
		feedCowButton.addActionListener(new FeedCowAction());
		nextTurnButton.addActionListener(new NextTurnAction());
		sellMilkButton.addActionListener(new SellMilkAction());
		buyHayButton.addActionListener(new BuyHayAction());
		case0.addMouseListener(new Case0Action());
	}
	
	private class Case0Action implements MouseListener{
		
		public void mouseClicked(MouseEvent e){
			
			messageLabel.setText("msg : "+(enclosvaches.get(0)).getName());
			System.out.println("name : "+(enclosvaches.get(0)).getName()+
					" HP:"+(enclosvaches.get(0)).getHealthPoint());
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private class BuyCowAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
			if (wallet.getGold()<500){
					//message non
				System.out.println("argent<500");
				messageLabel.setText("Pas assez pour acheter une vache");
			}
				
			else if(enclosvaches.getNumberOfCows()>3){
					//message trop de vache
				System.out.println("Trop de vache");
				messageLabel.setText("Trop de vache");
			}
				
			else{
				System.out.println("Vache achetée");
				shop.buyCow(wallet,"Vache",enclosvaches);
				messageLabel.setText("Vache achetée");
			}
			
			actualizeCowIcon();
			actualizeWallet();
			
			
		}
	}
	
	private class SellCowAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
			if (enclosvaches.getNumberOfCows()==0){
				//message pas de vache a vendre
				System.out.println("Pas de vache a vendre");
				messageLabel.setText("Pas de vache a vendre");
			}
			else {
				shop.sellCow(wallet,enclosvaches);
				System.out.println("Vache vendue");
				messageLabel.setText("Vache vendue");
			}
			
			actualizeCowIcon();
			actualizeWallet();	
			
		}
	}
	
	private class FeedCowAction implements ActionListener {
		
		public void actionPerformed(ActionEvent e){
			
			shop.feedCows(hay, enclosvaches);
			actualizeCowIcon();
			actualizeWallet();
			actualizeHay();
			messageLabel.setText("");
			
		}
	}

	private class NextTurnAction implements ActionListener {
	
	public void actionPerformed(ActionEvent e){
		
		turn.nextTurn(enclosvaches, milk);
		
		actualizeCowIcon();
		actualizeWallet();
		actualizeTurn();
		actualizeMilk();
		messageLabel.setText("Tour passé");
		
		}
	}
	
	private class SellMilkAction implements ActionListener {
		
	public void actionPerformed(ActionEvent e){
		
		shop.sellMilk(milk, wallet);
		actualizeMilk();
		actualizeWallet();
		messageLabel.setText("");
		
		
		}
	}
	
	private class BuyHayAction implements ActionListener {
		
	public void actionPerformed(ActionEvent e){
		
		shop.buyHay(wallet, hay);
		actualizeHay();
		actualizeWallet();
		messageLabel.setText("");
		}
	}
	
	public void actualizeCowIcon(){
		
		int i=0;
		ImageIcon cowIcon = new ImageIcon("cow.jpg");
		ImageIcon cowfedIcon = new ImageIcon("cowfed.jpg");
		ImageIcon grassIcon = new ImageIcon("grass.jpg");
		if (i<enclosvaches.getNumberOfCows()){
			if ((enclosvaches.get(i)).getFed()){case0.setIcon(cowfedIcon);}
			else{case0.setIcon(cowIcon);}
			i++;
		}
		else {case0.setIcon(grassIcon);}
		if (i<enclosvaches.getNumberOfCows()){
			if ((enclosvaches.get(i)).getFed()){case1.setIcon(cowfedIcon);}
			else{case1.setIcon(cowIcon);}
			i++;
		}
		else {case1.setIcon(grassIcon);}
		if (i<enclosvaches.getNumberOfCows()){
			if ((enclosvaches.get(i)).getFed()){case2.setIcon(cowfedIcon);}
			else{case2.setIcon(cowIcon);}
			i++;
		}
		else {case2.setIcon(grassIcon);}
		if (i<enclosvaches.getNumberOfCows()){
			if ((enclosvaches.get(i)).getFed()){case3.setIcon(cowfedIcon);}
			else{case3.setIcon(cowIcon);}
			i++;
		}
		else {case3.setIcon(grassIcon);}
		
	}
	
	public void actualizeWallet(){
		goldLabel.setText("Gold : "+String.valueOf(wallet.getGold()));
	}
	
	public void actualizeMilk(){
		milkLabel.setText("Milk : "+String.valueOf(milk.getMilk()));
	}
	
	public void actualizeTurn(){
		turnLabel.setText("Turn : "+String.valueOf(turn.getTurn()));
	}
	
	public void actualizeHay(){
		hayLabel.setText("Hay : "+String.valueOf(hay.getHay()));
	}
	
	
	public static void main(String[] args) throws IOException {
		new IHM("réussite IHM");
	}
	
	

	
}
