package ui;

import board.Cell;
import util.Color;

public class messages {
    public static void show(Cell cell) {
        int count = cell.getAdjacentMines();
        if (count == 0) {
            String[] good = { "Nice!", "Good stuff!", "Clean sweep!", "Whew!" };
            System.out.println(Color.CYAN + good[(int) (Math.random() * good.length)] + Color.RESET);
        } else if (count <= 2) {
            String[] close = { "OooOOoo that was SO close!", "Living on the edge I see.", "Phew." };
            System.out.println(Color.YELLOW + close[(int) (Math.random() * close.length)] + Color.RESET);
        } else {
            String[] tooClose = { "I can't watch!", "You are THAT close to being blown", "Seriously, be careful..",
                    "yikes! watch it..." };
            System.out.println(Color.RED + tooClose[(int) (Math.random() * tooClose.length)] + Color.RESET);
        }
    }

}
