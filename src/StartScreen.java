import java.awt.*;
import java.util.Random;
import javax.swing.*;

@SuppressWarnings({ "serial" })
public class StartScreen extends JFrame {

    private int width = 300, height = 300, rows = 4, cols = 4;

    public StartScreen() {
        super("OnO");
        this.setLayout(new GridLayout(rows, cols));

        Random r = new Random();
        int low = 0, high = 2;

        for (int i = 0; i < 16; i++) {
            int result = r.nextInt(high - low) + low;
            Button b = new Button(result); // this shows the number
            this.add(b);
        }

        this.setPreferredSize(new Dimension(width, height));
        this.pack();
        this.setVisible(true);
    }

    public static int yesNo(String theMessage) {
        return JOptionPane.showConfirmDialog(null, theMessage, "WELCOME", JOptionPane.YES_NO_OPTION);
    }

    public static void main(String[] args) {

        if (yesNo("Play OnO?") == JOptionPane.YES_OPTION) {
            StartScreen game = new StartScreen();
        } else System.exit(0);
    }
}
