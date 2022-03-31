package src;

import javax.swing.*;

//One-way toggle version of JButton. Ensures that a square can only be clicked once

public class OneWayToggleButton extends JToggleButton.ToggleButtonModel {
    @Override
    public void setSelected(boolean b){
        if(!isSelected())
            super.setSelected(b);
    }
}
