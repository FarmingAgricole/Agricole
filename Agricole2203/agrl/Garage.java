package agrl;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class Garage {
	private int max_place = 6;
	private Position [] po = new Position[max_place];
	
	// 6 positions for all the vehicles (Looking for other methode to better manager)
	Position p1 = new Position(1,1);
	Position p2 = new Position(1,2);
	Position p3 = new Position(1,3);
	Position p4 = new Position(2,1);
	Position p5 = new Position(2,2);
	Position p6 = new Position(2,3);
	
	Position choice;
	private boolean res;
	private HashMap<Position, Vehicle> vehicles = new HashMap<Position, Vehicle>();

	public Garage() {
	}

	public Position chosePosition(int number) { //Define position for each vehicle in garage
		switch(number) {
		case 1: choice = p1;
		break;
		case 2: choice = p2;
		break;
		case 3: choice = p3;
		break;
		case 4: choice = p4;
		break;
		case 5: choice = p5;
		break;
		case 6: choice = p6;
		break;
		default:
			System.out.println("Error");
		}
		return choice;
		
	}
	
	public void addTractorX1(int number) {
		Vehicle v = accesValue(number);
			if (v == null) {
				vehicles.put(choice, new TractorX1());
				System.out.println("ADDED");
				res = true;
			} else {
				System.out.println("CANNOT ADDED");
				res = false;		
			}
	}
	
	public void addTractorX2(int number) {
		Vehicle v = accesValue(number);
		if (v == null) {
			vehicles.put(choice, new TractorX2());
			System.out.println("ADDED");
			res = true;
		} else {
			System.out.println("CANNOT ADDED");
			res = false;		
		}
}
	
	public void removeVehicle(int number) {
		chosePosition(number);
				vehicles.remove(choice);
			}
	
	public boolean added() {
		return res;
	}
	
	public boolean addMore() {
		if (getNumberVehicle() < getMaxPlace()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int whichVehicle(int number) {
		int res = 0;
		Vehicle v = accesValue(number);
		if(v == null) {
			res = 0;
		} else if (v instanceof TractorX1) {
			res = 1;
		} else if (v instanceof TractorX2) {
			res = 2;
		}
		return res;
	}
	
	public String updateStatus(int number) {
		return accesValue(number).toString();
	}
	
	public Vehicle accesValue(int number) {
		chosePosition(number);
		Vehicle v = (Vehicle)vehicles.get(choice);
		return v;
	}
	
	public int getNumberVehicle() {
		return vehicles.size();
	}
	
	public int getMaxPlace() {
		return max_place;
	}
	

	/*public String toString() {
	Iterator iterator = vehicles.keySet().iterator();
	while (iterator.hasNext()) {
		   Position key = (Position) iterator.next();
		   Vehicle value = vehicles.get(key);
		   System.out.println("Position:" + key.toString() + " - Report: " + value.toString());
	}
	return null;
}*/


	/*public static void main(String[] args) throws IOException {
System.out.println("A" + "\nB");
}*/
}
