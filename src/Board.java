public class Board {
    private Cell[][] board;

    public Board() {
        board = new Cell[12][12];
    }

    public void init() {
        for(Cell[] line:board) {
            for (int i = 0; i < line.length; i++) {
                line[i] = new Cell();
            }
        }

        board[5][4].setAlive(true);
        board[5][5].setAlive(true);
        board[5][6].setAlive(true);
    }

    public int getNeighbors(int x, int y, Cell[][] board) {
        int neighbors=0;

        //above
        if(board[y-1][x-1].isAlive()) neighbors++;
        if(board[y-1][x].isAlive()) neighbors++;
        if(board[y-1][x+1].isAlive()) neighbors++;

        //same level
        if(board[y][x-1].isAlive()) neighbors++;
        if(board[y][x+1].isAlive()) neighbors++;

        //under
        if(board[y+1][x-1].isAlive()) neighbors++;
        if(board[y+1][x].isAlive()) neighbors++;
        if(board[y+1][x+1].isAlive()) neighbors++;

        return neighbors;
    }

    public void print() {
        System.out.println("\n\n");
        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board[i].length-1; j++) {
                System.out.print(" "+board[i][j]+" ");
                if (j==board[i].length-2 && i!=board.length-2) {
                    System.out.print("\n\u2500\u2500\u2500\u253c\u2500\u2500\u2500\u253c\u2500\u2500\u2500\u253c\u2500\u2500\u2500\u253c\u2500\u2500\u2500\u253c\u2500\u2500\u2500\u253c\u2500\u2500\u2500\u253c\u2500\u2500\u2500\u253c\u2500\u2500\u2500\u253c\u2500\u2500\u2500\n");
                }else if(j!=board[i].length-2 && i!=board.length-1) {
                    System.out.print('\u2502');
                }
            }
        }
    }

    public Cell[][] copy() {
        Cell[][] tmp = new Cell[12][12];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                tmp[i][j] = new Cell(board[i][j].isAlive());
            }
        }

        return tmp;
    }

    public void nextGeneration() {
        Cell[][] tmp = copy();

        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                int neighbors = getNeighbors(j, i, tmp);
                if(!tmp[i][j].isAlive() && neighbors==3) board[i][j].setAlive(true);
                if(neighbors!=2 && neighbors!=3) board[i][j].setAlive(false);
            }
        }
    }
}