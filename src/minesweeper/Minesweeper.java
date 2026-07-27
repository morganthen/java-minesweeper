package minesweeper;

import java.util.InputMismatchException;
import java.util.Scanner;

import board.Board;
import board.Cell;
import ui.LoseScreen;
import ui.Welcome;
import ui.WinScreen;
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
    private void renderBoard(boolean isGameOver) {
        Cell[][] grid = this.board.getGrid();
        for (int r = 0; r < this.size; r++) {
            for (int c = 0; c < this.size; c++) {
                Color color;
                if (!grid[r][c].isRevealed() && grid[r][c].isFlagged()) {
                    color = isGameOver ? Color.GREY : Color.ORANGE;
                    System.out.print(color + "  " + "!" + Color.RESET);
                } else if (!grid[r][c].isRevealed()) {
                    color = isGameOver ? Color.GREY : Color.RESET;
                    System.out.print(color + "  " + "\u25FC" + Color.RESET);
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
                            System.out.print(color + "  " + count + Color.RESET);
                            break;
                        case 2:
                            color = isGameOver ? Color.GREY : Color.ORANGE;
                            System.out.print(color + "  " + count + Color.RESET);
                            break;
                        default:
                            color = isGameOver ? Color.GREY : Color.RED;
                            System.out.print(color + "  " + count + Color.RESET);
                            break;
                    }
                }
            }
            if (r < this.size) {
                System.out.print(Color.GREY + " | " + (r + 1) + Color.RESET);
            }
            System.out.println();
        }
        // -----footer----- //
        for (int i = 0; i < this.size; i++) {
            System.out.printf(Color.GREY + "%3d" + Color.RESET, (i + 1));
        }
        System.out.println();
    }

    private boolean checkWin() {
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

    private int getCoordinate(String label) {
        while (true) {
            try {
                System.out.println();
                System.out.println(Color.GREEN + "Enter a " + label + " number" + Color.RESET);
                System.out.println();
                int value = this.scanner.nextInt() - 1;
                if (value >= this.size || value < 0) {
                    System.out.println(Color.RED + "Enter 1-" + this.size + Color.RESET);
                    continue;
                }
                return value;
            } catch (InputMismatchException e) {
                this.scanner.nextLine();
                System.out.println(Color.RED + "You need to enter a number" + Color.RESET);
            }
        }
    }

    private boolean askReplay() {
        System.out.println();
        System.out.println("Play again? Y/N");
        System.out.println();
        String choice = this.scanner.next();
        System.out.println();
        return choice.equalsIgnoreCase("y");
    }

    private boolean menu() {
        System.out.println();
        System.out.println(Color.CYAN + "Easy [1]");
        System.out.println("Medium [2]");
        System.out.println("Hard [3]");
        System.out.println();
        System.out.println(Color.RED + "QUIT [4]" + Color.RESET);
        System.out.println();
        while (true) {
            try {
                int level = this.scanner.nextInt();
                if (level < 1 || level > 4) {
                    System.out.println(Color.RED + "Enter a valid choice [1-4]" + Color.RESET);
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
                    case 4:
                        this.clearScreen();
                        System.out.println("Thanks for playing Morgan's Minesweeper Game!");
                        return false;
                }
                break;
            } catch (InputMismatchException e) {
                this.scanner.nextLine();
                this.clearScreen(); // flag
                renderBoard(false); // flag
                System.out.println(Color.RED + "You need to enter a number" + Color.RESET);
            }
        }
        return true;
    }

    // GAME PLAY
    public void start() {
        boolean playing = true;
        while (playing) {
            this.clearScreen();
            Welcome.show();
            if (!this.menu())
                break;
            // creating board for player
            this.board = new Board(this.size, this.numMines);
            while (true) {
                clearScreen();
                renderBoard(false);
                int row = this.getCoordinate("row");
                int col = this.getCoordinate("column");
                System.out.println();
                System.out.println(Color.GREEN + "Reveal [R] or Flag [F]" + Color.RESET);
                System.out.println();
                String action = scanner.next().toLowerCase();
                if (action.equals("f")) {
                    board.toggleFlag(row, col);
                    continue;
                }

                board.reveal(row, col);

                if (board.isMineAt(row, col)) {
                    clearScreen();
                    renderBoard(true);
                    System.out.println();
                    LoseScreen.show();
                    playing = askReplay();
                    break;
                }
                if (checkWin()) {
                    clearScreen();
                    renderBoard(false);
                    System.out.println();
                    WinScreen.show();
                    playing = askReplay();
                    break;
                }

            }
        }
        this.clearScreen();
        System.out.println("Thanks for playing Morgan's Minesweeper Game!");
    }
}
