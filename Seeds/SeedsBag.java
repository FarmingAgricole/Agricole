package agrl;

public class SeedsBag {
	
	//number of seed we have
	
	protected int numberofcarrotseed=0;
	protected int numberofstrawberryseed=0;
	
	//starting with an empty bag
	public SeedsBag(){
		
	}
	
	//starting with a specified bag
	public SeedsBag(int numberofcarrotseed, int numberofstrawberryseed){
		this.numberofcarrotseed = numberofcarrotseed;
		this.numberofstrawberryseed = numberofstrawberryseed;
		
	}
	
	//Carrot
	public int getNumberOfCarotSeed(){
		return this.numberofcarrotseed;
	}
	
	public void addCarotSeed(int amount){
		this.numberofcarrotseed = this.numberofcarrotseed + amount;
	}
	
	public void removeCarotSeed(int amount){
		this.numberofcarrotseed = this.numberofcarrotseed - amount;
	}
	
	//Strawberry
	public int getNumberOfStrawberrySeed(){
		return this.numberofstrawberryseed;
	}
	
	public void addStrawberrySeed(int amount){
		this.numberofstrawberryseed = this.numberofstrawberryseed + amount;
	}
	
	public void removeStrawberrySeed(int amount){
		this.numberofstrawberryseed = this.numberofstrawberryseed - amount;
	}

}
