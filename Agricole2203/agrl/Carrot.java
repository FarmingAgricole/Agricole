package agrl;

import java.io.IOException;

public class Carrot extends Vegetable{
	
	protected static int maxhealth = 100;
	protected int id;
	protected static int lapsingmax=30;
	protected int dateofharvest = 3; // retient a quel tour on a récolté la culture
	public Carrot(){
		super();
	}
	
	public Carrot(int healthpoint, int age){ 
		super(healthpoint,maxhealth, age);
	}
	
//	public Carrot(int healthpoint, int age,int id){ 
	//	super(healthpoint,maxhealth,lapsingmax);
		//this.age = age ;
		//this.id = id ;
	//}
	
	
	
	public void isThirsty(){ // est désecher et perd de la vie
		this.setHealthPoint(this.getHealthPoint()-20);
	}
	
	public String toString(){
		return "\n"+"Age:"+age+"jours"+"\n"+"ID:"+id+"\n"+ "CAN HAR: " + isHarvested() +
				"\n" +
	super.toString(); //affiche le nom, l'age, les points de vie et l'etat
		
	}
	
	public int getDate() {
		return dateofharvest;
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
