import javax.swing.*;
import java.awt.*;

public class Board extends JPanel {

    Button[][] buttons;
    int[][] vals = {{0, 1, 0, 0}, {0, 1, 0, 1}, {0, 0, 2, 0}, {0, 0, 0, 0}};
    int size;

    public Board(int size) {
        super();
        this.setLayout(new GridLayout(size, size));

        buttons = new Button[size][size];
        this.size = size;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Button b = new Button(vals[i][j]); // this shows the number
                buttons[i][j] = b;

                this.add(b);
            }
        }

        Solver solver = new Solver(this);

        solver.solve();
        this.vals = solver.getVals();
        printGrid();
    }

    // for debugging i guess (smart move, Ada)
    public void printGrid() {
        for (int[] row : this.vals) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}