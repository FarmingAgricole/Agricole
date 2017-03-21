package agrl;

public class Turn {
	
	int maxTurn;
	int Turn;
	
	public Turn(){
		
	}
	
	public void nextTurn(EnclosureCow enclos, Milk milk){
		this.Turn++;
		//turnOfCows(enclos, milk);
	}
	
	//Tour des vaches
	
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
	
	//Tour des poules
	
	public void turnOfChickens(EnclosureChicken enclos, Egg egg){
		for(int i=0;i<enclos.size();i++){
			if ((enclos.get(i)).getFed()){
				egg.addEgg(1);
				(enclos.get(i)).starve();
			}
			else{
				(enclos.get(i)).isStarving();
				if ((enclos.get(i)).getHealthPoint()<=0){
					enclos.supChicken(i);
				}
				
			}
		}
	}
	
	//Tour des moutons
	
	public void turnOfSheeps(EnclosureSheep enclos, Wool wool){
		for(int i=0;i<enclos.size();i++){
			if ((enclos.get(i)).getFed()){
				wool.addWool(1);
				(enclos.get(i)).starve();
			}
			else{
				(enclos.get(i)).isStarving();
				if ((enclos.get(i)).getHealthPoint()<=0){
					enclos.supSheep(i);
				}
				
			}
		}
	}
	
	//Tour des cochons
	
	public void turnOfPigs(EnclosurePig enclos){
		for(int i=0;i<enclos.size();i++){
			if ((enclos.get(i)).getFed()){ // si les cochons ont été nourris
				(enclos.get(i)).starve(); // a présent ils ont de l'apétits
			}
			else{
				(enclos.get(i)).isStarving(); // si les cochons ont faim, il perdent de la vie
				if ((enclos.get(i)).getHealthPoint()<=0){ // si ils ont <= 0HP ils meurent
					enclos.supPig(i);
				}
				
			}
		}
	}
	
	
	public void turnCrops(Field field) {
	for (int i = 0; i<=6; i++) {
		if (field.accesValue(i) != null) {
		field.accesValue(i).getOlder();
		if(field.accesValue(i).getWater()) {
			field.accesValue(i).dry();
		} else {
			field.accesValue(i).isThirsty();
			if(field.accesValue(i).getHealthPoint()<=0) {
				field.removeCrop(i);
			}
		}
	}
	}
	}
	
	public int getTurn() {
		return this.Turn;
	}
	
	public void goTurn(){
		this.Turn++;
	}
	

}
