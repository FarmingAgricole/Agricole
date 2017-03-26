package agrl;

import java.util.ArrayList;

public class MeatWarehouse {
	
	public MeatWarehouse(){
		
	}
	
	ArrayList<Meat> meats = new ArrayList<Meat>();
	protected int numberofmeats=0;
	

	
	public void addMeat(Meat meat){
		meats.add(meat);
		numberofmeats++;
	}
	
	public void supMeat(int number){
		Meat meatsup = meats.get(number); // fraise qui va etre supprim�e
		meats.remove(meatsup);
		numberofmeats--;
	}
	
	public int size(){
		return meats.size();
	}
	
	public Meat get(int number){
		return meats.get(number);
	}

}
