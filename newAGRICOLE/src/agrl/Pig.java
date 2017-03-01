package agrl;

public class Pig extends Animal{
	
	protected int healthpoint;
	protected static int maxhealth = 100 ;
	protected String name ;
	protected int age;
	protected int id;
	
	public Pig(){
		super();
	}
	
	public Pig(String name, int healthpoint){ /* Créer un cochon dont on selectionne les points de vie et dont les points de vie max sont prédéfinis */
		super(healthpoint,maxhealth);
		this.name = name ;
	}
	
	public Pig(String name, int healthpoint, int age){ /* Créer un cochon dont on selectionne les points de vie, l'age et dont les points de vie max sont prédéfinis */
		super(healthpoint,maxhealth);
		this.name = name ;
		this.age = age ;
	}
	
	public Pig(String name, int healthpoint, int age, int id){ /* Créer un cochon dont on selectionne les points de vie, l'age, l'id et dont les points de vie max sont prédéfinis */
		super(healthpoint,maxhealth);
		this.name = name ;
		this.age = age ;
		this.id = id ;
	}
	
	public String getShape(){
		return super.getShape();
	}
	
	public void setHealthPoint(int currenthealth){ //change les points de vie
		super.setHealthPoint(currenthealth);
	}
	
	public int getHealthPoint(){ //retourne les points de vie
		return super.getHealthPoint();
	}
	
	public String toString(){
		return "Nom:"+this.name+"\n"+"Age:"+age+"jours"+"\n"+"ID:"+id+"\n"+super.toString(); //affiche le nom, l'age, les points de vie et l'etat
		
	}

}