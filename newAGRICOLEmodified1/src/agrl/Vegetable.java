package agrl;

public abstract class Vegetable extends Crop{
	
	public Vegetable(){
		super();
	}
	
	public Vegetable(int healthpoint, int maxhealth){
		super(healthpoint, maxhealth);
	}
	
	public Vegetable(int healthpoint, int maxhealth, int lapsingmax){
		super(healthpoint, maxhealth, lapsingmax);
	}

}
