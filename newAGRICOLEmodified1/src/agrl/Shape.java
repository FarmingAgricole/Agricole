package agrl;

public class Shape extends HealthPoint {
	
	protected String shape = "unknown";
	
	public Shape(){
		
	}

	public Shape(int healthpoint, int maxhealth){
		
		super(healthpoint,maxhealth);
		this.setShape();
	}
	
	private void setShape(){
		if (maxhealth==0){
			shape="error";
		}
		else{
			if (((currenthealth*100/maxhealth)<=100)&&(((currenthealth*100/maxhealth)>=75))){
				shape="good";
			}
			else if (((currenthealth*100/maxhealth)<75)&&(((currenthealth*100/maxhealth)>=50))){
				shape="passable";
			}
			else if (((currenthealth*100/maxhealth)<50)&&(((currenthealth*100/maxhealth)>=25))){
				shape="bad";
			}
			else if (((currenthealth*100/maxhealth)<25)&&(((currenthealth*100/maxhealth)>0))){
				shape="reallybad";
			}
			else{
				shape="error";
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
		return shape;
	}
	
	public void setShapeGood(){
		this.shape = "good";
	}
	
	public void setShapePassable(){
		this.shape = "passable";
	}
	
	public void setShapeBad(){
		this.shape = "bad";
	}
	
	public void setShapeReallybad(){
		this.shape = "reallybad";
	}
	
	public String toString(){
		return super.toString()+"\nshape:"+this.getShape();
	}

}