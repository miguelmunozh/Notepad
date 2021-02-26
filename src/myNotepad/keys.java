package myNotepad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * This class performs the actions of shortcut keys.
 * @author miguel munoz
 *
 */
public class keys implements KeyListener{
    GUI gui;
    /**
     * Constructor
     * @param gui
     */
    public keys(GUI gui) {
	this.gui = gui;
    }
    @Override
    public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
	    gui.actions.save();
	}
	if (e.isShiftDown() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
	    gui.actions.saveAs();
	}
    }

    @Override
    public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
    }
    	
}
