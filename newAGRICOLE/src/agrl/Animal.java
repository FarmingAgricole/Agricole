package agrl;

//refonte fraiche le 25/02/2017
public abstract class Animal extends Shape {
	
	protected boolean fed = false;
	
	public Animal(){
		super();
	}
	
	public Animal(int healthpoint, int maxhealth){
		
		super(healthpoint,maxhealth);
	}
	
	public void setHealtPoint(int currenthealth){ //change les points de vie
		super.setHealthPoint(currenthealth);
	}
	
	public int getHealthPoint(){ //retourne les points de vie
		return super.getHealthPoint();
	}
	
	public void isStarving(){
		super.setHealthPoint(super.getHealthPoint()-20);
	}
	
	public String getShape(){
		return super.getShape();
	}
	
	public void feed(){
		this.fed=true;
	}
	
	public void starve(){
		this.fed=false;
	}
	
	public boolean getFed(){
		return this.fed;
	}
	
	public String toString(){
		return super.toString();
	}
	
}