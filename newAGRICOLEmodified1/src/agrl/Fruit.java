package agrl;

public abstract class Fruit extends Crop{
	
	public Fruit(){
		super();
	}
	
	public Fruit(int healthpoint, int maxhealth){
		super(healthpoint, maxhealth);
	}
	
	public Fruit(int healthpoint, int maxhealth, int lapsingmax){
		super(healthpoint, maxhealth, lapsingmax);
	}

}
