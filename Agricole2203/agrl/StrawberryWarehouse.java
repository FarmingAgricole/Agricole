package agrl;

import java.util.ArrayList;

public class StrawberryWarehouse {
	
	ArrayList<Strawberry> strawberrys = new ArrayList<Strawberry>();
	protected int numberofstrawberrys=0;
	
	public StrawberryWarehouse(){
		
	}
	
	public void addStrawberry(Strawberry strawberry){
		strawberrys.add(strawberry);
		numberofstrawberrys++;
	}
	
	public void supStrawberry(int number){
		Strawberry strawberrysup = strawberrys.get(number); // fraise qui va etre supprim�e
		strawberrys.remove(strawberrysup);
		numberofstrawberrys--;
	}
	
	public int size(){
		return strawberrys.size();
	}
	
	public Strawberry get(int number){
		return strawberrys.get(number);
	}

}