package com.kosta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;


/**
 *
 * This program demonstrates use of inner classes.
 * @version 1.11 12-07-2023
 * @author Konstantine Vashalomidze
 * <desctiption>
 *     A clock that prints the time in regular intervals.
 * </desctiption>
 */

public class TalkingClock {

    private int interval;
    private boolean beep;

    /**
     * <description>
     *     Constructs a talking clock
     * </description>
     * @param interval the interval between messages (in milliseconds)
     * @param beep true if the clock should beep
    */
    public TalkingClock(int interval, boolean beep)
    {
        this.interval = interval;
        this.beep = beep;
    }

    /**
     * <description>
     *     Starts the clock.
     * </description>
     */
    public void start()
    {
        // TimerPrinter is a subclass of ActionListener
        var listener = this.new TimePrinter();
        // TimerPrinter.actionPerformed will be automatically called by Timer constructor
        var timer = new Timer(this.interval, listener);
        // Start timer
        timer.start();
    }

    // Inner class
    public class TimePrinter implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is "
                + Instant.ofEpochMilli(e.getWhen()));
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }


}
