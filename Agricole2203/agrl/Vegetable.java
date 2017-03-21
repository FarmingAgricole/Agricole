package agrl;

public abstract class Vegetable extends Crop{
	
	public Vegetable(){
		super();
	}
	
	public Vegetable(int healthpoint, int maxhealth, int age){
		super(healthpoint, maxhealth, age);
	}
	
	//public Vegetable(int healthpoint, int maxhealth, int lapsingmax){
		//super(healthpoint, maxhealth, lapsingmax);
	//}

}
