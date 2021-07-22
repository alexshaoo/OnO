import javax.swing.*;
import java.awt.*;

public class Game extends JFrame{

    private int width = 800, height = 800, xSquares = 4, ySquares = 4;
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 15);
	endGame end = new endGame();
	newGame newG = new newGame();
	static int interval;
	static Timer timer;
    	JButton timerButton;
    
    public Game() {
        super("OnO");

        NewBoard board = new NewBoard(xSquares, ySquares);
        this.add(board, BorderLayout.CENTER);
        
        JPanel p = new JPanel();
	p.setBackground(Color.white);
	p.setForeground(Color.white);
        this.add(p, BorderLayout.PAGE_END);
        
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
   		NewGame.addActionListener(newG);

        p.add(EndGame);
        p.add(Undo);
        p.add(NewGame);
	    
       	timerButton = new JButton();
        this.add(timerButton, BorderLayout.PAGE_START);
        timerButton.setBackground(Color.white);
        timerButton.setForeground(Color.black);
        timerButton.setFont(timerFont);
        timerMain();

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
	
	public class newGame implements ActionListener {
   		public void actionPerformed(ActionEvent event) {
   			close();
			@SuppressWarnings("unused")
			NewGame game = new NewGame();
   		}
   	}
   	
   	public void close() {
   		this.dispose();
   	}
	
	public void timerMain() {
		int delay = 1000;
		int period = 1000;
		timer = new Timer();
		interval = 11;
		timer.scheduleAtFixedRate(new TimerTask() {

			public void run() {		        
//		        timerLabel.setText("Time left: " + setInterval());
				timerButton.setText("Time left: " + setInterval());
			}
		}, delay, period);
   	}
   	
	private static final int setInterval() {
		if (interval == 0) {
			timer.cancel();
			JOptionPane.showMessageDialog(null, "TIME UP!",
		    	      "ERROR", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return --interval;
	}
    
}
