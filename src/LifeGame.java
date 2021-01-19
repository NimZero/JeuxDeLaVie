import java.util.Scanner;

public class LifeGame {
    Board board;

    public LifeGame() {
        board = new Board();
    }

    public void start() {
        board.init();
        board.print();
        for (int i = 0; i < 10; i++) {
            board.nextGeneration();
            board.print();
        }
    }
}
