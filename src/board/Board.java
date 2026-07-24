package board;

public class Board {

    private Cell[][] grid = new Cell[10][10];

    public Board(){
        for (int r = 0; r < 10; r++){
            for (int c = 0; c < 10; c++){
                grid[r][c] = new Cell(false, false, 0);
            }
        }
    }


    public Cell[][] getGrid() {
        return grid;
    }


}
