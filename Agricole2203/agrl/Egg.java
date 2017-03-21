package agrl;

public class Egg {
	
	protected int egg = 0;
	
	public Egg(){
		
	}
	
	public int getEgg(){
		return this.egg;
	}
	
	public void addEgg(int amount){
		this.egg = this.egg + amount;
	}
	
	public void removeEgg(int amount){
		this.egg = this.egg - amount;
	}

}
