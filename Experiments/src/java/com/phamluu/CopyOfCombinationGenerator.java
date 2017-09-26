package com.phamluu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CopyOfCombinationGenerator {

    private static final int NUMBER_OF_POSITIONS = 7;

    private static final int PACK_SIZE = 10000000;

    //    ArrayList<List<StringBuffer>> dataSets;

    public static void main(String[] args) throws IOException {
        Long start = System.currentTimeMillis();
        for (int i = 0; i <= 9; i++) {
            StringBuffer aaa = new StringBuffer(String.valueOf(i));
            dosomething(aaa);
        }
        Long end = System.currentTimeMillis();
        System.err.println("COMPLETE GENERATION:" + (end - start) + " ms");

    }

    private static void dosomething(StringBuffer aaa) {
        //    private static void dosomething() {

        CopyOfCombinationGenerator cm = new CopyOfCombinationGenerator();
        ArrayList<List<StringBuffer>> dataSets = cm.prepareData();
        Long start = System.currentTimeMillis();
        System.err.println("---------- Start GENERATION--------------");
        List<StringBuffer> result = cm.generateCombination(dataSets, aaa);
        System.err.println("----------- END GENERATION -------------");
        Long end = System.currentTimeMillis();
        System.err.println("GENERATION:" + (end - start) + " ms");

        System.err.println(result.size());
        //        System.err.println("---------- Start WRITING --------------");
        //        start = System.currentTimeMillis();
        //        cm.writeToFile(result);
        //        end = System.currentTimeMillis();
        //        System.err.println("----------- END WRITING -------------");
        //        System.err.println("WRITING TIME:" + (end - start) + " ms");
        //        cm = null;
        //        System.gc();
        System.runFinalization();

    }

    /**
     * 
     */
    private ArrayList<List<StringBuffer>> prepareData() {
        ArrayList<List<StringBuffer>> dataSets = new ArrayList<List<StringBuffer>>();
        for (int j = 1; j <= NUMBER_OF_POSITIONS; j++) {
            List<StringBuffer> list = new ArrayList<>();
            for (int i = 0; i <= 9; i++) {
                list.add(new StringBuffer(String.valueOf(i)));
            }
            dataSets.add(list);
        }

        return dataSets;

    }

    private List<StringBuffer> generateCombination(ArrayList<List<StringBuffer>> dataSets, StringBuffer aaa) {
        List<StringBuffer> result = new ArrayList<>();
        int i = 1;
        for (List<StringBuffer> listOfElements : dataSets) {
            System.err.println(i);
            result = generateCrossProduct(result, listOfElements, aaa);
            i++;
        }
        return result;

    }

    private List<StringBuffer> generateCrossProduct(List<StringBuffer> l1, List<StringBuffer> l2, StringBuffer aaa) {
        List<StringBuffer> result = new ArrayList<>();
        if (l1 == null && l2 == null) {
            return result;
        } else if (l1 == null || l1.isEmpty()) {
            return l2;
        } else if (l2 == null || l2.isEmpty()) {
            return l1;
        } else {
            int counter = 0;
            long start = System.currentTimeMillis();
            long end = 0;
            int i = 1;
            for (StringBuffer s1 : l1) {
                for (StringBuffer s2 : l2) {
                    result.add(new StringBuffer(s1.append(";").append(s2).append(";").append(aaa)));
                    counter++;
                    if (counter % PACK_SIZE == 0) {
                        end = System.currentTimeMillis();
                        System.err.println(i + " GENERATION " + PACK_SIZE + " elements:" + (end - start) + " ms");
                        i++;
                        start = System.currentTimeMillis();

                    }

                }
            }
        }
        return result;
    }

    private void writeToFile(List<StringBuffer> stringList) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("Uyen_Combination_NrPos_" + NUMBER_OF_POSITIONS
                + ".txt"));

        for (StringBuffer str : stringList) {
            writer.write(str.toString());
            writer.write("\n");
        }

        writer.close();
    }
}
