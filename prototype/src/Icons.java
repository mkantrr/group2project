package prototype.src;

import javax.swing.*;

public class Icons {
    protected static ImageIcon flag = new ImageIcon("prototype/src/icons/flag.png");
    protected static ImageIcon mine = new ImageIcon("prototype/src//icons/mine.png");
    static ImageIcon[] numIcons = new ImageIcon[9];

    public static void fillNumIcons(){
        numIcons[0] = null;
        numIcons[1] = new ImageIcon("prototype/src/icons/one.png");
        numIcons[2] = new ImageIcon("prototype/src/icons/two.png");
        numIcons[3] = new ImageIcon("prototype/src/icons/three.png");
        numIcons[4] = new ImageIcon("prototype/src/icons/four.png");
        numIcons[5] = new ImageIcon("prototype/src/icons/five.png");
        numIcons[6] = new ImageIcon("prototype/src/icons/six.png");
        numIcons[7] = new ImageIcon("prototype/src/icons/seven.png");
        numIcons[8] = new ImageIcon("prototype/src/icons/eight.png");
    }
}
