import board.Board;
import board.Cell;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("WELCOME TO MINESWEEPER!");
        System.out.println("LET'S PLAY!");

        Board board = new Board();
        renderBoard(board);

       
    }

     static void renderBoard(Board board){
            Cell[][] grid = board.getGrid();
            for (int r = 0; r < 10; r++){
                for(int c = 0; c < 10 ; c++){
                    if (!grid[r][c].isRevealed())
                    System.out.print("[.]");
            
                }
                System.out.println();
            }
        }
}
