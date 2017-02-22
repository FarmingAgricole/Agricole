package agrl;

public class Shape extends HealthPoint {
	
	protected String animalshape = getShapeActualised();
	
	public Shape(){
		
	}

	public Shape(int healthpoint, int maxhealth){
		
		super(healthpoint,maxhealth);
	}
	
	public String getShapeActualised(){
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
	
	public void setHealtPoint(int currenthealth){ //change les points de vie
		super.setHealthPoint(currenthealth);
	}
	
	public int getHealthPoint(){ //retourne les points de vie
		return super.getHealthPoint();
	}
	
	public String getShape(){
		return animalshape;
	}
	
	public void setShapeGood(){
		this.animalshape = "good";
	}
	
	public void setShapePassable(){
		this.animalshape = "passable";
	}
	
	public void setShapeBad(){
		this.animalshape = "bad";
	}
	
	public void setShapeReallybad(){
		this.animalshape = "reallybad";
	}
	
	public String toString(){
		return super.toString()+"\nshape:"+getShapeActualised();
	}

}