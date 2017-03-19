package agrl;

import java.util.ArrayList;

public class EnclosureChicken {
	
	ArrayList<Chicken> chickens = new ArrayList<Chicken>();
	protected static int numberofchicken;
	
	public EnclosureChicken(){
		this.numberofchicken=0;
	}
	
	public void addChicken(Chicken chicken){
		chickens.add(chicken);
		numberofchicken++;
	}
	
	public void supChicken(int number){
		Chicken chickensup = chickens.get(number); // vache qui va etre supprimée
		chickens.remove(chickensup);
		/*for (int i=number; i<3; i++){
			enclosurecow[i]=enclosurecow[i+1];
			System.out.println("test");
		}*/
		//cows.remove(cows.get(3));
		numberofchicken--;
	}

	
	public String affiche(int number){
		return chickens.get(number).toString();
		
	}
	
	public int getNumberOfChickens(){
		return chickens.size();
	}
	
	public int size(){
		return chickens.size();
	}
	
	public void feedEveryChickens(){
		for(int i=0;i<chickens.size();i++){
			(chickens.get(i)).feed();
		}
	}
	
	public void afficheStarvation(){
		for(int i=0;i<chickens.size();i++){
			System.out.println((chickens.get(i)).getFed());
		}
	}
	
	public Chicken get(int number){
		return chickens.get(number);
	}

}
