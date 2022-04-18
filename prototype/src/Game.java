package prototype.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * @author Zack Burnley, Matt Kanter, Zack Cherry
 * @version 1.0
 * Game class. Creates a game object that is of the size the user inputs.
 * Stores all the squares on the board in the squareArray array
 */

public class Game {

    static Square[] squareArray;

    /**
     * This method generates the board with provided dimensions and number of mines
     * @param numRows The number of rows in the minefield
     * @param numCols The number of columns in the minefield
     * @param numMines The number of mines to be generated in the game
     */
    public static void startGame(int numRows, int numCols, int numMines){
        JFrame gameFrame = new JFrame("Minesweeper");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.getContentPane().setLayout(new GridLayout(numRows, numCols));
        squareArray = new Square[numRows*numCols];
        Icons.fillNumIcons();
        int xCount = 0, yCount = 0;
        for(int i = 0; i < squareArray.length; i++)//Populate the one dimensional array with square objects
        {
            squareArray[i] = new Square(xCount, yCount);//assign each square a 2x2 coordinate. 0,0 is top left corner
            yCount++;
            if(yCount == numCols){
                xCount++;
                yCount = 0;
            }
        }
        Random rng = new Random();
        for(int i = 0; i < numMines; i++){//populate random squares with the amount of mines as defined by user
            int mineIndex = rng.nextInt(squareArray.length);
            squareArray[mineIndex].setIsAMine(true);
        }
        for(int i = 0; i < squareArray.length; i++){
            JToggleButton button = new JToggleButton();
            button.setModel(new OneWayToggleButton());
            button.setBackground(Color.decode("#383e47"));
            button.setOpaque(true);
            int finalI = i;
            button.addMouseListener(new MouseAdapter() {
                public void mouseReleased(MouseEvent e){
                    if(SwingUtilities.isRightMouseButton(e)){//right click sets a flag
                        System.out.println("You right-clicked the square at: " + squareArray[finalI].getXindex() + ", "
                                + squareArray[finalI].getYindex());
                        squareArray[finalI].setIsAFlag(true);
                        if(!squareArray[finalI].getClicked())
                            button.setIcon(Icons.flag);
                    }
                    else{//left click opens the square
                        if(!squareArray[finalI].getIsAFlag()){
                            squareArray[finalI].setClicked(true);
                            System.out.println("You left-clicked the square at: " + squareArray[finalI].getXindex() + ", "
                                    + squareArray[finalI].getYindex());
                            if(squareArray[finalI].getIsAMine()) {//if the square is a mine, game over
                                button.setIcon(Icons.mine);
                                JOptionPane.showConfirmDialog(null, "YOU LOSE!",
                                        "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                System.exit(0);
                            }
                            else{//if the square is not a mine
                                squareArray[finalI].findNearbyMines(squareArray[finalI].getXindex(),
                                        squareArray[finalI].getYindex());
                                button.setIcon(Icons.numIcons[squareArray[finalI].getNearbyMines()]);
                                if(gameWon()){
                                    JOptionPane.showConfirmDialog(null, "YOU WIN!",
                                            "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }
            });
            gameFrame.add(button);
        }
        gameFrame.setSize(800, 600);
        gameFrame.setVisible(true);
    }

    /**
     * This method returns true if there is a mine at (x,y) and false otherwise
     * @param x the X coordinate to look for a mine at
     * @param y the Y coordinate to look for a mine at
     * @return This returns if there is a mine at (x,y)
     */
    public static boolean lookForMineAt(int x, int y){
        for(int i = 0; i < squareArray.length; i++)
            if(squareArray[i].getXindex() == x && squareArray[i].getYindex() == y)
                return squareArray[i].getIsAMine();
        return false;
    }

    /**
     * This method checks if the game has been won by looking at each square and seeing if it is not a mine and has been revealed
     * If each square without a mine ahs been revealed, the game is won and this method returns true
     * @return This returns if the game has been won
     */
    public static boolean gameWon(){
        boolean gameWon = true;
        for(Square square : squareArray){
            if(!square.getClicked() && !square.getIsAMine()){
                gameWon = false;
            }
        }
        return gameWon;
    }
}
