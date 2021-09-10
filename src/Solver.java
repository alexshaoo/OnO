import java.util.ArrayList;

public class Solver {

    private static final int RED = 1, BLUE = 2;

    int size;
    int[][] vals;

    public Solver(Board board) {
        this.size = board.size;
        this.vals = board.vals;
    }

    private void printArrayList(ArrayList<int[]> list) {
        for (int[] tile : list) {
            System.out.println("x:" + Integer.toString(tile[0]));
            System.out.println("y:" + Integer.toString(tile[1]));
            System.out.println("colour:" + Integer.toString(tile[2]));
            System.out.println();
        }
    }

    public int[][] getVals() {
        return vals;
    }

    // check if target int array is in list
    private boolean isInList(ArrayList<int[]> list, int[] checkIfContained) {
        for (int[] arr : list) {
            boolean contained = true;
            for (int i = 0; i < arr.length; i++)
                if (arr[i] != checkIfContained[i]) {
                    contained = false;
                    break;
                }
            if (contained) {
                return true;
            }
        }
        return false;
    }

    // solves the puzzle with the given vals as much as it can - returns true if fully solved, false if not
    // TODO: make this way more efficient pls
    public boolean solve() {

        // check if board is fully solved by checking board sum
        if (getSolvedSquares().isEmpty()) {

            int sum = 0;
            for (int[] row : vals) {
                for (int tile : row) {
                    sum += tile;
                }
            }

            return (sum == 1.5 * size * size);
        }

        updateValues(getSolvedSquares());
        return solve();
    }

    public ArrayList<int[]> getSolvedSquares() {
        ArrayList<int[]> fillable = ruleOne();
        fillable.addAll(ruleTwo());
        fillable.addAll(ruleThree());
        return fillable;
    }

    private void updateValues(ArrayList<int[]> values) {
        for (int[] value : values) {
            System.out.println(value[0]);
            System.out.println(value[1]);
            System.out.println(value[2]);

            vals[value[0]][value[1]] = value[2];
        }
    }

    // couldn't think of a better name for these
    private ArrayList<int[]> ruleOne() {

        // x, y, colour (1 for red, 2 for blue)
        ArrayList<int[]> toFill = new ArrayList<>();
        int[] toPush = new int[3];

        // loop through entire grid once to catch all 'no more than 3' rules (rule 1)
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (vals[i][j] == 0) {
                    toPush[0] = i;
                    toPush[1] = j;

                    // in bounds
                    if (j >= 2) {
                        if (vals[i][j - 1] == vals[i][j - 2] && vals[i][j - 1] != 0) {
                            // switch colour

                            toPush[2] = vals[i][j - 1] % 2 + 1;
                            toFill.add(toPush.clone());
                        }
                    }

                    if (i >= 2) {
                        if (vals[i - 1][j] == vals[i - 2][j] && vals[i - 1][j] != 0) {
                            toPush[2] = vals[i - 1][j] % 2 + 1;
                            toFill.add(toPush.clone());
                        }
                    }

                    if (j < size - 2) {
                        if (vals[i][j + 1] == vals[i][j + 2] && vals[i][j + 1] != 0) {
                            toPush[2] = vals[i][j + 1] % 2 + 1;
                            toFill.add(toPush.clone());

                        }
                    }

                    if (i < size - 2) {
                        if (vals[i + 1][j] == vals[i + 2][j] && vals[i + 1][j] != 0) {
                            toPush[2] = vals[i + 1][j] % 2 + 1;
                            toFill.add(toPush.clone());
                        }
                    }

                    // in between (could push duplicate results with two-in-a-rows) TODO: fix that
                    if (j > 0 && j < size - 1) {
                        if (vals[i][j - 1] == vals[i][j + 1] && vals[i][j - 1] != 0) {
                            toPush[2] = vals[i][j - 1] % 2 + 1;
                            toFill.add(toPush.clone());
                        }
                    }

                    if (i > 0 && i < size - 1) {
                        if (vals[i - 1][j] == vals[i + 1][j] && vals[i - 1][j] != 0) {
                            toPush[2] = vals[i - 1][j] % 2 + 1;
                            toFill.add(toPush.clone());
                        }
                    }
                }
            }
        }

        return toFill;
    }

    private ArrayList<int[]> ruleTwo() {

        int numReds, numBlues;

        int[] toPush = new int[3];
        ArrayList<int[]> toFill = new ArrayList<>();
        ArrayList<Integer> blanks = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            toPush[0] = i;
            // same amount of colours in each row
            numReds = 0;
            numBlues = 0;
            blanks.clear();

            for (int j = 0; j < size; j++) {
                if (vals[i][j] == 1) numReds++;
                else if (vals[i][j] == 2) numBlues++;
                else blanks.add(j);
            }

            // fill the rest of the squares with blue
            if (numReds == size / 2) {
                toPush[2] = BLUE;

                for (int col : blanks) {
                    toPush[1] = col;
                    toFill.add(toPush.clone());
                }
            }

            // fill squares with red
            else if (numBlues == size / 2) {
                toPush[2] = RED;

                for (int col : blanks) {
                    toPush[1] = col;
                    toFill.add(toPush.clone());
                }
            }

            numReds = 0;
            numBlues = 0;
            blanks.clear();

            // same amount of colours in each column
            toPush[1] = i;
            for (int j = 0; j < size; j++) {
                if (vals[j][i] == 1) numReds++;
                else if (vals[j][i] == 2) numBlues++;
                else blanks.add(j);
            }

            // fill the rest of the squares with blue
            if (numReds == size / 2) {
                toPush[2] = BLUE;

                for (int col : blanks) {
                    toPush[0] = col;
                    toFill.add(toPush.clone());
                }
            }

            // fill squares with red
            else if (numBlues == size / 2) {
                toPush[2] = RED;

                for (int col : blanks) {
                    toPush[0] = col;
                    toFill.add(toPush.clone());
                }
            }
        }
        return toFill;
    }

    private ArrayList<int[]> ruleThree() {

        ArrayList<int[]> toFill = new ArrayList<>();

        ArrayList<Integer> fullRow = new ArrayList<>();
        ArrayList<Integer> fillableRow = new ArrayList<>();
        ArrayList<Integer> fullCol = new ArrayList<>();
        ArrayList<Integer> fillableCol = new ArrayList<>();

        int rowFilled;
        int colFilled;

        for (int i = 0; i < size; i++) {

            rowFilled = 0;
            colFilled = 0;

            for (int j = 0; j < size; j++) {
                if (vals[i][j] != 0) rowFilled++;
                if (vals[j][i] != 0) colFilled++;
            }

            if (rowFilled == size) fullRow.add(i);
            else if (rowFilled == size - 2) fillableRow.add(i);
            if (colFilled == size) fullCol.add(i);
            else if (colFilled == size - 2) fillableCol.add(i);

        }


        // consider comparing fullRow with fillableRows instead of the other way around
        for (int fillable : fillableRow) {

            for (int full : fullRow) {
                boolean solvable = true;
                for (int k = 0; k < size; k++) {
                    if (Math.abs(vals[full][k]) != Math.abs(vals[fillable][k]) && vals[fillable][k] != 0) {
                        solvable = false;
                        break;
                    }
                }

                if (solvable) {

                    // find two empty spots and solve accordingly
                    for (int k = 0; k < size; k++) {
                        if (vals[fillable][k] == 0) {
                            int[] solved = new int[3];
                            solved[0] = fillable;
                            solved[1] = k;
                            solved[2] = vals[full][k] % 2 + 1;

                            // possible duping
                            if (!isInList(toFill, solved)) toFill.add(solved);
                        }
                    }

                }
            }
        }


        for (int fillable: fillableCol) {

            for (int full : fullCol) {
                boolean solvable = true;
                for (int k = 0; k < size; k++) {
                    if (vals[k][full] != vals[k][fillable] && vals[k][fillable] != 0) {
                        solvable = false;
                        break;
                    }
                }

                // TODO: dupe code, put into function?
                if (solvable) {
                    for (int k = 0; k < size; k++) {
                        if (vals[k][fillable] == 0) {
                            int[] solved = new int[3];
                            solved[0] = k;
                            solved[1] = fillable;
                            solved[2] = vals[k][full] % 2 + 1;

                            if (!isInList(toFill, solved)) toFill.add(solved);
                        }
                    }

                }
            }
        }
        fullRow.clear();
        fillableRow.clear();
        fullCol.clear();
        fillableCol.clear();
        return toFill;
    }

}
