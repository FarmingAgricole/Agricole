package agrl;

public class Strawberry extends Fruit{
	
	protected static int maxhealth = 100;
	protected int id;
	private int dateofharvest;

	
	public Strawberry(){
		super();
	}
	
	public Strawberry(int healthpoint, int age){ 
		super(healthpoint,maxhealth, age);
	}
	
	//public Strawberry(int healthpoint, int age,int id){ 
		//super(healthpoint,maxhealth);
		//this.age = age ;
		//this.id = id ;
	//}
	
	
	public void isThirsty(){
		this.setHealthPoint(this.getHealthPoint()-20);
	}
	
	public String toString(){
		return "\n"+"Age:"+age+"jours"+"\n"+"ID:"+id+"\n" + "CAN HAR: " + isHarvested()
	+super.toString(); //affiche le nom, l'age, les points de vie et l'etat
		
	}
	
	public boolean isHarvested() {
		boolean res;
		if (age >= dateofharvest) {
			res = true;
		} else {
			res = false;
	}	
		return res;
	}
	

}
