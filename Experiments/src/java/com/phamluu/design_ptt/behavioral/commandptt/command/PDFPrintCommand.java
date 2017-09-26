package com.phamluu.design_ptt.behavioral.commandptt.command;

import com.phamluu.design_ptt.behavioral.commandptt.reciever.PDFPrinter;

public class PDFPrintCommand implements IPrintCommand{
    private PDFPrinter drucker;

    //Der Befehl wird seinem Zieldrucker bei Instanziierung bekannt gemacht
    public PDFPrintCommand(PDFPrinter pDrucker) {
        drucker = pDrucker;
    }

    public void ausfuehren(String pDokument) {
        drucker.speichern(pDokument);
    }
}