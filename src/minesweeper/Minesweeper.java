package minesweeper;

import java.util.Scanner;

import board.Board;
import board.Cell;

import util.Color;

public class Minesweeper {

    Board board;
    Scanner scanner;

    public Minesweeper() {
        this.board = new Board();
        this.scanner = new Scanner(System.in);
    }

    public void renderBoard() {
        Cell[][] grid = this.board.getGrid();
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (!grid[r][c].isRevealed()) {
                    System.out.print("\u25FC" + " ");
                } else if (grid[r][c].isMine()) {
                    System.out.print(Color.RED + "* " + Color.RESET);
                } else {
                    int count = grid[r][c].getAdjacentMines();
                    switch (count) {
                        case 0:
                            System.out.print(Color.GREY + "\u00B7" + " " + Color.RESET);
                            break;
                        case 1:
                            System.out.print(Color.GREEN.toString() + count + " " + Color.RESET);
                            break;
                        case 2:
                            System.out.print(Color.ORANGE.toString() + count + " " + Color.RESET);
                            break;

                        default:
                            System.out.print(Color.RED.toString() + count + " " + Color.RESET);
                            break;
                    }

                }
            }
            if (r < 10) {
                System.out.print(Color.GREY.toString() + "| " + (r + 1) + Color.RESET);
            }
            System.out.println();
        }
        System.out.println(Color.GREY.toString() + "1 2 3 4 5 6 7 8 9 10" + Color.RESET);
    }

    public boolean checkWin() {
        int revealedCount = 0;
        Cell[][] grid = this.board.getGrid();
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (grid[r][c].isRevealed())
                    revealedCount++;
            }
        }

        return revealedCount == 90;

    }

    public void start() {
        System.out.println(Color.GREEN.toString() + "WELCOME TO MINESWEEPER!" + Color.RESET);
        System.out.println(Color.GREEN.toString() + "LET'S PLAY!" + Color.RESET);

        while (true) {
            renderBoard();
            System.out.println(Color.GREEN.toString() + "Select row" + Color.RESET);
            int row = this.scanner.nextInt() - 1;
            System.out.println(Color.GREEN.toString() + "Select column" + Color.RESET);
            int col = this.scanner.nextInt() - 1;
            board.reveal(row, col);

            if (board.isMineAt(row, col)) {
                renderBoard();
                System.out.println(Color.RED.toString() + "Boom! YOU LOSE!" + Color.RESET);
                break;
            }

            if (checkWin()) {
                renderBoard();
                System.out.println(Color.GREEN.toString() + "YOU WIN!" + Color.RESET);
                break;
            }
            ;

        }

    }

}
