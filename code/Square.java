package code;

/**
 * @author Matthew Kanter, Zack Burnley, Zack Cherryy
 * A class used for detailing how/what each square/tile on the Minesweeper board will operate.
 */

public class Square {

    private int xindex, yindex;
    private boolean isMine = false;
    private boolean isFlag = false; 
    private boolean isClicked = false;
    private int nearbyMines = 0;

    /**
     * Square constructor to initialize each tile as a new square object with the index described, correlating
     * with it's position in each 2D array nested for loops. The default boolean instance variables are false for
     * being a mine, being a flag, or being clicked, and the number of nearby mines is initialized as zero.
     * @param xindex for the position of the square on the board on the x-axis.
     * @param yindex for the position of the square onthe board on the y-axis.
     */
    public Square(int xindex, int yindex) {
        this.xindex = xindex;
        this.yindex = yindex;
    }

    /**
     * isMine setter used to set the boolean if the square is a mine or not.
     * @param isMine boolean value to set the instance variable as.
     * @return void
     */
    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

    /**
     * isMine getter used to return the boolean for if the square is a mine or not.
     * @return boolean value if the square is a mine or not.
     */
    public boolean getIsMine() {
        return this.isMine;
    }

    /**
     * isFlag setter used to set the boolean if the square is flagged or not.
     * @param isFlag boolean value to set the instance variable as.
     * @return void
     */
    public void setIsFlag(boolean isFlag) {
        this.isFlag = isFlag; 
    }

    /**
     * isFlag getter used to return the boolean for if the square is flagged or not.
     * @return boolean value if the square is flagged or not.
     */
    public boolean getIsFlag() {
        return this.isFlag; 
    }

    /**
     * isClicked setter used to set the boolean if the square is clicked or not.
     * @param isClicked boolean value to set the instance variable as.
     * @return void
     */
    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    /**
     * isClicked getter used to return the boolean for if the square is clicked or not.
     * @return boolean value if the square is flagged or not.
     */
    public boolean getIsClicked() {
        return this.isClicked; 
    }

    /**
     * nearbyMines getter used to return the integer value for how many out of the
     * 8 tiles around the square are mines.
     * @return int value for how many mines are nearby.
     */
    public int getNearbyMines() {
        return this.nearbyMines;
    }

    /**
     * nearbyMines setter used to set the integer value for how many out of the
     * 8 tiles around the square are mines.
     * @param nearbyMines integer for what value the instance variable should store.
     * @return void
     */
    public void setNearbyMines(int nearbyMines) {
        this.nearbyMines = nearbyMines;
    }

    /**
     * A method to determine how many mines out of the 8 squares around the
     * square in question are mines, settings the nearbyMines instance variable as
     * the total amount of mines nearby.
     * @param x integer representing the position of the square on the board with
     * respect to the x-axis.
     * @param y integer representing the position of the square on the board with
     * respect to the y-axis.
     */
    public void findNearbyMines(int x, int y){
        int maxX = Main.numRows - 1;
        int maxY = Main.numCols - 1;

        int neighbors = 0;
        int i = 0;
        while(i < 8){
            if(i == 0 && (y != 0 && x != 0)){//check for mine to top-left of square
                if(Game.lookForMineAt(x-1, y-1))
                    neighbors++;
            }
            else if(i == 1 && x != 0){//check for mine to top of square
                if(Game.lookForMineAt(x-1, y))
                    neighbors++;
            }
            else if(i == 2 && (y != maxY && x != 0)){//check for mine to top-right of square
                if(Game.lookForMineAt(x-1, y+1))
                    neighbors++;
            }
            else if(i == 3 && y != 0){//check for mine to left of square
                if(Game.lookForMineAt(x, y-1))
                    neighbors++;
            }
            else if(i == 4 && y != maxY){//check for mine to right of square
                if(Game.lookForMineAt(x, y+1))
                    neighbors++;
            }
            else if(i == 5 && (y != 0 && x != maxX)){//check for mine to bottom-left of square
                if(Game.lookForMineAt(x+1, y-1))
                    neighbors++;
            }
            else if(i == 6 && x != maxX) {//check for mine to bottom of square
                if(Game.lookForMineAt(x+1, y))
                    neighbors++;
            }
            else if (i == 7 && (y != maxY && x != maxX)) {//check for mine to bottom-right of square
                if(Game.lookForMineAt(x+1, y+1))
                    neighbors++;
            }
            i++;
        }
        this.nearbyMines = neighbors;
    }

}
    
