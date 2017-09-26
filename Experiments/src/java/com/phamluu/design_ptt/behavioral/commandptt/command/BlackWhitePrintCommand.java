package com.phamluu.design_ptt.behavioral.commandptt.command;

import com.phamluu.design_ptt.behavioral.commandptt.reciever.BlackWhitePrinter;

public class BlackWhitePrintCommand implements IPrintCommand{
    private BlackWhitePrinter drucker;

    //Der Befehl wird seinem Zieldrucker bei Instanziierung bekannt gemacht
    public BlackWhitePrintCommand(BlackWhitePrinter pDrucker) {
        drucker = pDrucker;
    }

    public void ausfuehren(String pDokument) {
        drucker.konfigurieren();
        drucker.drucken(pDokument);
    }
}
