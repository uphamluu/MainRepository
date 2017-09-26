package com.phamluu.script_executor.changingDetector;

import java.awt.Color;
import java.awt.Robot;

public class ScreenChangingDetector {
    static Robot robot;
    static int numberOfSamplingPixel = 200;
    static Color[] currentLRDSamplingPixelColors = new Color[numberOfSamplingPixel];
    static Color[] currentLRUSamplingPixelColors = new Color[numberOfSamplingPixel];

    public static void main(String[] args) {
        // initRobot();
        // try {
        // robot = new Robot();
        // } catch (AWTException e) {
        // e.printStackTrace();
        // }
        ScreenChangingDetector scd = new ScreenChangingDetector();

        long start = System.currentTimeMillis();
        scd.screenSampling();
        long end = System.currentTimeMillis();
        System.err.println("sampling time:" + (end - start));
        System.err.println(scd.isScreenChanged());
        long finalEnd = System.currentTimeMillis();
        System.err.println("changing detection Time:" + (finalEnd - start));

    }

    private void screenSampling() {
        SamplingThread sp1 = new SamplingThread(0, currentLRDSamplingPixelColors, 0, 0, 4, 3);
        sp1.start();
        SamplingThread sp2 = new SamplingThread(1, currentLRUSamplingPixelColors, 0, 1060, 4, -3);
        sp2.start();
        try {
            sp1.join();
            sp2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private boolean isScreenChanged() {
        boolean result = false;
        Color[] newLRD = new Color[numberOfSamplingPixel];
        SamplingThread sp1 = new SamplingThread(2, newLRD, 0, 0, 4, 3);
        sp1.start();
        Color[] newLRU = new Color[numberOfSamplingPixel];
        SamplingThread sp2 = new SamplingThread(3, newLRU, 0, 1060, 4, -3);
        sp2.start();
        try {
            sp1.join();
            sp2.join();
            for (int i = 0; i < numberOfSamplingPixel; i++) {
                if (!newLRD[i].equals(currentLRDSamplingPixelColors[i])) {
                    System.err.println(newLRD[i].toString() + currentLRDSamplingPixelColors[i].toString());
                    return true;
                }
                if (!newLRU[i].equals(currentLRUSamplingPixelColors[i])) {
                    System.err.println(newLRU[i].toString() + currentLRUSamplingPixelColors[i].toString());
                    return true;
                }
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;

    }

}
