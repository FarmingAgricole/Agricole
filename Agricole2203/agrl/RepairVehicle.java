package agrl;

public class RepairVehicle {
	
public RepairVehicle() {

}

public void repair(Vehicle v) {
	v.setLevel(5);
	v.gaintPoint();
	v.repairleft--;
}

public int priceFix(Vehicle v) {
	switch(v.getLevel()) {
	case 5: 
		return 0;
	case 4:
		return 400;
	case 3:
		return 600;
	case 2:
		return 800;
	case 1:
		return 1000;
	default:
		return 0;
	}
}
}
