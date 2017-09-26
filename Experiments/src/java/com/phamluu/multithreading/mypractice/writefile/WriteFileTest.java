package com.phamluu.multithreading.mypractice.writefile;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class WriteFileTest {

  private static final int NR_FILE=10;
  public static void main(String[] args) {
//    writeIntoFileSingleThread();
//    writeFileMultithread();
    writeFileWithThreadPool();

  }
/*****************************************************/
  private static void writeIntoFileSingleThread(){
    long start=System.currentTimeMillis();
    WriteFileThread wft = new WriteFileThread(0);
    for(int i=0; i<NR_FILE;i++){
      if(wft.getState()==State.TERMINATED){
        wft = new WriteFileThread(0);
      }
      wft.start();

      try
      {
        wft.join();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    long end =System.currentTimeMillis();
    System.err.println("single thread: " + (end-start)+"ms::" +((end-start)/1000)+ " s");
  }


  /*************************************************************************/
  @SuppressWarnings("unused")
  private static void writeFileMultithread(){
    long start=System.currentTimeMillis();
    ArrayList<Thread> allthreads= new ArrayList<>();
    for(int i=1; i<=NR_FILE;i++){
      WriteFileThread wft = new WriteFileThread(i);
      wft.start();
      allthreads.add(wft);
    }

    for(Thread th: allthreads){
      try
      {
        th.join();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    long end =System.currentTimeMillis();
    System.err.println("Multi threads: " + (end-start)+"ms::" +((end-start)/1000)+ " s");
  }

  private static void writeFileWithThreadPool(){
    long start=System.currentTimeMillis();
    ExecutorService executor = Executors.newFixedThreadPool(3);
    for(int i=1; i<=NR_FILE;i++){
      executor.submit(new WriteFileThread(i));
    }
    executor.shutdown();
    try
    {
      executor.awaitTermination(1, TimeUnit.DAYS);
    }
    catch (InterruptedException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    long end =System.currentTimeMillis();
    System.err.println("Multi threads: " + (end-start)+"ms::" +((end-start)/1000)+ " s");
  }

}