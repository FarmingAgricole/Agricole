package ProjetGenie;

public class Lapsing {
protected int expireDate;
protected int datePasse;

public Lapsing(int expireDate) {
	this.expireDate = expireDate;
}

public void lapsingStatus() {
	if (datePasse >= expireDate) {
		System.out.println("NULL");
	}
}
}
