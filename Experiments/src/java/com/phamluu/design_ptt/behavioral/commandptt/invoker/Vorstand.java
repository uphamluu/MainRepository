package com.phamluu.design_ptt.behavioral.commandptt.invoker;

import com.phamluu.design_ptt.behavioral.commandptt.command.IPrintCommand;

public class Vorstand{
    private IPrintCommand druckBefehl;

    //Aufrufer wird mit dem konkreten DruckBefehl über einen Setter geladen
    //Alternative: Konstruktor
    public void setDruckBefehl(IPrintCommand pDruckBefehl) {
        druckBefehl = pDruckBefehl;
    }

    public void druckAusloesen(String pDokument){
        druckBefehl.ausfuehren(pDokument);
    }
}
