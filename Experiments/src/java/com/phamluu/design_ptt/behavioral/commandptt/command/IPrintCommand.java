package com.phamluu.design_ptt.behavioral.commandptt.command;

public interface IPrintCommand{
    //Jeder Befehl kapselt die Logik zur Ausführung,
    //sowie den Zieldrucker
    public void ausfuehren(String pDokument);
}