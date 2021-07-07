import javax.swing.JButton;
import java.awt.*;

@SuppressWarnings("serial")
public class Button extends JButton {

    int val;

    public Button(int val) {
        super(Integer.toString(val));
        this.val = val;

        if (val == 1) this.setBackground(Color.BLACK);
        else this.setBackground(Color.WHITE);
    }

    public void updateValue() {
        this.setText(Integer.toString(this.val + 1));
    }

}
