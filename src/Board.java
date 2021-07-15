import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Board extends JPanel {

    public Board(int length, int height) {
        super();
        this.setLayout(new GridLayout(length, height));

        Random r = new Random();
        int low = 0, high = 2;

        for (int i = 0; i < 16; i++) {
            int result = r.nextInt(high - low) + low;
            Button b = new Button(result); // this shows the number
            if (result == 1) {
                b.setEnabled(false);
            }
            this.add(b);
        }
    }

    // for debugging i guess (smart move, Ada)
    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

}
