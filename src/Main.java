import com.kosta.TalkingClock;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        var clock = new TalkingClock(1_000, true);
        clock.start();


        // Keep program running until the user selects "OK"
        JOptionPane.showMessageDialog(null, "Quit Program?");
        System.exit(0);


    }
}