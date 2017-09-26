package com.phamluu.automatic_compile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFactory
{
  private static Properties COMPILATION_CONFIGS = new Properties();
  public static void loadConfigurationfromProperties(){
  InputStream in = ConfigFactory.class.getResourceAsStream("config.properties");
  try
  {
    COMPILATION_CONFIGS.load(in);
  }
  catch (IOException e)
  {
    e.printStackTrace();
  }

  }

  public static CompilationConfig getConfig(String[] arg){
    CompilationConfig cf = new CompilationConfig();
    if (arg != null && arg.length>0 && arg[0]!=null){
      cf.setTomcatYPos(Integer.parseInt((String) COMPILATION_CONFIGS.get(arg[0].toLowerCase()+"."+CompilationConfig.TOMCAT_Y_POS_SUFFIX)));
      cf.setAntYPos(Integer.parseInt((String) COMPILATION_CONFIGS.get(arg[0].toLowerCase()+"."+CompilationConfig.ANT_Y_POS_SUFFIX)));
      cf.setStopTomcatXPos (Integer.parseInt((String) COMPILATION_CONFIGS.get(CompilationConfig.STOP_TOMCAT_X_POS)));
      cf.setStopTomcatYPos (Integer.parseInt((String) COMPILATION_CONFIGS.get(CompilationConfig.STOP_TOMCAT_Y_POS)));
    }
    return cf;
  }
}
