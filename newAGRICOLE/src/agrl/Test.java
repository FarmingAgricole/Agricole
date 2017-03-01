
package agrl;

public class Test{
	
	public static void main (String[] args){
		
		Cow vache0 = new Cow("vachette",100,0,99);
		Cow vache1 = new Cow("vachette1",100,0,100);
		Cow vache2 = new Cow("vachette2",100,0,101);
		Cow vache3 = new Cow("vachette3",100,0,102);
		EnclosureCow enclosvaches = new EnclosureCow();
		Wallet wallet = new Wallet(1000);
		Shop shop = new Shop();
		
		enclosvaches.addCow(vache0);
		enclosvaches.addCow(vache1);
		enclosvaches.addCow(vache2);
		enclosvaches.addCow(vache3);
		System.out.println("La vache 0 dans le pré : \n"+enclosvaches.affiche(0));
		System.out.println("La vache 1 dans le pré : \n"+enclosvaches.affiche(1));
		System.out.println("La vache 2 dans le pré : \n"+enclosvaches.affiche(2));
		System.out.println("La vache 3 dans le pré : \n"+enclosvaches.affiche(3));
		System.out.println(enclosvaches.getNumberOfCows());
		enclosvaches.supCow(2);
		
		System.out.println("SUPPRESSION");
		System.out.println("La vache 0 dans le pré : \n"+enclosvaches.affiche(0));
		System.out.println("La vache 1 dans le pré : \n"+enclosvaches.affiche(1));
		System.out.println("La vache 2 dans le pré : \n"+enclosvaches.affiche(2));
		
		System.out.println("wallet= "+wallet.getGold());
		wallet.addGold(2000);
		System.out.println("wallet= "+wallet.getGold());
		System.out.println("nombre de vache: "+enclosvaches.getNumberOfCows());
		shop.sellCow(wallet,enclosvaches);
		System.out.println("wallet= "+wallet.getGold());
		System.out.println("nombre de vache: "+enclosvaches.getNumberOfCows());
		enclosvaches.afficheStarvation();
		enclosvaches.feedEveryCows();
		enclosvaches.afficheStarvation();
	}

}