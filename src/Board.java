import java.util.Random;

public class Board {

    public static void main(String[] args) {
        int[][] board = new int[4][4];
        Random r = new Random();
        int low = 0;
        int high = 2;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int result = r.nextInt(high-low) + low;
                board[i][j] = result;
            }
        }

        for(int[] row : board) {
            printRow(row);
        }

    }

    public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

}
