package prototype.src;

/**
 * @author Zack Burnley, Matt Kanter, Zack Cherry
 * @version 1.0
 * Each tile on the board will be its own"Square"object.Has variables to keep track of which squares are mines,
 * which squares have flags, which squares have already been clicked, etc.
 * The squares are stored in a 1-dimensional array in Main, but each square is assigned a unique 2-dimensional
 * coordinate.
 *
 */

public class Square {
    private int xindex, yindex;
    private boolean isAMine = false, isAFlag = false, clicked = false;
    private int nearbyMines = 0;

    /**
     * This is the constructor that creates a square located at index X and Y
     * @param xindex the x index of the square
     * @param yindex the y index of the square
     */
    public Square(int xindex, int yindex){
        this.xindex = xindex;
        this.yindex = yindex;
    }

    /**
     * Sets if this square contains a mine
     * @param b This is if the square is a mine or not
     */
    public void setIsAMine(boolean b){
        this.isAMine = b;
    }

    /**
     * Returns if rhe square contains a mine
     * @return if the square is a mine
     */
    public boolean getIsAMine(){
        return this.isAMine;
    }

    /**
     * Returns the x index of the square
     * @return the x index
     */
    public int getXindex(){
        return this.xindex;
    }

    /**
     * Returns the y index of the square
     * @return the y index
     */
    public int getYindex(){
        return this.yindex;
    }

    /**
     * Sets if a flag has been placed on this square
     * @param b if a flag was placed
     */
    public void setIsAFlag(boolean b){
        this.isAFlag = b;
    }

    /**
     * Returns if a flag has already been placed on this square
     * @return if the square has a flag
     */
    public boolean getIsAFlag(){
        return this.isAFlag;
    }

    /**
     * Sets if the square has been clicked
     * @param b if the square has been clicked
     */
    public void setClicked(boolean b){
        this.clicked = b;
    }

    /**
     * Returns if the square has been clicked on already
     * @return if the square has been clicked on
     */
    public boolean getClicked(){
        return this.clicked;
    }

    /**
     * Returns the number of mines in all surrounding squares
     * @return
     */
    public int getNearbyMines() {
        return nearbyMines;
    }

    /**
     * Sets the number of mines in all surrounding squares by calling Game.lookForMineAt() on each square in a 3x3 grid with this square as the center
     * @param x The x index of the square
     * @param y The y index of the square
     */
    public void findNearbyMines(int x, int y){
        int maxX = Main.numCols - 1;
        int maxY = Main.numCols - 1;

        int i = 0;
        while(i < 8){
            if(i == 0 && (y != 0 && x != 0)){//check for mine to top-left of square
                if(Game.lookForMineAt(x-1, y-1))
                    nearbyMines++;
            }
            else if(i == 1 && x != 0){//check for mine to top of square
                if(Game.lookForMineAt(x-1, y))
                    nearbyMines++;
            }
            else if(i == 2 && (y != maxY && x != 0)){//check for mine to top-right of square
                if(Game.lookForMineAt(x-1, y+1))
                    nearbyMines++;
            }
            else if(i == 3 && y != 0){//check for mine to left of square
                if(Game.lookForMineAt(x, y-1))
                    nearbyMines++;
            }
            else if(i == 4 && y != maxY){//check for mine to right of square
                if(Game.lookForMineAt(x, y+1))
                    nearbyMines++;
            }
            else if(i == 5 && (y != 0 && x != maxX)){//check for mine to bottom-left of square
                if(Game.lookForMineAt(x+1, y-1))
                    nearbyMines++;
            }
            else if(i == 6 && x != maxX) {//check for mine to bottom of square
                if(Game.lookForMineAt(x+1, y))
                    nearbyMines++;
            }
            else if (i == 7 && (y != maxY && x != maxX)) {//check for mine to bottom-right of square
                if(Game.lookForMineAt(x+1, y+1))
                    nearbyMines++;
            }
            i++;
        }
        System.out.println("This square has " + nearbyMines + " nearby mine(s).");
    }
}
