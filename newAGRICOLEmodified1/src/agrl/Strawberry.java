package agrl;

public class Strawberry extends Fruit{
	
	protected static int maxhealth = 100;
	protected int age;
	protected int id;

	
	public Strawberry(){
		super();
	}
	
	public Strawberry(int healthpoint, int age){ 
		super(healthpoint,maxhealth);
		this.age = age ;
	}
	
	public Strawberry(int healthpoint, int age,int id){ 
		super(healthpoint,maxhealth);
		this.age = age ;
		this.id = id ;
	}
	
	
	public void isThirsty(){
		this.setHealthPoint(this.getHealthPoint()-20);
	}
	
	public String toString(){
		return "\n"+"Age:"+age+"jours"+"\n"+"ID:"+id+"\n"+super.toString(); //affiche le nom, l'age, les points de vie et l'etat
		
	}

}
