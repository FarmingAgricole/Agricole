
package agrl;

public class Test extends Pig implements Animal{
	
	public static void main (String[] args){
		Pig pig1 = new Pig("cochon",50,0,1); //un cochon nommé cochon avec 50hp
		
		System.out.println(pig1.toString());
	}
	
	//note: reflechir a la classe interface Animale

}