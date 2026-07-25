package board;

public class Board {

    private Cell[][] grid = new Cell[10][10]; //new array of TYPE cell duhhh (no cell object has been created YET!!!)

    public Board(){
        for (int r = 0; r < 10; r++){
            for (int c = 0; c < 10; c++){
                grid[r][c] = new Cell(false, false, 0);
            }
        }
        //place mines then...
        placeMines();
        //...calculate adjacent mines
        calculateAdjacentMines();
    }

    public void placeMines(){
        for (int i = 0; i < 10; i++){
            int row = (int)(Math.random() * 10);  
            int col = (int)(Math.random() * 10);
            while(grid[row][col].isMine()){
                    row = (int)(Math.random() * 10);  
                    col = (int)(Math.random() * 10);
                }
                grid[row][col].setMine(true);
            
        }
    }

    public void calculateAdjacentMines(){
        for (int r = 0; r < 10; r++){
            for (int c = 0; c < 10; c++){
                if (grid[r][c].isMine()) continue;
                int count = 0; 
                for (int dr = -1; dr <= 1; dr++){
                    for (int dc= -1; dc <= 1; dc++){
                        if(dr == 0 && dc == 0) continue; //skip self
                        int nr = r + dr;
                        int nc = c + dc;
                        if(nr >= 0 && nc < 10 && nc >=0 && nr < 10){
                            if(grid[nr][nc].isMine()) {
                                count++;
                            };
                        }
                    }
                }
                grid[r][c].setAdjacentMines(count);
            }

        }

        
    }

    public boolean reveal(int row, int col){
        if (grid[row][col].isRevealed()) return false;
        grid[row][col].setRevealed(true);
        return grid[row][col].isMine();
    }


    public Cell[][] getGrid() {
        return grid;
    }


}
