package cell;

public class Cell {
    private boolean hasMine;
    private boolean hasRevealed;
    private int adjacentMines;
    
    public Cell(boolean hasMine, boolean hasRevealed, int adjacentMines) {
        this.hasMine = hasMine;
        this.hasRevealed = hasRevealed;
        this.adjacentMines = adjacentMines;
    }

    public boolean isHasMine() {
        return hasMine;
    }

    public void setHasMine(boolean hasMine) {
        this.hasMine = hasMine;
    }

    public boolean isHasRevealed() {
        return hasRevealed;
    }

    public void setHasRevealed(boolean hasRevealed) {
        this.hasRevealed = hasRevealed;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    
  

}
