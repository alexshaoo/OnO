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
        if (val == 1) {
  				val = 2;
  				this.setBackground(Color.RED); // for the colour after the click (2)
  				this.setText(String.valueOf(val));
  			} else if (val == 0) {
  				val = 1;
  				this.setBackground(Color.BLACK); // for the colour after the click (1)
  				this.setText(String.valueOf(val));
  			} else if (val == 2) {
  				val = 0;
  				this.setBackground(Color.WHITE); // back to 0
  				this.setText(String.valueOf(val));
            }
    }

}
