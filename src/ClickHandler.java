import java.awt.event.*;

public class ClickHandler implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof Button) {
            Button b = (Button) e.getSource();

            // Update colour and value added
            b.updateValue();
        }
    }
}
