import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{

    private int width = 800, height = 800, xSquares = 4, ySquares = 4;

    public Game() {
        super("OnO");

        // gridbaglayout is flexible but kinda complicated
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;

        c.weightx = 1;
        c.weighty = 1;

        c.gridwidth = 3;
        c.gridheight = 3;

        Board board = new Board(xSquares, ySquares);
        // board at top left
        c.gridx = 0;
        c.gridy = 0;

        this.add(board, c);

        JButton EndGame = new JButton("End");
        // We won't worry about undo for now
        JButton Undo = new JButton("Undo");
        JButton NewGame = new JButton("New Game");

        // fit 3
        c.gridwidth = 1;
        c.gridheight = 1;
        c.gridy = 3;
        this.add(EndGame, c);
        c.gridx = 1;
        this.add(Undo, c);
        c.gridx = 2;
        this.add(NewGame, c);
        /*
        EndGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        NewGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                close();
                new StartScreen();
            }
        });
        */
        this.setPreferredSize(new Dimension(width, height));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
}
