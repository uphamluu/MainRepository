package com.phamluu.script_executor.changingDetector;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SamplingThread extends Thread {

    int index;
    Color[] samplingPixelColors;
    int fromX;
    int fromY;
    int stepX;
    int stepY;
    Robot robot;

    SamplingThread(int newIndex, Color[] samplingPixelColors, int fromX, int fromY, int stepX, int stepY) {
        index = newIndex;
        this.samplingPixelColors = samplingPixelColors;
        this.fromX = fromX;
        this.fromY = fromY;
        this.stepX = stepX;
        this.stepY = stepY;

    }

    public void sampling() {
        // boolean cont= true;
        // int i=0;
        try {
            robot = new Robot();
            ArrayList<Thread> temp = new ArrayList<>();
            ExecutorService executor = Executors.newFixedThreadPool(20);
            for (int i = 0; i < samplingPixelColors.length; i++) {
                PixelSamplingThread pxst = new PixelSamplingThread(robot, i, samplingPixelColors, fromX + i * stepX, fromY + i * stepY);
                temp.add(pxst);
                executor.submit(pxst);
            }

            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.HOURS);

            System.err.println("sampling finished: " + executor.isTerminated());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        sampling();

    }

}