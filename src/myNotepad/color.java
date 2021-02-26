package myNotepad;

import java.awt.Color;

/**
 * This class performs the actions of of the theme menu.
 * @author miguel munoz
 *
 */
public class color {
    GUI gui;
    /**
     * constructor
     * @param gui
     */
    public color(GUI gui) {
	this.gui = gui;
    }
    /**
     * changes the color of the notepad.
     * @param color
     */
    public void changeColor(String color) {
	
	switch (color) {
	case "White": {
	    gui.window.getContentPane().setBackground(Color.white);
	    gui.textArea.setBackground(Color.white);
	    gui.textArea.setForeground(Color.black);
	    break;
	}
	case "Purple": {
	    gui.window.getContentPane().setBackground(new Color(209, 179, 255));
	    gui.textArea.setBackground(new Color(209, 179, 255));
	    gui.textArea.setForeground(Color.black);
	    break;
	}
	case "Black": {
	    gui.window.getContentPane().setBackground(Color.black);
	    gui.textArea.setBackground(Color.black);
	    gui.textArea.setForeground(Color.white); // text color
	    break;
	}
	case "Blue": {
	    gui.window.getContentPane().setBackground(new Color(8,186,186));
	    gui.textArea.setBackground(new Color(8,186,186));
	    gui.textArea.setForeground(Color.white); // text color
	    break;
	}
	default:
	    break;
	}
    }
}
