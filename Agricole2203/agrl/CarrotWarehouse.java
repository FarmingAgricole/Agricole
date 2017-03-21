package agrl;

import java.util.ArrayList;

public class CarrotWarehouse {
	
	ArrayList<CarrotHarvested> carrots = new ArrayList<CarrotHarvested>();
	protected int numberofcarrots=0;
	
	public CarrotWarehouse(){
		
	}
	
	public void addCarrot(CarrotHarvested carrot){
		carrots.add(carrot);
		numberofcarrots++;
	}
	
	public void supCarrot(int number){
		CarrotHarvested carrotsup = carrots.get(number); // carrotte qui va etre supprim�e
		carrots.remove(carrotsup);
		numberofcarrots--;
	}
	
	public int size(){
		return carrots.size();
	}
	
	public CarrotHarvested get(int number){
		return carrots.get(number);
	}

}
