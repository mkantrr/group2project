package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Main {

    protected static int numRows;
    protected static int numCols;
    protected static int numMines;

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

    public static void main(String[] args){
       Main.newGame(); 
    }
 
}
