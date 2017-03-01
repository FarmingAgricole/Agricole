package agrl;

public class Turn {
	
	int maxTurn;
	int Turn;
	
	public Turn(){
		
	}
	
	public void nextTurn(EnclosureCow enclos, Milk milk){
		this.Turn++;
		turnOfCows(enclos, milk);
	}
	
	public void turnOfCows(EnclosureCow enclos, Milk milk){
		for(int i=0;i<enclos.size();i++){
			if ((enclos.get(i)).getFed()){
				milk.addMilk(1);
				(enclos.get(i)).starve();
			}
			else{
				(enclos.get(i)).isStarving();
				if ((enclos.get(i)).getHealthPoint()<=0){
					enclos.supCow(i);
				}
				
			}
		}
	}
	
	public int getTurn(){
		return this.Turn;
	}
	

}
