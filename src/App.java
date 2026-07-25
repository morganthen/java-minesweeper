import board.Board;
import board.Cell;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("WELCOME TO MINESWEEPER!");
        System.out.println("LET'S PLAY!");
        Board board = new Board();
        renderBoard(board);

       
    }
    //display or render board
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
}
