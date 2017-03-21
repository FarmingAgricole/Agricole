package agrl;

public class Wool {
	
	protected int wool = 0;
	
	public Wool(){
		
	}
	
	public int getWool(){
		return this.wool;
	}
	
	public void addWool(int amount){
		this.wool = this.wool + amount;
	}
	
	public void removeWool(int amount){
		this.wool = this.wool - amount;
	}

}
