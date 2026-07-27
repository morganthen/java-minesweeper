package board;

public class Cell {
    private boolean isMine;
    private boolean isRevealed;
    private int adjacentMines;
    private boolean isFlagged;

    public Cell(boolean isMine, boolean isRevealed, int adjacentMines) {
        this.isMine = isMine;
        this.isRevealed = isRevealed;
        this.adjacentMines = adjacentMines;
        this.isFlagged = false;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean isRevealed) {
        this.isRevealed = isRevealed;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged() {
        this.isFlagged = this.isFlagged ? false : true;
    }

}
