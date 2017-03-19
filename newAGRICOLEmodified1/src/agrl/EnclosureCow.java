package agrl;

import java.util.ArrayList;

public class EnclosureCow{
	ArrayList<Cow> cows = new ArrayList<Cow>();
	protected static int numberofcow;
	
	public EnclosureCow(){
		this.numberofcow=0;
	}
	
	public void addCow(Cow cow){
		cows.add(cow);
		numberofcow++;
	}
	
	public void supCow(int number){
		Cow cowsup = cows.get(number); // vache qui va etre supprimée
		cows.remove(cowsup);
		/*for (int i=number; i<3; i++){
			enclosurecow[i]=enclosurecow[i+1];
			System.out.println("test");
		}*/
		//cows.remove(cows.get(3));
		numberofcow--;
	}

	
	public String affiche(int number){
		return cows.get(number).toString();
		
	}
	
	public int getNumberOfCows(){
		return cows.size();
	}
	
	public int size(){
		return cows.size();
	}
	
	public void feedEveryCows(){
		for(int i=0;i<cows.size();i++){
			(cows.get(i)).feed();
		}
	}
	
	public void afficheStarvation(){
		for(int i=0;i<cows.size();i++){
			System.out.println((cows.get(i)).getFed());
		}
	}
	
	public Cow get(int number){
		return cows.get(number);
	}

}
