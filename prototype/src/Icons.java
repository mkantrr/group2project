package prototype.src;

import javax.swing.*;

public class Icons {
    protected static ImageIcon flag = new ImageIcon("icons/flag.png");
    protected static ImageIcon mine = new ImageIcon("icons/mine.png");
    static ImageIcon[] numIcons = new ImageIcon[9];

    public static void fillNumIcons(){
        numIcons[0] = null;
        numIcons[1] = new ImageIcon("icons/one.png");
        numIcons[2] = new ImageIcon("icons/two.png");
        numIcons[3] = new ImageIcon("icons/three.png");
        numIcons[4] = new ImageIcon("icons/four.png");
        numIcons[5] = new ImageIcon("icons/five.png");
        numIcons[6] = new ImageIcon("icons/six.png");
        numIcons[7] = new ImageIcon("icons/seven.png");
        numIcons[8] = new ImageIcon("icons/eight.png");
    }
}
