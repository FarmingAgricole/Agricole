package agrl;

public class Hay {
	
	protected int hay = 0;
	
	public Hay(){
		
	}
	
	public int getHay(){
		return this.hay;
	}
	
	public void setHay(int amount){
		this.hay = amount;
	}
	
	public void addHay(int amount){
		this.hay = this.hay + amount;
	}
	
	public void removeHay(int amount){
		this.hay = this.hay - amount;
	}

}
