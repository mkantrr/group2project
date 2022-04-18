package prototype.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

/**
 *
 * Main class. Responsible for prompting user for board size and amount of mines.
 */

public class Main {
    protected static int numRows, numCols, numMines;

    // This class prompts the user for input for height, width, and number of mines to be in the game and passes them to the Game class if they allow for a valid game
    public static void main(String[] args){
        JFrame promptFrame = new JFrame("Minesweeper");
        promptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        promptFrame.getContentPane().setLayout(new BoxLayout(promptFrame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel rowsLabel = new JLabel("Number of rows:");
        promptFrame.getContentPane().add(rowsLabel);
        JTextField rowsTextField = new JTextField(20);
        promptFrame.add(rowsTextField);
        JLabel colsLabel = new JLabel("Number of columns:");
        promptFrame.getContentPane().add(colsLabel);
        JTextField colsTextField = new JTextField(20);
        promptFrame.add(colsTextField);
        JLabel minesLabel = new JLabel("Number of mines:");
        promptFrame.getContentPane().add(minesLabel);
        JTextField minesTextField = new JTextField(20);
        promptFrame.add(minesTextField);

        JButton startButton = new JButton("Start game");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numRows = Integer.parseInt(rowsTextField.getText());
                numCols = Integer.parseInt(colsTextField.getText());
                numMines = Integer.parseInt(minesTextField.getText());

                if(numRows > 0 && numCols > 0 && numMines > 0 && numMines < numRows*numCols){
                    Game game = new Game();
                    game.startGame(numRows, numCols, numMines);
                }
                else
                    JOptionPane.showMessageDialog(null, "ERROR: Invalid game parameters.");
            }
        });
        promptFrame.add(startButton);

        promptFrame.pack();
        promptFrame.setVisible(true);
    }
}
