package prototype.src;

import javax.swing.*;

/**
 * @author Zack Burnley, Matt Kanter, Zack Cherry
 * @version 1.0
 * One-way toggle version of JButton. Ensures that a square can only be clicked once
 */

public class OneWayToggleButton extends JToggleButton.ToggleButtonModel {
    @Override
    /**
     *
     */
    public void setSelected(boolean b){
        if(!isSelected())
            super.setSelected(b);
    }
}
