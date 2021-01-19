public class Cell {
    private boolean isAlive;

    public Cell() {
        isAlive = false;
    }

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public String toString() {
        return isAlive ? "\u25cf" : "o";
    }
}
