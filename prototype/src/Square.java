package prototype.src;

/**
 *Each tile on the board will be its own"Square"object.Has variables to keep track of which squares are mines,
 *which squares have flags, which squares have already been clicked, etc.
 *The squares are stored in a 1-dimensional array in Main, but each square is assigned a unique 2-dimensional
 *coordinate.
 *
 */

public class Square {
    private int xindex, yindex;
    private boolean isAMine = false, isAFlag = false, clicked = false;
    private int nearbyMines = 0;

    /**
     *
     * @param xindex
     * @param yindex
     */
    public Square(int xindex, int yindex){
        this.xindex = xindex;
        this.yindex = yindex;
    }

    /**
     *
     * @param b
     */
    public void setIsAMine(boolean b){
        this.isAMine = b;
    }

    /**
     *
     * @return
     */
    public boolean getIsAMine(){
        return this.isAMine;
    }

    /**
     *
     * @return
     */
    public int getXindex(){
        return this.xindex;
    }

    /**
     *
     * @return
     */
    public int getYindex(){
        return this.yindex;
    }

    /**
     *
     * @param b
     */
    public void setIsAFlag(boolean b){
        this.isAFlag = b;
    }

    /**
     *
     * @return
     */
    public boolean getIsAFlag(){
        return this.isAFlag;
    }

    /**
     *
     * @param b
     */
    public void setClicked(boolean b){
        this.clicked = b;
    }

    /**
     *
     * @return
     */
    public boolean getClicked(){
        return this.clicked;
    }

    /**
     *
     * @return
     */
    public int getNearbyMines() {
        return nearbyMines;
    }

    /**
     *
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
