package com.phamluu.nn;

public class InputNeuron extends Neuron {
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