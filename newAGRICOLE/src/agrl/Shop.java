package agrl;

public class Shop {
	
	public Shop(){
		
	}
	
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

}
