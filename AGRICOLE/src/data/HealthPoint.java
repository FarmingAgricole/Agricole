package data;

public class HealthPoint {
	
	protected int currenthealth ;
	protected int maxhealth ;
	
	public HealthPoint (){		
	}
	
	public HealthPoint (int currenthealth, int maxhealth){
		this.currenthealth = currenthealth;
		this.maxhealth = maxhealth;
	}
	
	public String tostring(){
		return this.currenthealth+"/"+this.maxhealth+" HP";
	}
}
