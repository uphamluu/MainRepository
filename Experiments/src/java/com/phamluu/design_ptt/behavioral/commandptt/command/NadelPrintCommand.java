package com.phamluu.design_ptt.behavioral.commandptt.command;

import com.phamluu.design_ptt.behavioral.commandptt.reciever.NadelPrinter;

public class NadelPrintCommand implements IPrintCommand{

    private NadelPrinter drucker;

    //Der Befehl wird seinem Zieldrucker bei Instanziierung bekannt gemacht
    public NadelPrintCommand(NadelPrinter pDrucker) {
        drucker = pDrucker;
    }

    public void ausfuehren(String pDokument) {
        drucker.umstaendlichKonfigurieren();
        drucker.drucken(pDokument);
    }
}