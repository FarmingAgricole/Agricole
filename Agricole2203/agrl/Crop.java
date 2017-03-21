package agrl;

public abstract class Crop extends Shape{
	
	protected boolean water = false;
	protected int maturity;
	protected int lapsingmax;
	protected int age;
	
	
	public Crop(){
		super();
	}
	
	public Crop(int healthpoint, int maxhealth, int age){ /////add age
		super(healthpoint, maxhealth);
		this.age = age;
		
	}
	
	//public Crop(int healthpoint, int maxhealth, int lapsingmax){
		//super(healthpoint, maxhealth);
		//this.lapsingmax=lapsingmax;
	//}
	
	public abstract void isThirsty(); //abstrait car le comportement sera différent selon le type de culture
	
	public void water(){
		this.water=true;
	}
	
	public void dry(){
		this.water=false;
	}
	
	public boolean getWater(){
		return this.water;
	}
	
	public void getOlder() {
		this.age++;
	}

	

}
