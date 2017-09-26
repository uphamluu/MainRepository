package com.phamluu.script_executor.changingDetector;

import java.awt.Color;
import java.awt.Robot;

public class PixelComparingThread extends Thread {

    int index;
    Robot robot;
    Color[] samplingPixelColors;
    int x;
    int y;

    PixelComparingThread(Robot robot, int newIndex, Color[] samplingPixelColors, int fromX, int fromY) {
        index = newIndex;
        this.robot = robot;
        this.samplingPixelColors = samplingPixelColors;
        this.x = fromX;
        this.y = fromY;
    }

    public void sampling() {
        samplingPixelColors[index] = robot.getPixelColor(x, y);
    }

    @Override
    public void run() {
        sampling();
    }

}