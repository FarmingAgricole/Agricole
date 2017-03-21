package agrl;

public class Grain {
	
	protected int grain;
	
	public Grain(){
		
	}
	
	public int getGrain(){
		return this.grain;
	}
	
	public void setGrain(int amount){
		this.grain=amount;
	}
	
	public void addGrain(int amount){
		this.grain = this.grain + amount;
	}

	public void removeGrain(int amount) {
		this.grain = this.grain - amount;
		
	}

}
