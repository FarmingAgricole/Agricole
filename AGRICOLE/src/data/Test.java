package data;

public class Test extends Pig {
	
	public static void main (String[] args){
		Pig pig1 = new Pig("cochon",50); //un cochon nommé cochon avec 50hp
		
		System.out.println(pig1.tostring());
	}
	
	//note: reflechir a la classe interface Animale

}
