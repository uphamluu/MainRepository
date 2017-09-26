package com.phamluu;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.ArrayList;

import javax.swing.KeyStroke;

public class MaritSimpleTest
{

  public static void main(String[] args) throws Exception
  {


    runTests();
  }

  private static void runTests()
  {

    Robot robot;
    try
    {
      robot = new Robot();

      // click on eclipse to get focus
      mouseClick(robot, 1000, 500, 100);
      mouseClick(robot, 550, 325, null);
      StringPress(robot, "imagin1");


    }
    catch (AWTException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();

    }


  }

  //

  // mo phong tac vu click chuot
  public static void mouseClick(final Robot robot, final int xPos, final int yPos, final Integer pause)
  {

    // LEFT CLICK
    // click on eclipse to get focus

    robot.mouseMove(xPos, yPos);
    robot.mousePress(InputEvent.BUTTON1_MASK);
    robot.mouseRelease(InputEvent.BUTTON1_MASK);

    if (pause != null)
    {
      try
      {

        Thread.sleep(pause);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

  }
  private static void StringPress(final Robot robot, String input){
    char[] allchars= input.toUpperCase().toCharArray();
    for(char ch:allchars){
      ArrayList<Integer> keys = new  ArrayList<>();
      keys.add(KeyStroke.getKeyStroke(ch, 0).getKeyCode());
      pressKeys(robot,keys  , 1);
    }
  }

  // mo phong tac vu bam nut
  @SuppressWarnings("unused")
  private static void pressKeys(final Robot robot, final ArrayList<Integer>  keys, final Integer pause)
  {

    // LEFT CLICK
    for (int ke : keys)
    {
      robot.keyPress(ke);
    }
    for (int ke : keys)
    {
      robot.keyRelease(ke);
    }
    if (pause != null)
    {
      try
      {

        Thread.sleep(pause);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

  }
  private static void pressKeys(final Robot robot, Integer  key, final Integer pause)
  {
    // LEFT CLICK
      robot.keyPress(key);
      robot.keyRelease(key);
    if (pause != null)
    {
      try
      {

        Thread.sleep(pause);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

  }


}
