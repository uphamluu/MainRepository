package com.phamluu.design_ptt.behavioral.observerptt;

//import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class MyModel {


  private List<Person> persons = new ArrayList<Person>();
  private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();


  public MyModel() {
    // Just for testing we hard-code the persons here:
    persons.add(new Person("Lars", "Vogel"));
    persons.add(new Person("Jim", "Knopf"));
  }

//  private void notifyListeners(Object object, String property, String oldValue, String newValue) {
//    for (PropertyChangeListener name : listener) {
//      name.propertyChange(new PropertyChangeEvent(this, "firstName", oldValue, newValue));
//    }
//  }

  public void addChangeListener(PropertyChangeListener newListener) {
    listener.add(newListener);
  }

  public List<Person> getPersons() {
	    return persons;
	  }

}