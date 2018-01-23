package com.phamluu.javacollectionExperiments;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.phamluu.UyenTimerUtil;

public class ArrayListTest {
    private static final int SIZE = 10000000;

    private static final String INSERT_TIME = "INSERT_TIME";

    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<Integer>(SIZE);
        testWithList(temp);

        System.err.println("---------------------");

        List<Integer> temp2 = new LinkedList<Integer>();
        testWithList(temp2);
    }

    private static void testWithList(List<Integer> listToTest) {
        UyenTimerUtil.start("FILL_ARRAY");

        fillArray(listToTest);
        UyenTimerUtil.stopAndprint("FILL_ARRAY");

        for (int i = 0; i < 100; i++) {
            ArrayListTest.insertIntoRandomPos(listToTest);
        }
        UyenTimerUtil.print(INSERT_TIME);

    }

    private static List<Integer> fillArray(List<Integer> listTofill) {
        Random rn = new Random();
        for (int i = 0; i < SIZE; i++) {
            listTofill.add(rn.nextInt());
        }
        System.err.println("size: " + listTofill.size());
        return listTofill;

    }

    private static void insertIntoRandomPos(List<Integer> aArray) {
        Random rn = new Random();
        int newPos = rn.nextInt(SIZE - 1);
        UyenTimerUtil.start(INSERT_TIME);
        aArray.add(newPos, rn.nextInt());
        UyenTimerUtil.stop(INSERT_TIME);
        

    }
    
    
    
    
    
}
