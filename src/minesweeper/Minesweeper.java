package minesweeper;

import java.util.Scanner;

import board.Board;
import board.Cell;

public class Minesweeper {

    static void renderBoard(Board board){
            Cell[][] grid = board.getGrid();
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

        public void checkWin(){

        }

        public void start(){
            System.out.println("WELCOME TO MINESWEEPER!");
            System.out.println("LET'S PLAY!");
            Scanner scanner = new Scanner(System.in);
            Board board = new Board();
            while(true){
            renderBoard(board);
            System.out.println("Select row");
            int row = scanner.nextInt() - 1;
            System.out.println("Select column");
            int col = scanner.nextInt() - 1;
            if(board.reveal(row, col)){
                System.out.println("BOOM YOU LOSE!");
                break;
            };
            
        }

        }


    

}
