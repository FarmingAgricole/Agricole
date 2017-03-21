package agrl;

public class VehicleShape { 
protected int level;
protected double harvestGaintMax;
protected double currentHarvestGaint;
public VehicleShape(double harvestGaintMax) {
this.harvestGaintMax =  harvestGaintMax;
this.currentHarvestGaint =  harvestGaintMax;
	level = 3;
}
 

public void gaintPoint() {
	switch(level) {
	case 5:
	this.currentHarvestGaint = harvestGaintMax;
	System.out.println("100% harvest");
		break;
	case 4:
		this.currentHarvestGaint = harvestGaintMax * 0.85;
		System.out.println("85% harvest");
		break;
	case 3:
		this.currentHarvestGaint = harvestGaintMax * 0.7;
		System.out.println("70% harvest");
		break;
	case 2:
		this.currentHarvestGaint = harvestGaintMax * 0.5;
		System.out.println("50% harvest");
		break;
	case 1:
		this.currentHarvestGaint = 0;
		System.out.println("Broken");
		break;
	default:
		System.out.println("Level undefined");
		break;
	}
}

public int getLevel() {
	return level;
}

public void setLevel(int lv) {
	this.level = lv;
}
}
