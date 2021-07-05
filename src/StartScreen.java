import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;

public class StartScreen extends JPanel {

    public static int yesNo(String theMessage) {
        return JOptionPane.showConfirmDialog(null, theMessage,
                "WELCOME", JOptionPane.YES_NO_OPTION);
    }

    public static void main(String[] argv) {
        if (yesNo("Play OnO? D:") == JOptionPane.YES_OPTION)
        {
            JFrame f = new JFrame("OnO!");
            JLabel label1 = new JLabel("konichiwa");
            f.setPreferredSize(new Dimension(500, 500));
            f.add(label1);
            f.pack();
            f.setVisible(true);
            // when program gets big, need a way to route
        }  else System.exit(0);
    }

}
