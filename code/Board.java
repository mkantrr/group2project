package code;

import java.util.Random;

/**
 * @author Matthew Kanter, Zack Burnley, Zack Cherry
 * A class used to represent the minesweeper board as a whole. Also generates which squares
 * on the board are mines.
 */
public class Board {

    private Square[][] grid;
    private int dimensionX;
    private int dimensionY;
    private int mineCount;
    private static Board theInstance; 

    /**
     * Board constructor to form a board of squares given an amount of rows, columns, and
     * mines to place on the board. Stores board as a 2D array of squares.
     * @param dimensionX amount of rows.
     * @param dimensionY amount of columns.
     * @param mineCount amount of mines to place on the board.
     */
    public Board(int dimensionX, int dimensionY, int mineCount) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.mineCount = mineCount;
        this.grid = getRandMines();
    }

    /**
     * Board singleton instance that takes in the amount of rows, columns, and mines
     * to place on the board and stores the singleton Board instance as the only Board
     * instance allowed to be created.
     * @param x integer for amount of rows.
     * @param y integer for the amount of columns.
     * @param mines integer for the amount of miens to place on the board.
     * @return Board object.
     */
    public static synchronized Board instance(int x, int y, int mines) {
        theInstance = null;
        if (theInstance == null) {
            theInstance = new Board(x, y, mines);
        }
        return theInstance;
    }

    /**
     * Grid getter that returns the 2D square array stored as an instance variable.
     * @return Square[][] 2D array of squares.
     */
    public Square[][] getGrid() {
        return this.grid;
    }

    /**
     * DimensionX getter that returns the integer value of the amount of rows on the board.
     * @return integer value for number of rows on the board.
     */
    public int getDimensionX() {
        return this.dimensionX;
    }

    /**
     * DimensionY getter that returns the integer value of the amount of columns on the board.
     * @return integer value for number of columns on the board.
     */
    public int getDimensionY() {
        return this.dimensionY;
    }

    /**
     * MineCount getter that returns the integer value of the amount of mines to put on the
     * board.
     * @return integer value for number of mines to put on board.
     */
    public int getMineCount() {
        return this.mineCount;
    } 

    /**
     * A method to decide which squares in the 2D square array grid will be mines, taking two
     * random numbers for row and column x and y coordinates to decide.
     * @return Square[][] 2D array of squares.
     */
    public Square[][] getRandMines() {
        Random rand = new Random();
        Square[][] randMines = new Square[this.dimensionX][this.dimensionY];
        for (int i = 0; i < this.dimensionX; ++i) {
            for (int j = 0; j < this.dimensionY; ++j) {
                randMines[i][j] = new Square(i,j);
            }
        }

        boolean mineCheck = false;
        int count = 0;
        while(count < this.mineCount) {
            int randnumX = (int) ((this.dimensionX * rand.nextDouble())) + 1;
            int randnumY = (int) ((this.dimensionY * rand.nextDouble())) + 1;

            if (randnumX >= this.dimensionX) {
                randnumX = this.dimensionX - 1;
            }
            if (randnumY >= this.dimensionY) {
                randnumY = this.dimensionY - 1;
            }

            mineCheck = false;
            if (randMines[randnumX][randnumY].getIsMine()) {
                mineCheck = true;
                count--;
            }
            if (!mineCheck) {
                randMines[randnumX][randnumY].setIsMine(true);
            }
            count++;
        }
        return randMines;
    }

}
