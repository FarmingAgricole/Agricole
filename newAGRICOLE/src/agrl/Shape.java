package agrl;

public class Shape extends HealthPoint {
	
	protected String animalshape = "unknown";
	
	public Shape(){
		
	}

	public Shape(int healthpoint, int maxhealth){
		
		super(healthpoint,maxhealth);
		this.setShape();
	}
	
	private void setShape(){
		if (maxhealth==0){
			animalshape="error";
		}
		else{
			if (((currenthealth*100/maxhealth)<=100)&&(((currenthealth*100/maxhealth)>=75))){
				animalshape="good";
			}
			else if (((currenthealth*100/maxhealth)<75)&&(((currenthealth*100/maxhealth)>=50))){
				animalshape="passable";
			}
			else if (((currenthealth*100/maxhealth)<50)&&(((currenthealth*100/maxhealth)>=25))){
				animalshape="bad";
			}
			else if (((currenthealth*100/maxhealth)<25)&&(((currenthealth*100/maxhealth)>0))){
				animalshape="reallybad";
			}
			else{
				animalshape="error";
			}
		}
	}
	
	public void setHealthPoint(int currenthealth){ //change les points de vie
		super.setHealthPoint(currenthealth);
		this.setShape();
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
		return super.toString()+"\nshape:"+this.getShape();
	}

}