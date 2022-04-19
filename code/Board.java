package code;

import java.util.Random;

public class Board {

    private Square[][] grid;
    private int dimensionX;
    private int dimensionY;
    private int mineCount;
    private static Board theInstance; 

    public Board(int dimensionX, int dimensionY, int mineCount) {
        this.dimensionX = dimensionX;
        this.dimensionY = dimensionY;
        this.mineCount = mineCount;
        this.grid = getRandMines();
    }

    public static synchronized Board instance(int x, int y, int mines) {
        theInstance = null;
        theInstance = new Board(x, y, mines);
        return theInstance;
    }

    public Square[][] getGrid() {
        return this.grid;
    }

    public int getDimensionX() {
        return this.dimensionX;
    }

    public int getDimensionY() {
        return this.dimensionY;
    }

    public int getMineCount() {
        return this.mineCount;
    } 

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
            }
            if (!mineCheck) {
                randMines[randnumX][randnumY].setIsMine(true);
            }
            count ++;
        }
        return randMines;
    }

}
