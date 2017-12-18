package com.phamluu.javacollectionExperiments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

import org.junit.Test;

public class TestTreeSet {
    @Test
    public void test1() {
        Random random = new Random();

        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list1.add(random.nextInt(100));
        }
        System.out.println("before sort");
        printList(list1);

        TreeSet<Integer> set1 = new TreeSet<Integer>(list1);
        List<Integer> list2 = new ArrayList<>(set1);
        System.out.println("after sort");
        printList(set1);

    }

    private void printList(Collection<Integer> list) {
        for (Integer s : list) {
            System.out.println(s + " ,");
        }

    }
}
