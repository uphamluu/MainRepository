package com.phamluu.script_executor.changingDetector;

import java.awt.Color;
import java.awt.Robot;

public class PixelSamplingThread extends Thread {

	int index;
	Robot robot;
	Color[] samplingPixelColors;
	int x;
	int y;

	PixelSamplingThread(Robot robot, int newIndex, Color[] samplingPixelColors,
			int fromX, int fromY) {
		index = newIndex;
		// try {
		this.robot = robot;
		// } catch (AWTException e) {
		// e.printStackTrace();
		// }
		this.samplingPixelColors = samplingPixelColors;
		this.x = fromX;
		this.y = fromY;
	}

	public void sampling() {
		// long start = System.currentTimeMillis();
		samplingPixelColors[index] = robot.getPixelColor(x, y);
		// long end= System.currentTimeMillis();
		// System.err.println("sampling time:" + (end - start));
	}

	@Override
	public void run() {
		sampling();
	}

}