package code;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

/**
 * @author Matthew Kanter, Zack Burnley, Zack Cherry
 * A class that handles the prompt window which acts as an entry point for taking in the 
 * amount of rows, columns, and mines to create the minesweeper game.
 */
public class Main {

    protected static int numRows;
    protected static int numCols;
    protected static int numMines;

    /**
     * A method that creates a new prompt pane every time this method is called, allowing for new games
     * to be created without having to terminate the program in its entirety beforehand. Once the Start Game!
     * button is pressed, the game is generated and the prompt pane is disposed.
     * @return void
     */
    public static void newGame() {
        JFrame promptFrame = new JFrame("Minesweeper Setup");
        promptFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        promptFrame.getContentPane().setLayout(new BoxLayout(promptFrame.getContentPane(), BoxLayout.Y_AXIS));

        JLabel rowsLabel = new JLabel("Number of Rows:");
        promptFrame.getContentPane().add(rowsLabel);
        JTextField rowsTextField = new JTextField(20);
        promptFrame.add(rowsTextField);
        JLabel colsLabel = new JLabel("Number of Columns:");
        promptFrame.getContentPane().add(colsLabel);
        JTextField colsTextField = new JTextField(20);
        promptFrame.add(colsTextField);
        JLabel minesLabel = new JLabel("Number of Mines:");
        promptFrame.getContentPane().add(minesLabel);
        JTextField minesTextField = new JTextField(20);
        promptFrame.add(minesTextField);

        JButton startButton = new JButton("Start Game!");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numRows = Integer.parseInt(rowsTextField.getText());
                numCols = Integer.parseInt(colsTextField.getText());
                numMines = Integer.parseInt(minesTextField.getText());

                if(numRows > 0 && numCols > 0 && numMines > 0 && numMines < numRows*numCols){
                    Game game = new Game();
                }
                else {
                    JOptionPane.showMessageDialog(null, "ERROR: Invalid game parameters.");
                }
                promptFrame.dispose();
            }
        });
        promptFrame.add(startButton);

        promptFrame.pack();
        promptFrame.setVisible(true);
    }

    /**
     * Main method that calls the newGame() method, acting as the entry point to the program.
     * @param String[] args
     * @return void
     */
    public static void main(String[] args){
       Main.newGame(); 
    }
 
}
