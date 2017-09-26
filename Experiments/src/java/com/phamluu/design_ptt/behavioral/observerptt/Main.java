package com.phamluu.design_ptt.behavioral.observerptt;


public class Main {


  public static void main(String[] args) {
    MyModel model = new MyModel();
//    MyObserver observer = new MyObserver(model);
    // We change the last name of the person, observer will get notified
    for (Person person : model.getPersons()) {
        person.setLastName(person.getLastName() + "1");
    }
    // We change the  name of the person, observer will get notified
    for (Person person : model.getPersons()) {
        person.setFirstName(person.getFirstName() + "1");
    }
  }
}