package src;
//Each tile on the board will be its own "Square" object. Has variables to keep track of which squares are mines,
//which squares have flags, which squares have already been clicked, etc.

//The squares are stored in a 1-dimensional array in Main, but each square is assigned a unique 2-dimensional
//coordinate.

public class Square {
    private int xindex, yindex;
    private boolean isAMine = false, isAFlag = false, clicked = false;

    public Square(){
    }
    public Square(int xindex, int yindex){
        this.xindex = xindex;
        this.yindex = yindex;
    }
    public void setIsAMine(boolean b){
        this.isAMine = b;
    }
    public boolean getIsAMine(){
        return this.isAMine;
    }
    public void setXindex(int i){
        this.xindex = i;
    }
    public int getXindex(){
        return this.xindex;
    }
    public void setYindex(int i){
        this.yindex = i;
    }
    public int getYindex(){
        return this.yindex;
    }
    public void setIsAFlag(boolean b){
        this.isAFlag = b;
    }
    public boolean getIsAFlag(){
        return this.isAFlag;
    }
    public void setClicked(boolean b){
        this.clicked = b;
    }
    public boolean getClicked(){
        return this.clicked;
    }
}
