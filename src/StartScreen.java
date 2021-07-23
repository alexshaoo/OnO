// import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class StartScreen {

/*    public static int yesNo(String theMessage) {
        return JOptionPane.showConfirmDialog(null, theMessage, "WELCOME", JOptionPane.YES_NO_OPTION);
    } */

    public static void main(String[] args) {

/*        if (yesNo("Play OnO?") == JOptionPane.YES_OPTION) {
            Game game = new Game();
        } else System.exit(0);
    } */
        
       	new Opening();
   	try {
        	FileInputStream fis = new FileInputStream("OnO BGM.mp3");
		Player player = new Player(fis);
		player.play();
		System.out.println("Song is playing!");
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch(JavaLayerException e) {
		e.printStackTrace();
	}
}
