package agrl;

public class HealthPoint {
	
	protected int currenthealth ;
	protected int maxhealth ;
	
	public HealthPoint (){		
	}
	
	public HealthPoint (int currenthealth, int maxhealth){
		this.currenthealth = currenthealth;
		this.maxhealth = maxhealth;
	}
	
	public String toString(){
		return this.currenthealth+"/"+this.maxhealth+" HP";
	}
	
	public void setHealthPoint(int currenthealth){ //change les points de vie
		this.currenthealth = currenthealth;
	}
	
	public int getHealthPoint(){ //retourne les points de vie
		return currenthealth;
	}
	
}