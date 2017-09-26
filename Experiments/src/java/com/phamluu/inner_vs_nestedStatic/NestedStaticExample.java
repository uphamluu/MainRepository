package com.phamluu.inner_vs_nestedStatic;


public class NestedStaticExample {

    public static void main(String args[]){

        StaticNested nested = new StaticNested();
        nested.name();
    }

    //static nested class in java
    private static class StaticNested{
        public void name(){
            System.out.println("static nested class example in java");
        }
    }
}

