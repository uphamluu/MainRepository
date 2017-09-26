package com.phamluu.multithreading.mypractice.copytool;

public class MainClass
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {

    testCopyfolder();
  }


  public  static void testCopyfolder(){
    Long start =System.currentTimeMillis() ;
    FolderTool folderCopyThread= new FolderTool();
    folderCopyThread.setSourceFoldername("E:\\Devel\\IDEs\\eclipse 3.7 indigo Exper");
    folderCopyThread.setDestDestname("E:\\Devel\\TEst2");
    folderCopyThread.start();
    try
    {
      folderCopyThread.join();
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    Long end =System.currentTimeMillis() ;
    System.err.println((end-start)+" ms");

  }

}
