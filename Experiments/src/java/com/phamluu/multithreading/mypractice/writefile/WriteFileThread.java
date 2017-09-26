package com.phamluu.multithreading.mypractice.writefile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFileThread extends Thread{

  int index;

  WriteFileThread(int newIndex){
    index = newIndex;
  }

  public void writeIntoFile(){
    File file = new File("output/" +index+"_"+ System.currentTimeMillis()+".txt");
    try (FileOutputStream fop = new FileOutputStream(file)) {

      // if file doesn't exists, then create it
      if (!file.exists()) {
        file.createNewFile();
      }
      // get the content in bytes
      StringBuffer content= new StringBuffer();
      for(int i=0; i<10000000;i++){
        content.append(System.currentTimeMillis());
      }

      fop.write( content.toString().getBytes());

      fop.flush();
      fop.close();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run()
  {
    writeIntoFile();
  }


}