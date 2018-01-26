package com.phamluu.nn;

import java.io.Serializable;

public class InputNeuron extends Neuron implements Serializable{
    public InputNeuron() {
        super();
    }
    
    public InputNeuron(int i) {
        super(i);
    }

    public void input(float d) {
        output = d;
    }

}