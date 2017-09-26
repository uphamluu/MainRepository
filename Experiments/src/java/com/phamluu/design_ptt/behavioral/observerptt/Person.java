package com.phamluu.design_ptt.behavioral.observerptt;


public class Person {

	public static final String FIRSTNAME = "firstName";
	public static final String LASTNAME = "lastName";

	private String firstName;

	private String lastName;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {

		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
//		notifyListeners(this, FIRSTNAME, this.firstName,
//				);

	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
//		notifyListeners(this, LASTNAME, this.lastName, );
	}
}
