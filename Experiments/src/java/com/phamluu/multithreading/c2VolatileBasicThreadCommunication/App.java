package com.phamluu.multithreading.c2VolatileBasicThreadCommunication;

import java.util.Scanner;

public class App {

  public static void main(String[] args) {
      Processor pro = new Processor();
      pro.start();

      // Wait for the enter key
      new Scanner(System.in).nextLine();

      pro.shutdown();
  }

}
