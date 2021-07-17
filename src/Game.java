import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{

    private int width = 800, height = 800, xSquares = 4, ySquares = 4;
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 15);
	endGame end = new endGame();
    
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

       // find a way to make buttons smaller
        
        JButton EndGame = new JButton("End");
		EndGame.setBackground(Color.black);
		EndGame.setForeground(Color.white);
		EndGame.setFont(buttonFont);
		EndGame.addActionListener(end);

		JButton Undo = new JButton("Undo");
		Undo.setBackground(Color.black);
		Undo.setForeground(Color.white);
		Undo.setFont(buttonFont);

        JButton NewGame = new JButton("New Game");
		NewGame.setBackground(Color.black);
		NewGame.setForeground(Color.white);
		NewGame.setFont(buttonFont);

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
	this.setLocation(450, 30);
        this.pack();
        this.setVisible(true);
    }

   	public class endGame implements ActionListener {
		public void actionPerformed(ActionEvent event) {
				System.exit(0);
			} 
	}
    
}
