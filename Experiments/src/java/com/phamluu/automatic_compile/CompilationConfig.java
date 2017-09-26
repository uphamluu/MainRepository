package com.phamluu.automatic_compile;

public class CompilationConfig
{
  public static final String TOMCAT_Y_POS_SUFFIX="tomcat.start.y";
  public static final String ANT_Y_POS_SUFFIX="ant.y";


  public static final String STOP_TOMCAT_Y_POS="all.tomcat.stop.y";
  public static final String STOP_TOMCAT_X_POS="all.tomcat.stop.x";


  private int stopTomcatYPos;
  private int stopTomcatXPos;


  private int tomcatYPos;
  private int  antYPos;



  public int getTomcatYPos()
  {
    return tomcatYPos;
  }
  public void setTomcatYPos(int tomcatYPos)
  {
    this.tomcatYPos = tomcatYPos;
  }

  public int getAntYPos()
  {
    return antYPos;
  }

  public void setAntYPos(int antYPos)
  {
    this.antYPos = antYPos;
  }

  public int getStopTomcatYPos()
  {
    return stopTomcatYPos;
  }
  public void setStopTomcatYPos(int stopTomcatYPos)
  {
    this.stopTomcatYPos = stopTomcatYPos;
  }
  public int getStopTomcatXPos()
  {
    return stopTomcatXPos;
  }
  public void setStopTomcatXPos(int stopTomcatXPos)
  {
    this.stopTomcatXPos = stopTomcatXPos;
  }


}
