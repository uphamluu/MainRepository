package com.phamluu.design_ptt.behavioral.commandptt;

import com.phamluu.design_ptt.behavioral.commandptt.command.BlackWhitePrintCommand;
import com.phamluu.design_ptt.behavioral.commandptt.command.FarbPrintCommand;
import com.phamluu.design_ptt.behavioral.commandptt.invoker.Sekretaerin;
import com.phamluu.design_ptt.behavioral.commandptt.reciever.BlackWhitePrinter;
import com.phamluu.design_ptt.behavioral.commandptt.reciever.ColorPrinter;
//import com.phamluu.design_ptt.behavioral.commandptt.reciever.NadelPrinter;
//import com.phamluu.design_ptt.behavioral.commandptt.reciever.PDFPrinter;


public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
         * Initiale Konfiguration:
         */
        //Drucker erstellen
        BlackWhitePrinter schwarzWeissDrucker = new BlackWhitePrinter();
        ColorPrinter farbDrucker = new ColorPrinter();
//        NadelPrinter nadelDrucker = new NadelPrinter();
//        PDFPrinter pdfDrucker = new PDFPrinter();

        Sekretaerin sekretaerin = new Sekretaerin();
        sekretaerin.setDruckBefehl(new BlackWhitePrintCommand(schwarzWeissDrucker));

        /*
         * Nutzung
         */
        sekretaerin.druckAusloesen("Das Command Pattern ist super!");//Das Command Pattern ist super!

        //ggf. dynamische Umkonfiguration zur Laufzeit
        sekretaerin.setDruckBefehl(new FarbPrintCommand(farbDrucker));
        sekretaerin.druckAusloesen("Das Command Pattern ist super!");//DAS COMMAND PATTERN IST SUPER!

	}

}
