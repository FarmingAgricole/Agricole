package ProjetGenie;

public class MeatsWarehouse extends Lapsing{
protected int maxCapacity;
protected int currentPro;

public MeatsWarehouse(int expireDate, int maxCapacity, int currentPro) {
	super(expireDate);
	this.maxCapacity = maxCapacity;
	this.currentPro = currentPro;
}


}
