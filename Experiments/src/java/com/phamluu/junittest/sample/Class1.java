package com.phamluu.junittest.sample;
/**
 * @author phamluu
 *
 */
public class Class1 {


	private int someNr;
	public Class1(){
		setSomeNr(-1);
	}
	/**
	 * If a class has <b> no modifier </b>(the default, also known as<b>  package-private </b>),
	 * it is visible only within its own package
	 */
	void increase(){
		setSomeNr(someNr+2);
	}

	public int getSomeNr() {
		return someNr;
	}
	void setSomeNr(int someNr) {
		this.someNr = someNr;
	}


}
