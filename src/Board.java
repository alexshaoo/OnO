import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;


public class Board extends JPanel {

	private static final long serialVersionUID = 1L;
	Button[][] buttons;
    int[][] vals = {{0, 1, 0, 0}, {0, 1, 0, 1}, {0, 0, 2, 0}, {0, 0, 0, 0}};
    int[][] finalBoard = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
    int size;

    public Board(int size) {
        super();
        this.setLayout(new GridLayout(size, size));

        buttons = new Button[size][size];
        this.size = size;

        Solver solver = new Solver(this);

        solver.solve();
        this.vals = solver.getVals();
        
        printGrid();
        
        int[][] e = emptyBoardGenerator(); // gets the empty board, but we don't know the values of each non empty space (we just know that they're non empty)
        
        for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			System.out.print(e[i][j] + " ");
    		} System.out.println();
    	}
        
        for (int i = 0; i < 4; i++) {
        	for (int j = 0; j < 4; j++) {
        		if (e[i][j] != 0) { // if the space is non empty
        			finalBoard[i][j] = vals[i][j]; // then the value of the ij space of the final board = the ij space from the full board
        		}
        	}
        }
        
        printNewGrid();
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Button b = new Button(finalBoard[i][j]); // this shows the number
                buttons[i][j] = b;

                this.add(b);
            }
        }
        
    }

    // for debugging i guess (smart move, Ada)
    public void printGrid() {
        for (int[] row : this.vals) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    // for debugging purpuses
    public void printNewGrid() {
        for (int[] row : this.finalBoard) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    
    // this function randomly chooses a row and column to keep the filled in value
    
    public int generateFill() {
    	int chosen = 10; // for the chosen row and column
    	int[] taken = new int[4]; // so that no same row is chosen
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			taken[i] = 1;
    		}
    	}
    	
    	int col = ThreadLocalRandom.current().nextInt(0, 4);
    	
    	System.out.println("Column: " + col);
    	
    	if (taken[col] == 1) { // if the space isn't taken, taken[row][col] should be how we initialized it
    		chosen = col;
    		taken[col] = 0; // indicates space is taken
    		for (int i = 0; i < 2; i++) {
    			System.out.println("chosen: " + chosen);
    		}
    		return chosen;
    	} else if (taken[col] == 0) { // if space is taken, we call the function again until finds an empty space
    		generateFill();
    	}
    	    	
    	return chosen;
    	
    }
    
    public int[][] emptyBoardGenerator() { // after choosing spaces to keep, proceed to generate an empty board with those spaces filled in
    	int[][] emptyBoard = new int[4][4];
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			emptyBoard[i][j] = 0;
    		}
    	}
    	
    	for (int i = 0; i < 4; i++) {
    		int specials = generateFill(); // the "special" spaces, aka not empty
    		for (int k = 0; k < 2; k++) {
        			System.out.println("specials: " + specials);
        	}
    		for (int j = 0; j < 4; j++) { // looped 4 times, 1 for each row.
    			if (j == specials) { // check if row and columns match the coordinates of the chosen spaces
    				emptyBoard[i][j] = 10; // if so, the empty space has a non 0 value
    				System.out.print("i: " + i + "j: " + j);
    			}
    		}
    	}
    	
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4; j++) {
    			System.out.println("EmptyBoard: " + emptyBoard[i][j]);
    		}
    	}
    	
    	return emptyBoard;
    }
    
    
}
