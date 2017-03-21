package agrl;

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
	this.harvest++;
	if (this.harvest != 0 && this.harvest % 10 == 0) {
		super.setLevel(super.getLevel() - 1);
		super.gaintPoint();
	}
}


public String toString() {
	return "Name: " +  name + "\nCurrent level: " + level + "\nHarvest: " + harvest
			+ "\nProductivity: " + super.currentHarvestGaint 
			+ "\nRepair left: " + repairleft;
}

public void setHarvest(int gaint) { //Testing functionality of harvestStatus()
	this.harvest=gaint;
}
}
