package com.phamluu.multithreading.mypractice.copytool;

import java.io.File;


public class FolderTool extends Thread
{
  private String sourceFoldername;
  private String destDestname;

  FolderTool()
  {
  }

  @Override
  public void run()
  {
    copy(sourceFoldername, destDestname);
  }

  private void copy(String source, String dest){
    File sourceFolder= new File(source);
    if(sourceFolder.isDirectory()){
      File destFolder= new File(dest);
      if(!destFolder.exists()){
          destFolder.mkdir();
      }
      for (File f: sourceFolder.listFiles()){
        if(f.isFile()){
            CopyfileWorker cpyWorker= new CopyfileWorker(f.getAbsolutePath(),dest+"\\"+f.getName());
            cpyWorker.start();
        }
        else
        {
          copy(source + "\\" + f.getName(), dest + "\\" + f.getName());
        }
      }
    }
    else
    {
      // ko copy nua

    }


  }

  public String getSourceFoldername()
  {
    return sourceFoldername;
  }

  public void setSourceFoldername(String sourceFoldername)
  {
    this.sourceFoldername = sourceFoldername;
  }

  public String getDestDestname()
  {
    return destDestname;
  }

  public void setDestDestname(String destDestname)
  {
    this.destDestname = destDestname;
  }

}

