package com.phamluu.design_ptt.behavioral.commandptt.command;

public interface IPrintCommand{
    //Jeder Befehl kapselt die Logik zur Ausf�hrung,
    //sowie den Zieldrucker
    public void ausfuehren(String pDokument);
}