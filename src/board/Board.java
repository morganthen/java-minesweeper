package board;

public class Board {

    private Cell[][] grid; // new array of TYPE cell duhhh (no cell object has been created YET!!!)
    private int size;
    private int numMines;

    public Board(int size, int numMines) {

        this.size = size;
        this.numMines = numMines;
        this.grid = new Cell[size][size];

        for (int r = 0; r < this.size; r++) {
            for (int c = 0; c < this.size; c++) {
                grid[r][c] = new Cell(false, false, 0);
            }
        }
        // place mines then...
        placeMines();
        // ...calculate adjacent mines
        calculateAdjacentMines();
    }

    public int getSize() {
        return this.size;
    }

    public int getNumMines() {
        return this.numMines;
    }

    public void placeMines() {
        for (int i = 0; i < this.numMines; i++) {
            int row = (int) (Math.random() * this.size);
            int col = (int) (Math.random() * this.size);
            while (grid[row][col].isMine()) {
                row = (int) (Math.random() * this.size);
                col = (int) (Math.random() * this.size);
            }
            grid[row][col].setMine(true);
        }
    }

    public void calculateAdjacentMines() {
        for (int r = 0; r < this.size; r++) {
            for (int c = 0; c < this.size; c++) {
                if (grid[r][c].isMine())
                    continue;
                int count = 0;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        if (dr == 0 && dc == 0)
                            continue; // skip self
                        int nr = r + dr;
                        int nc = c + dc;
                        if (nr >= 0 && nc < this.size && nc >= 0 && nr < this.size) {
                            if (grid[nr][nc].isMine()) {
                                count++;
                            }
                        }
                    }
                }
                grid[r][c].setAdjacentMines(count);
            }

        }

    }

    // recursion craziness about to happen here
    public void reveal(int row, int col) {
        if (grid[row][col].isRevealed())
            return;
        grid[row][col].setRevealed(true);
        if (grid[row][col].isMine())
            return;
        if (grid[row][col].getAdjacentMines() == 0) {
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0)
                        continue;
                    int nr = row + dr;
                    int nc = col + dc;
                    if (nr >= 0 && nr < this.size && nc >= 0 && nc < this.size) {
                        reveal(nr, nc);
                    }
                }
            }
        }
    }

    public boolean isMineAt(int row, int col) {
        return grid[row][col].isMine();
    }

    public Cell[][] getGrid() {
        return grid;
    }

}
