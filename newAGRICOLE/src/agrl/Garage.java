package ProjetGenie;

import java.util.HashMap;
import java.util.Iterator;

public class Garage {
	private int max_place;
	private Position [] p = new Position[max_place];
	private HashMap<Position, Vehicle> vehicles = new HashMap<Position, Vehicle>();

	public Garage(int max_place) {
		this.max_place= max_place;
	}


	public void addVehicle(Position po, Vehicle p) {
		if (vehicles.size() < max_place) {
			vehicles.put(po, p);
		}
	}
	
	public String toString() {
		Iterator iterator = vehicles.keySet().iterator();
		while (iterator.hasNext()) {
			   Position key = (Position) iterator.next();
			   Vehicle value = vehicles.get(key);
			   System.out.println("Position:" + key.toString() + " - Report: " + value.toString());
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		Garage garage = new Garage(100);
		Vehicle v1 = new Vehicle("Car", 100);
		Vehicle v2 = new Vehicle("Motor", 120);
		Position p1 = new Position(1,1);
		Position p2 = new Position(1,2);
		garage.addVehicle(p1, v1);
		garage.addVehicle(p2, v2);
		v1.setHarvest(20);
		v1.harvestStatus();
		garage.toString();
		
	}
	}
