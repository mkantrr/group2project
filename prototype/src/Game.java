package prototype.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

//Game class. Creates a game object that is of the size the user inputs.

public class Game {

    public static void startGame(int numRows, int numCols, int numMines){
        ImageIcon flag = new ImageIcon("icons/flag.png");
        ImageIcon mine = new ImageIcon("icons/mine.png");
        JFrame gameFrame = new JFrame("Minesweeper");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.getContentPane().setLayout(new GridLayout(numRows, numCols));
        Square[] squareArray = new Square[numRows*numCols];
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
                            button.setIcon(flag);
                    }
                    else{//left click opens the square
                        if(!squareArray[finalI].getIsAFlag()){
                            squareArray[finalI].setClicked(true);
                            System.out.println("You left-clicked the square at: " + squareArray[finalI].getXindex() + ", "
                                    + squareArray[finalI].getYindex());
                            if(squareArray[finalI].getIsAMine()) {//if the square is a mine, game over
                                button.setIcon(mine);
                                JOptionPane.showConfirmDialog(null, "YOU LOSE!",
                                        "Game Over", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                                System.exit(0);
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
}
