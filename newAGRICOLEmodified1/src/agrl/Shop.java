package agrl;

public class Shop {
	
	public Shop(){
		
	}
	
	//Vaches
	
	public void buyCow(Wallet wallet, String nom, EnclosureCow enclosureCow){
		if (wallet.getGold()<500){
			//message non
		}
		
		else if(enclosureCow.getNumberOfCows()>3){
			//message trop de vache
		}
		
		else{
			Cow cowbought = new Cow(nom,100,0);
			enclosureCow.addCow(cowbought);
			wallet.removeGold(500);
			System.out.println(wallet.getGold());
		}
		
	}
	
	public void sellCow(Wallet wallet, EnclosureCow enclosureCow){
		if (enclosureCow.getNumberOfCows()==0){
			//message pas de vache a vendre
		}
		else {
			enclosureCow.supCow(0);
			wallet.addGold(250);
		}
	}
	
	public void buyAndFeedCows(Wallet wallet, EnclosureCow enclos){
		if (wallet.getGold()<(10*enclos.getNumberOfCows())){
			//message non
		}
		
		else{
			wallet.removeGold(10*enclos.getNumberOfCows());
			enclos.feedEveryCows();
		}
		
	}
	
	public void feedCows(Hay hay, EnclosureCow enclos){
		if (hay.getHay()<enclos.getNumberOfCows()){
			
		}
		else{
			enclos.feedEveryCows();
			hay.removeHay(enclos.getNumberOfCows());
		}
		
	}
	
	//Poules
	
	public void buyChicken(Wallet wallet, String nom, EnclosureChicken enclos){
		if (wallet.getGold()<500){
			//message non
		}
		
		else if(enclos.getNumberOfChickens()>3){
			//message trop de poules
		}
		
		else{
			Chicken chickenbought = new Chicken(nom,100,0);
			enclos.addChicken(chickenbought);
			wallet.removeGold(500);
			System.out.println(wallet.getGold());
		}
		
	}
	
	public void sellChicken(Wallet wallet, EnclosureChicken enclos){
		if (enclos.getNumberOfChickens()==0){
			//message pas de poules a vendre
		}
		else {
			enclos.supChicken(0);
			wallet.addGold(250);
		}
	}
	
	
	public void feedChickens(Grain grain, EnclosureChicken enclos){
		if (grain.getGrain()<enclos.getNumberOfChickens()){
			
		}
		else{
			enclos.feedEveryChickens();
			grain.removeGrain(enclos.getNumberOfChickens());
		}
		
	}
	
	//Moutons
	
	public void buySheep(Wallet wallet, String nom, EnclosureSheep enclosure){
		if (wallet.getGold()<500){
			//message non
		}
		
		else if(enclosure.getNumberOfSheeps()>3){
			//message trop de moutons
		}
		
		else{
			Sheep sheepbought = new Sheep(nom,100,0);
			enclosure.addSheep(sheepbought);
			wallet.removeGold(500);
			System.out.println(wallet.getGold());
		}
		
	}
	
	public void sellSheep(Wallet wallet, EnclosureSheep enclosure){
		if (enclosure.getNumberOfSheeps()==0){
			//message pas de vache a vendre
		}
		else {
			enclosure.supSheep(0);
			wallet.addGold(250);
		}
	}
	
	public void feedSheeps(Hay hay, EnclosureSheep enclos){
		if (hay.getHay()<enclos.getNumberOfSheeps()){
			
		}
		else{
			enclos.feedEverySheeps();
			hay.removeHay(enclos.getNumberOfSheeps());
		}
		
	}
	
	//Pig
	
	public void buyPig(Wallet wallet, String nom, EnclosurePig enclosure){
		if (wallet.getGold()<500){
			//message non
		}
		
		else if(enclosure.getNumberOfPigs()>3){
			//message trop de cochons
		}
		
		else{
			Pig pigbought = new Pig(nom,100,0);
			enclosure.addPig(pigbought);
			wallet.removeGold(500);
			System.out.println(wallet.getGold());
		}
		
	}
	
	public void sellPig(Wallet wallet, EnclosurePig enclosure){
		if (enclosure.getNumberOfPigs()==0){
			//message pas de vache a vendre
		}
		else {
			enclosure.supPig(0);
			wallet.addGold(250);
		}
	}
	
	public void feedPigs(Grain grain, EnclosurePig enclos){
		if (grain.getGrain()<enclos.getNumberOfPigs()){
			
		}
		else{
			enclos.feedEveryPigs();
			grain.removeGrain(enclos.getNumberOfPigs());
		}
		
	}
	
	
	public void buyHay(Wallet wallet, Hay hay){
		if (wallet.getGold()<(hay.getHay()*10)){ // chaque hay coute 10g
			//message non pas assez
		}
		else{
			wallet.removeGold(10);
			hay.addHay(1);
		}
	}
	
	public void sellMilk(Milk milk, Wallet wallet){
		if(milk.getMilk()<=0){
		}
		else{
			milk.removeMilk(1);
			wallet.addGold(50);
		}
	}
	
	public void sellEgg(Egg egg, Wallet wallet){
		if(egg.getEgg()<=0){
		}
		else{
			egg.removeEgg(1);
			wallet.addGold(50);
		}
	}
	
	public void sellWool(Wool wool, Wallet wallet){
		if(wool.getWool()<=0){
		}
		else{
			wool.removeWool(1);
			wallet.addGold(50);
		}
	}
	
	

}
