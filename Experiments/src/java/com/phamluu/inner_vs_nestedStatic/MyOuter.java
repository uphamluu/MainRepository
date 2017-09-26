package com.phamluu.inner_vs_nestedStatic;

public class MyOuter {
  private int x;
  MyOuter(int x, int y) {
    this.x = x;
    new MyInner(y).privateDisplay();
  }
  public class MyInner {
    private int y;
    MyInner(int y) {
      this.y = y;
    }
    private void privateDisplay() {
      System.out.println("privateDisplay x = " + x + " and y = " + y);
    }
    public void publicDisplay() {
      System.out.println("publicDisplay x =  " + x + " and y = " + y);
    }
  }
}