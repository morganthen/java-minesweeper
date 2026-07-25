package minesweeper;

import java.util.Scanner;

import board.Board;
import board.Cell;

public class Minesweeper {

    Board board;
    Scanner scanner;

    public Minesweeper(){
        this.board = new Board();
        this.scanner = new Scanner(System.in);
    }

    public void renderBoard(){
            Cell[][] grid = this.board.getGrid();
            for (int r = 0; r <= 10; r++){
                for(int c = 0; c < 10 ; c++){
                    if (r == 10){
                        System.out.print(" - ");
                    }else{
                        if (!grid[r][c].isRevealed()){
                            System.out.print("[.]");   
                        }else if (grid[r][c].isMine()){
                            System.out.print("[*]");
                        }else{
                            int count = grid[r][c].getAdjacentMines();
                            if(count == 0){ 
                                System.out.print("[ ]");
                            }else{
                                System.out.print("[" + count + "]");
                            }
                        }
                    }
                }
                if(r < 10){
                    System.out.print("| " + (r+1));
                }
                System.out.println();
            }
            System.out.println(" 1  2  3  4  5  6  7  8  9  10 ");
        }

        public boolean checkWin(){
            int revealedCount = 0;
            Cell[][] grid = this.board.getGrid();
            for (int r = 0 ; r < 10; r++){
                for (int c= 0; c < 10 ; c++){
                    if(grid[r][c].isRevealed()) revealedCount++;
                }
            }

            return revealedCount == 90;


        }

        public void start(){
            System.out.println("WELCOME TO MINESWEEPER!");
            System.out.println("LET'S PLAY!");
            // game loop starts here
            while(true){
                renderBoard();
                System.out.println("Select row");
                int row = this.scanner.nextInt() - 1;
                System.out.println("Select column");
                int col = this.scanner.nextInt() - 1;
                if(board.reveal(row, col)){
                    System.out.println("BOOM YOU LOSE!");
                    break;
                };
                if(checkWin()){
                    renderBoard();
                    System.out.println("YOU WIN!");
                    break;
                };
            
        }

        }


    

}
