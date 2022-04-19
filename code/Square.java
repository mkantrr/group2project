package code;

public class Square {

    private int xindex, yindex;
    private boolean isMine = false;
    private boolean isFlag = false; 
    private boolean isClicked = false;
    private int nearbyMines = 0;

    public Square(int xindex, int yindex) {
        this.xindex = xindex;
        this.yindex = yindex;
    }

    public void setXIndex(int xindex) {
        this.xindex = xindex;
    }

    public int getXIndex() {
        return this.xindex;
    }

    public void setYIndex(int yindex) {
        this.yindex = yindex;
    }

    public int getYIndex() {
        return this.yindex;
    }

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean getIsMine() {
        return this.isMine;
    }
 
    public void setIsFlag(boolean isFlag) {
        this.isFlag = isFlag; 
    }

    public boolean getIsFlag() {
        return this.isFlag; 
    }

    public void setIsClicked(boolean isClicked) {
        this.isClicked = isClicked;
    }

    public boolean getIsClicked() {
        return this.isClicked; 
    }

    public int getNearbyMines() {
        return this.nearbyMines;
    }

    public void setNearbyMines(int nearbyMines) {
        this.nearbyMines = nearbyMines;
    }

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
    
