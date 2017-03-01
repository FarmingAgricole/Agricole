package agrl;

public class Wallet {
	
	protected int gold = 0;
	
	public Wallet(){
		
	}
	
	public Wallet(int amount){
		
		this.gold = amount;
		
	}
	
	public int getGold(){
		return this.gold;
	}
	
	public void addGold(int amount){
		this.gold = this.gold + amount;
	}
	
	public void removeGold(int amount){
		this.gold = this.gold - amount;
	}

}
