package ui;

import util.Color;

public class continueMessages {
    public static void show() {
        String[] continueMsgs = {
                "Press Enter to continue...",
                "\"'You miss 100% of the shots you don't take' - Wayne Gretsky\" - Michael Scott",
                "Another! - Thor",
                "That one was free. Next one won't be.",
                "Wow. Groundbreaking. Press Enter.",
                "Even a broken clock is right twice a day.",
                "I'd clap but I don't have hands.",
                "Don't get cocky, kid. - Han Solo",
                "Bold move. Let's see if it pays off.",
                "You're doing great sweetie. - Kris Jenner",
        };
        System.out.print(
                Color.GREEN + continueMsgs[(int) (Math.random() * continueMsgs.length)] + "\n[ENTER]" + Color.RESET);
    }

}
