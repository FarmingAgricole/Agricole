package ProjetGenie;

public class Vehicle extends VehicleShape {
private String name;
protected int harvest, repairleft;
public Vehicle(String name, double harvestGaintMax) {
	super(harvestGaintMax);
	this.name = name;
	repairleft = 3;
	harvest = 0;
}

public void harvestStatus() {
	if (this.harvest != 0 && this.harvest % 10 == 0) {
		super.setLevel(super.getLevel() - 1);
		super.gaintPoint();
	}
}


public String toString() {
	return "Name: " +  name  + " - current level: " + level + " - Harvest: " + harvest
			+ " - Productivity: " + super.currentHarvestGaint;
}

public void setHarvest(int gaint) { //Testing functionality of harvestStatus()
	this.harvest=gaint;
}
}
