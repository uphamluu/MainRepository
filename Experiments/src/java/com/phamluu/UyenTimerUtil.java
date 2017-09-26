package com.phamluu;

import java.util.TreeMap;

public class UyenTimerUtil {
    static TreeMap<String, Timer> timers;

    public static void start(String tag) {
        if (timers == null) {
            timers = new TreeMap<String, Timer>();
        }
        UyenTimerUtil temp = new UyenTimerUtil();
        Timer aTimer = timers.get(tag);
        if (aTimer == null) {
            aTimer = temp.new Timer(tag, System.currentTimeMillis());

        } else {
            aTimer.start();
        }
        timers.put(tag, aTimer);

    }

    public static void stopAndprint(String tag) {
        Timer aTimer = timers.get(tag);
        if (aTimer != null) {
            aTimer.stop();
            aTimer.print();
        }
    }

    public static void stop(String tag) {
        Timer aTimer = timers.get(tag);
        if (aTimer != null) {
            aTimer.stop();
        }

    }

    public static void print(String tag) {
        Timer aTimer = timers.get(tag);
        if (aTimer != null) {
            aTimer.print();
        }

    }

    private class Timer {
        //        boolean accumulated;

        String tag;

        long start;

        long end;

        long duration;

        //        public Timer(String tag, long start, boolean accumulated) {
        //
        //            this.tag = tag;
        //            this.start = start;
        //            this.accumulated = accumulated;
        //
        //        }

        public Timer(String tag, long start) {
            this.tag = tag;
            this.start = start;
            this.end = 0;

            //            this.accumulated = false;

        }

        public void start() {
            start = System.currentTimeMillis();
            end = 0;
        }

        public void stop() {
            end = System.currentTimeMillis();
            duration += end - start;
            start = 0;
            end = 0;
        }

        void print() {
            System.err.println(tag + " :: " + (duration) + " ms");

        }

        //        public boolean isAccumulated() {
        //            return accumulated;
        //        }

    }

}
