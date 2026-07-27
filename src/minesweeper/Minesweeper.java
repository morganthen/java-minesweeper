package minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

import board.Board;
import board.Cell;
import ui.LoseScreen;
import ui.Welcome;
import util.Color;

public class Minesweeper {

    // state init
    Board board;
    Scanner scanner;
    int size;
    int numMines;

    // constructor
    public Minesweeper() {
        this.scanner = new Scanner(System.in);
    }

    // methods
    public void renderBoard(boolean isGameOver) {
        Cell[][] grid = this.board.getGrid();
        for (int r = 0; r < this.size; r++) {
            for (int c = 0; c < this.size; c++) {
                Color color;
                if (!grid[r][c].isRevealed()) {
                    color = isGameOver ? Color.GREY : Color.RESET;

                    System.out.print(color.toString() + "  " + "\u25FC" + Color.RESET);
                } else if (grid[r][c].isMine()) {
                    System.out.print(Color.RED + "  *" + Color.RESET);
                } else {
                    int count = grid[r][c].getAdjacentMines();
                    switch (count) {
                        case 0:
                            System.out.print(Color.GREY + "  " + "\u00B7" + Color.RESET);
                            break;
                        case 1:
                            color = isGameOver ? Color.GREY : Color.GREEN;
                            System.out.print(color.toString() + "  " + count + Color.RESET);
                            break;
                        case 2:
                            color = isGameOver ? Color.GREY : Color.ORANGE;
                            System.out.print(color.toString() + "  " + count + Color.RESET);
                            break;
                        default:
                            color = isGameOver ? Color.GREY : Color.RED;
                            System.out.print(color.toString() + "  " + count + Color.RESET);
                            break;
                    }
                }
            }
            if (r < this.size) {
                System.out.print(Color.GREY.toString() + " | " + (r + 1) + Color.RESET);
            }
            System.out.println();
        }
        // -----footer----- //
        for (int i = 0; i < this.size; i++) {
            System.out.printf(Color.GREY + "%3d" + Color.RESET, (i + 1));
        }
        System.out.println();
    }

    public boolean checkWin() {
        int revealedCount = 0;
        Cell[][] grid = this.board.getGrid();
        for (int r = 0; r < board.getSize(); r++) {
            for (int c = 0; c < board.getSize(); c++) {
                if (grid[r][c].isRevealed())
                    revealedCount++;
            }
        }
        return revealedCount == (board.getSize() * board.getSize()) - board.getNumMines();
    }

    private void clearScreen() {
        System.out.print("\033[2J\033[H");
        System.out.flush();
    }

    // method: GAME PLAY
    public void start() {
        boolean playing = true;
        while (playing) {
            this.clearScreen();
            Welcome.show();
            System.out.println(Color.GREEN.toString() + "LET'S PLAY!" + Color.RESET);
            System.out.println();
            System.out.println(Color.GREEN.toString() + "Select difficulty:" + Color.RESET);
            System.out.println();
            System.out.println(Color.CYAN + "Easy [1]");
            System.out.println("Medium [2]");
            System.out.println("Hard [3]" + Color.RESET);
            System.out.println();
            while (true) {
                try {
                    int level = this.scanner.nextInt();
                    if (level < 1 || level > 3) {
                        System.out.println(Color.RED.toString() + "Enter a valid level" + Color.RESET);
                        continue;
                    }
                    switch (level) {
                        case 1:
                            this.size = 10;
                            this.numMines = 10;
                            break;
                        case 2:
                            this.size = 16;
                            this.numMines = 40;
                            break;
                        case 3:
                            this.size = 24;
                            this.numMines = 99;
                            break;
                    }
                    break;
                } catch (InputMismatchException e) {
                    this.scanner.nextLine();
                    System.out.println(Color.RED.toString() + "You need to enter a number" + Color.RESET);
                }
            }

            this.board = new Board(this.size, this.numMines);

            while (true) {
                clearScreen();
                renderBoard(false);
                System.out.println();
                System.out.println(Color.GREEN.toString() + "Enter a row number" + Color.RESET);
                System.out.println();

                int row;

                while (true) {
                    try {
                        row = this.scanner.nextInt() - 1;
                        if (row >= this.size || row < 0) {
                            System.out.println(Color.RED.toString() + "Enter 1-" + this.size + Color.RESET);
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        this.scanner.nextLine();
                        System.out.println(Color.RED.toString() + "You need to enter a number" + Color.RESET);
                    }
                }

                int col;

                while (true) {
                    try {
                        System.out.println();
                        System.out.println(Color.GREEN.toString() + "Enter a column number" + Color.RESET);
                        System.out.println();
                        col = this.scanner.nextInt() - 1;
                        System.out.println();
                        if (col >= this.size || col < 0) {
                            System.out.println(Color.RED.toString() + "Enter 1-" + this.size + Color.RESET);
                            continue;
                        }
                        break;
                    } catch (InputMismatchException e) {
                        this.scanner.nextLine();
                        System.out.println(Color.RED.toString() + "You need to enter a number" + Color.RESET);
                    }
                }

                board.reveal(row, col);

                if (board.isMineAt(row, col)) {
                    clearScreen();
                    renderBoard(true);
                    System.out.println();
                    LoseScreen.show();
                    System.out.println();
                    System.out.println("Play again? Y/N");
                    System.out.println();
                    String choice = this.scanner.next();
                    System.out.println();
                    if (choice.equalsIgnoreCase("n")) {
                        playing = false;
                    }
                    break;
                }

                if (checkWin()) {
                    renderBoard(false);
                    System.out.println();
                    System.out.println(Color.GREEN.toString() + "YOU WIN!" + Color.RESET);
                    System.out.println();
                    System.out.println(Color.CYAN + "Play again? Y/N" + Color.RESET);
                    System.out.println();
                    String choice = this.scanner.next();
                    System.out.println();
                    if (choice.equalsIgnoreCase("n")) {
                        playing = false;
                    }
                    break;
                }
                ;
            }
        }
        System.out.println("Thanks for playing!");
    }
}
