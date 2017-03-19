package agrl;

import java.util.ArrayList;

public class EnclosurePig {
	ArrayList<Pig> pigs = new ArrayList<Pig>();
	protected static int numberofpig;
	
	public EnclosurePig(){
		this.numberofpig=0;
	}
	
	public void addPig(Pig pig){
		pigs.add(pig);
		numberofpig++;
	}
	
	public void supPig(int number){
		Pig pigsup = pigs.get(number); // Cochon qui va etre supprimée
		pigs.remove(pigsup);
		numberofpig--;
	}

	
	public String affiche(int number){
		return pigs.get(number).toString();
		
	}
	
	public int getNumberOfPigs(){
		return pigs.size();
	}
	
	public int size(){
		return pigs.size();
	}
	
	public void feedEveryPigs(){
		for(int i=0;i<pigs.size();i++){
			(pigs.get(i)).feed();
		}
	}
	
	public void afficheStarvation(){
		for(int i=0;i<pigs.size();i++){
			System.out.println((pigs.get(i)).getFed());
		}
	}
	
	public Pig get(int number){
		return pigs.get(number);
	}

}
