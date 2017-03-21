package agrl;

import java.util.ArrayList;

public class EnclosureSheep{
	ArrayList<Sheep> sheeps = new ArrayList<Sheep>();
	protected static int numberofsheep;
	
	public EnclosureSheep(){
		this.numberofsheep=0;
	}
	
	public void addSheep(Sheep sheep){
		sheeps.add(sheep);
		numberofsheep++;
	}
	
	public void supSheep(int number){
		Sheep sheepsup = sheeps.get(number); // Mouton qui va etre supprim�e
		sheeps.remove(sheepsup);
		numberofsheep--;
	}

	
	public String affiche(int number){
		return sheeps.get(number).toString();
		
	}
	
	public int getNumberOfSheeps(){
		return sheeps.size();
	}
	
	public int size(){
		return sheeps.size();
	}
	
	public void feedEverySheeps(){
		for(int i=0;i<sheeps.size();i++){
			(sheeps.get(i)).feed();
		}
	}
	
	public void afficheStarvation(){
		for(int i=0;i<sheeps.size();i++){
			System.out.println((sheeps.get(i)).getFed());
		}
	}
	
	public Sheep get(int number){
		return sheeps.get(number);
	}

}