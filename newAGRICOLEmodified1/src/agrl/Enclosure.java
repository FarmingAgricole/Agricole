package agrl;

import java.util.ArrayList;

public class Enclosure { //inutile pour l'instant
	ArrayList<Animal> animals = new ArrayList<Animal>();
	protected static int numberofanimal;
	
	public Enclosure(){
		this.numberofanimal=0;
	}
	
	public ArrayList<Animal> getAnimalList(){
		return animals;
	}
	
	public void addAnimal(Animal animal){
		animals.add(animal);
		numberofanimal++;
	}
	
	public void supAnimal(int number){
		Animal animalsup = animals.get(number); // vache qui va etre supprimée
		animals.remove(animalsup);
		/*for (int i=number; i<3; i++){
			enclosurecow[i]=enclosurecow[i+1];
			System.out.println("test");
		}*/
		//cows.remove(cows.get(3));
		numberofanimal--;
	}

	
	public String affiche(int number){
		return animals.get(number).toString();
		
	}
	
	public int getNumberOfCows(){
		return animals.size();
	}
	
	public int size(){
		return animals.size();
	}
	
	public void feedEveryAnimals(){
		for(int i=0;i<animals.size();i++){
			(animals.get(i)).feed();
		}
	}
	
	public void afficheStarvation(){
		for(int i=0;i<animals.size();i++){
			System.out.println((animals.get(i)).getFed());
		}
	}
	
	public Animal get(int number){
		return animals.get(number);
	}
	
}
