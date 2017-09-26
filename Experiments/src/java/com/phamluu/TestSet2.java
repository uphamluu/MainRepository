package com.phamluu;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class TestSet2 {

    private class MyClass {
        int aNummer;

        public MyClass(int a) {

            this.aNummer = a;
        }

    }

    @Test
    public void testsomething() {
        Set<MyClass> set1 = new HashSet<>();
        set1.add(new MyClass(1));
        set1.add(new MyClass(2));
        set1.add(new MyClass(4));
        Assert.assertEquals(new Long(2), new Long(set1.size()));

    }

    @Test
    public void testsomething2() {
        Long nummer3 = 12L;
        Long nummer4 = 12L;

        System.err.println(nummer3 == nummer4);

        nummer3 = 1200L;
        nummer4 = 1200L;

        System.err.println(nummer3 == nummer4);

        System.err.println("-------------------");
        Long nummer = new Long(10);
        Long nummer2 = new Long(10);
        System.err.println(nummer == nummer2);

        nummer = new Long(1000);
        nummer2 = new Long(1000);

        System.err.println(nummer == nummer2);

    }
}
