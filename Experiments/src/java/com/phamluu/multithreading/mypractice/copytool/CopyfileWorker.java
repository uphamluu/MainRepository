package com.phamluu.multithreading.mypractice.copytool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

public class CopyfileWorker extends Thread
{
  private String sourceFilename;
  private String destFilename;

  public CopyfileWorker()
  {

  }

  CopyfileWorker(String source, String dest)
  {
    this.sourceFilename = source;
    this.destFilename = dest;
  }

  public String getSourceFilename()
  {
    return sourceFilename;
  }

  public void setSourceFilename(String sourceFilename)
  {
    this.sourceFilename = sourceFilename;
  }

  public String getDestFilename()
  {
    return destFilename;
  }

  public void setDestFilename(String destFilename)
  {
    this.destFilename = destFilename;
  }

  @Override
  public void run()
  {
    try
    {
      copyFileUsingNIO();
      //      copyFileUsingChannel();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void copyFileUsingNIO() throws IOException
  {
    //  System.err.println("thread:" + id +"start");
    File sourceFile = new File(sourceFilename);
    File destFile = new File(destFilename);

    try
    {
      Files.copy(sourceFile.toPath(), destFile.toPath());
      this.finalize();

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    catch (Throwable e)
    {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unused")
  private void copyFileUsingChannel() throws IOException
  {
    File source = new File(sourceFilename);
    File dest = new File(destFilename);
    FileChannel sourceChannel = null;
    FileChannel destChannel = null;
    try
    {
      sourceChannel = new FileInputStream(source).getChannel();
      destChannel = new FileOutputStream(dest).getChannel();
      destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
    }
    finally
    {
      sourceChannel.close();
      destChannel.close();
    }
  }

}
