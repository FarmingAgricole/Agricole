package data;

public class Shape extends HealthPoint {
	
	protected String animalshape = getshapeactualised();
	
	public Shape(){
		
	}

	public Shape(int healthpoint, int maxhealth){
		
		super(healthpoint,maxhealth);
	}
	
	public String getshapeactualised(){
		if (maxhealth==0){
			return "error";
		}
		else{
			if (((currenthealth*100/maxhealth)<=100)&&(((currenthealth*100/maxhealth)>=75))){
				return "good";
			}
			else if (((currenthealth*100/maxhealth)<75)&&(((currenthealth*100/maxhealth)>=50))){
				return "passable";
			}
			else if (((currenthealth*100/maxhealth)<50)&&(((currenthealth*100/maxhealth)>=25))){
				return "bad";
			}
			else if (((currenthealth*100/maxhealth)<25)&&(((currenthealth*100/maxhealth)>0))){
				return "reallybad";
			}
			else{
				return "error";
			}
		}
	}
	
	public String getshape(){
		return animalshape;
	}
	
	public void setshapegood(){
		this.animalshape = "good";
	}
	
	public void setshapepassable(){
		this.animalshape = "passable";
	}
	
	public void setshapebad(){
		this.animalshape = "bad";
	}
	
	public void setshapereallybad(){
		this.animalshape = "reallybad";
	}
	
	public String tostring(){
		return super.tostring()+"\nshape:"+getshapeactualised();
	}

}
