import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;

public class Opening {
	Container con;
	JFrame f;
	JPanel titlePanel, buttonPanel, messagePanel, backPanel;
	JLabel titleLabel;
	JButton playButton, rulesButton, backButton;
	Font title = new Font("Curlz MT", Font.PLAIN, 100);
	Font buttonFont = new Font("Times New Roman", Font.PLAIN, 20);
	JTextArea messageText;
	play clickPlay = new play();
	play2 clickPlay2 = new play2();
	how2play seeRules = new how2play();
	backToStart backPage = new backToStart();
	
	public Opening() {
		f = new JFrame();
		f.setSize(800, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.black);
		f.setLocation(400, 100);
		f.setLayout(null);
		con = f.getContentPane();
		
		titlePanel = new JPanel();
		titlePanel.setBounds(100, 150, 600, 150);
		titlePanel.setBackground(Color.black);
		
		titleLabel = new JLabel("OnO");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setForeground(Color.white);
		titleLabel.setFont(title);
		
		buttonPanel = new JPanel();
		buttonPanel.setBounds(300, 350, 200, 100);
		buttonPanel.setBackground(Color.black);
		buttonPanel.setLayout(new GridLayout(2, 1));
		
		playButton = new JButton("PLAY");
		playButton.setBackground(Color.black);
		playButton.setForeground(Color.white);
		playButton.setFont(buttonFont);
		playButton.addActionListener(clickPlay);
		
		Box horizontalBox = Box.createHorizontalBox();
		titlePanel.add(horizontalBox);
		
		rulesButton = new JButton("RULES");
		rulesButton.setBackground(Color.black);
		rulesButton.setForeground(Color.white);
		rulesButton.setFont(buttonFont);
		rulesButton.addActionListener(seeRules);
		
		titlePanel.add(titleLabel);
		buttonPanel.add(playButton);
		buttonPanel.add(rulesButton);
		
		con.add(titlePanel);
		con.add(buttonPanel);
		
		GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(300)
					.addComponent(buttonPanel, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
					.addGap(286))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(99)
					.addComponent(titlePanel, GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
					.addGap(85))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(124)
					.addComponent(titlePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(133)
					.addComponent(buttonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		f.getContentPane().setLayout(groupLayout);
		
		f.setVisible(true);
	}
	
	public void Rules() {
		messagePanel = new JPanel();
		messagePanel.setBounds(100, 100, 600, 250);
		messagePanel.setBackground(Color.black);
		con.add(messagePanel);
		titlePanel.setVisible(false);
		buttonPanel.setVisible(false);  

		messageText = new JTextArea("Welcome to OnO D: !! Here are the rules:\n "
				+ "1. single tap for blue, double tap for red;\n"
				+ "2. you can't have 3 of the same colour side by side in a row/column;\n"
				+ "3. in every row/column, there must be the same number of blues and reds;\n"
				+ "4. no column/row can have the same colour pattern.\n"
				+ "That's it, have fun!");
		messageText.setBounds(100, 100, 600, 250);
		messageText.setBackground(Color.black);
		messageText.setForeground(Color.white);
		messageText.setFont(buttonFont);
		messageText.setWrapStyleWord(true);
		messagePanel.add(messageText);
		
		backPanel = new JPanel();
		backPanel.setBounds(350, 350, 150, 100);
		backPanel.setBackground(Color.red);
		backPanel.setLayout(new GridLayout(2, 1));
		con.add(backPanel);
		
		backButton = new JButton("BACK");
		backButton.setBackground(Color.black);
		backButton.setForeground(Color.white);
		backButton.setFont(buttonFont);
		backButton.addActionListener(backPage);
		backPanel.add(backButton);
		
		playButton = new JButton("PLAY");
		playButton.setBackground(Color.black);
		playButton.setForeground(Color.white);
		playButton.setFont(buttonFont);
		playButton.addActionListener(clickPlay2);
		backPanel.add(playButton);
		
		GroupLayout groupLayout = new GroupLayout(f.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addComponent(messagePanel, GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE)
					.addGap(86))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(350)
					.addComponent(backPanel, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
					.addGap(286))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addComponent(messagePanel, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
					.addComponent(backPanel, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(113))
		);
		f.getContentPane().setLayout(groupLayout);
	}
	
	public class play implements ActionListener {
		@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent event) {
			f.setVisible(false);
			Game game = new Game();			
		} 
	}
	
	public class play2 implements ActionListener {
	@SuppressWarnings("unused")
		public void actionPerformed(ActionEvent event) {
			f.setVisible(false);
			messagePanel.setVisible(false);
			backPanel.setVisible(false);
			Game game = new NGame();
		}
	}
	
	public class how2play implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Rules();
			} 
	}
	
	public class backToStart implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			f.setVisible(false);
			messagePanel.setVisible(false);
			backPanel.setVisible(false);
			new Opening();
			} 
		
	}
	
}
