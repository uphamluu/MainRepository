package com.phamluu.automatic_compile;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class AutomaticBuild
{

  public static void main(String[] args)
  {
    ConfigFactory.loadConfigurationfromProperties();
    CompilationConfig cf = ConfigFactory.getConfig(args);
    compile(cf);
  }

  private static void compile(CompilationConfig cf)
  {

    Robot robot;
    try
    {
      robot = new Robot();

      // click on eclipse to get focus
      mouseClick(robot, 1000, 500, 100);

      // Stop tomcat if running
      mouseClick(robot, cf.getStopTomcatXPos(), cf.getStopTomcatYPos(), 1000);
      //      mouseClick(robot, TOMCAT__XPOS, tomcatYPos, 500);
      //      int[] keys = { KeyEvent.VK_CONTROL, KeyEvent.VK_ALT, KeyEvent.VK_S };
      //      keyPress(robot, keys, 100);

      // compile project doi de compile xong
      mouseClick(robot, 115, 52, 1000);
      mouseClick(robot, 115, cf.getAntYPos(), 10000);

      // chon tomcat instant
      mouseClick(robot, 80, 52, 500);
      mouseClick(robot, 80, cf.getTomcatYPos(), 1000);



      robot.mouseMove(1000, 500);
    }
    catch (AWTException e)
    {
      e.printStackTrace();
    }

  }


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

  // mo phong tac vu bam nut
  @SuppressWarnings("unused")
  private static void keyPress(final Robot robot, final int[] keys, final Integer pause)
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

}
