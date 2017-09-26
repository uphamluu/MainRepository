package com.phamluu.robot_macro;

import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class MarcoAutomaticRunBmwAu {

 public static void main(String[] args) throws Exception {


   Robot robot = new Robot();

   // LEFT CLICK
   // click on eclipse to get focus

   robot.mouseMove(1000, 500);
   robot.mousePress(InputEvent.BUTTON1_MASK);
   robot.mouseRelease(InputEvent.BUTTON1_MASK);
   Thread.sleep(100);
   // select tomcat instant, Stop tomcat if running
   robot.mouseMove(150, 800);
   robot.mousePress(InputEvent.BUTTON1_MASK);
   robot.mouseRelease(InputEvent.BUTTON1_MASK);
   Thread.sleep(500);
   robot.keyPress(KeyEvent.VK_CONTROL);
   robot.keyPress(KeyEvent.VK_ALT);
   robot.keyPress(KeyEvent.VK_S);

   robot.keyRelease(KeyEvent.VK_CONTROL);
   robot.keyRelease(KeyEvent.VK_ALT);
   robot.keyRelease(KeyEvent.VK_S);
   Thread.sleep(100);

   // compile last project
   robot.mouseMove(100, 50);
   robot.mousePress(InputEvent.BUTTON1_MASK);
   robot.mouseRelease(InputEvent.BUTTON1_MASK);
   // doi de compile xong
   Thread.sleep(11000);
   // select tomcat instant
   robot.mouseMove(150, 800);
   robot.mousePress(InputEvent.BUTTON1_MASK);
   robot.mouseRelease(InputEvent.BUTTON1_MASK);
   Thread.sleep(1000);
   robot.keyPress(KeyEvent.VK_CONTROL);
   robot.keyPress(KeyEvent.VK_ALT);
   robot.keyPress(KeyEvent.VK_D);

   robot.keyRelease(KeyEvent.VK_CONTROL);
   robot.keyRelease(KeyEvent.VK_ALT);
   robot.keyRelease(KeyEvent.VK_D);
   Thread.sleep(100);

   // start tomcat
   robot.mouseMove(280, 780);
   robot.mousePress(InputEvent.BUTTON1_MASK);
   robot.mouseRelease(InputEvent.BUTTON1_MASK);
   Thread.sleep(3000);

   robot.keyPress(KeyEvent.VK_CONTROL);
   robot.keyPress(KeyEvent.VK_ALT);
   robot.keyPress(KeyEvent.VK_D);


 }
}