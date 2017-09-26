package com.phamluu;
import java.awt.AWTEvent;
import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;

import javax.swing.JFrame;

public class LocationDetector {
    static Robot robot;

    public static void main(String[] args) {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Toolkit.getDefaultToolkit().addAWTEventListener(new MyMouseListener(), AWTEvent.FOCUS_EVENT_MASK);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setAlwaysOnTop(true);
        frame.setResizable(true);
        frame.setFocusableWindowState(true);
    }

    private static class MyMouseListener implements AWTEventListener {

        public void eventDispatched(AWTEvent event) {
            System.out.println(MouseInfo.getPointerInfo().getLocation());
            //      int tempx= MouseInfo.getPointerInfo().getLocation().x;
            //      int tempy= MouseInfo.getPointerInfo().getLocation().y;

            //      robot.mouseMove(75,32);
            //      robot.mousePress(InputEvent.BUTTON1_MASK);
            //      robot.mouseRelease(InputEvent.BUTTON1_MASK);
            //      robot.mouseMove(tempx,tempy);

            //      System.out.println(event);
        }
    }
}
