package com.phamluu.design_ptt.behavioral.commandptt.command;

import com.phamluu.design_ptt.behavioral.commandptt.reciever.ColorPrinter;

public class FarbPrintCommand implements IPrintCommand{
    private ColorPrinter drucker;

    //Der Befehl wird seinem Zieldrucker bei Instanziierung bekannt gemacht
    public FarbPrintCommand(ColorPrinter pDrucker) {
        drucker = pDrucker;
    }

    public void ausfuehren(String pDokument) {
        drucker.drucken(pDokument);
    }
}