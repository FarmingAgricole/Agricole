package data;

public class Sheep extends Shape{
	
	protected int healthpoint;
	protected static int maxhealth = 100 ;
	protected String name ;
	
	public Sheep(){
		super();
	}
	
	public Sheep(String name, int healthpoint){ /* Cr�er un cochon dont on selectionne les points de vie et dont les points de vie max sont pr�d�finis */
		super(healthpoint,maxhealth);
		this.name = name ;
	}
	
	public String tostring(){
		return "Nom:"+this.name+"\n"+super.tostring();
		
	}


}
