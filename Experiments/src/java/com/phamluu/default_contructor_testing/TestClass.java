package com.phamluu.default_contructor_testing;

public class TestClass
{

  /**
   * @param args
   */
  public static void main(String[] args)
  {
    /**
     *  NoContructorClass ko define contructor nao het
     *  nen default contructor se duoc tu dong genenerate
     */

    NoContructorClass klass1= new NoContructorClass();
    klass1.dosomething();

    /**
     *  ArgContructorClass da define 1 contructor voi arg
     *  nen default contructor se KO duoc tu dong genenerate--> ERROR
     */

//    ArgContructorClass klass2= new ArgContructorClass();


  }

}
