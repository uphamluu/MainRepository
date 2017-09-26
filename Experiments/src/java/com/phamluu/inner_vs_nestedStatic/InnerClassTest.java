package com.phamluu.inner_vs_nestedStatic;

public class InnerClassTest
{

  /*
   * Creating Inner class in Java
   */
  private class Inner
  {
    public void name()
    {
      System.out.println("Inner class example in java");
    }
  }

  public static void main(String args[])
  {

    //creating local inner class inside method
    class Local
    {
      public void name()
      {
        System.out.println("Example of Local class in Java");

      }
    }

    //creating instance of local inner class
    Local local = new Local();
    local.name(); //calling method from local inner class

    //Creating anonymous inner class in java for implementing thread
    Thread anonymous = new Thread()
    {
      @Override
      public void run()
      {
        System.out.println("Anonymous class example in java");
      }
    };
    anonymous.start();

    //example of creating instance of inner class
    InnerClassTest test = new InnerClassTest();
    InnerClassTest.Inner inner = test.new Inner();
    inner.name(); //calling method of inner class

  }

}
