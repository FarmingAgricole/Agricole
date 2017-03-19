package agrl;

import java.util.ArrayList;

public class StrawberrysPlanted { //toutes les fraises plantées
	
	ArrayList<Strawberry> strawberrys = new ArrayList<Strawberry>();
	protected int numberofstrawberry=0;
	
	public StrawberrysPlanted(){
		
	}
	
	public void addStrawberry(Strawberry strawberry){
		strawberrys.add(strawberry);
		numberofstrawberry++;
	}
	
	public void supStrawberry(int number){
		Strawberry strawberrysup = strawberrys.get(number); // Fraise qui va etre supprim�e
		strawberrys.remove(strawberrysup);
		numberofstrawberry--;
	}
	
	public int size(){
		return strawberrys.size();
	}
	
	public Strawberry get(int number){
		return strawberrys.get(number);
	}

}
