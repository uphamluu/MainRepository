package com.phamluu.design_ptt.behavioral.observerptt;


import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MyObserver implements PropertyChangeListener {
    public MyObserver(MyModel model) {
        model.addChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent event) {
       System.out.println("Changed property: " + event.getPropertyName() + " [old -> "
                 + event.getOldValue() + "] | [new -> " + event.getNewValue() +"]");
    }
}