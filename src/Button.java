import javax.swing.JButton;
import java.awt.*;

public class Button extends JButton {

    int val;

    public Button(int val) {
        super(Integer.toString(val));
        this.val = val;

        if (val == 1) this.setBackground(Color.BLACK);
        else this.setBackground(Color.WHITE);

        this.addActionListener(new ClickHandler());
    }

    public void updateValue() {
        this.setText(Integer.toString((this.val + 1) % 3));
        if (val == 0) {
            val = 1;
            this.setBackground(Color.RED); // for the colour after the click (1)
        } else if (val == 1) {
            val = 2;
            this.setBackground(Color.BLUE); // for the colour after the click (2)
        } else {
            val = 0;
            this.setBackground(Color.WHITE); // back to 0
        }
    }

}
