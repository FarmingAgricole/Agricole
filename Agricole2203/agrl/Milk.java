package agrl;

public class Milk {
	
	protected int milk = 0;
	
	public Milk(){
		
	}
	
	public int getMilk(){
		return this.milk;
	}
	
	public void addMilk(int amount){
		this.milk = this.milk + amount;
	}
	
	public void removeMilk(int amount){
		this.milk = this.milk - amount;
	}

}
