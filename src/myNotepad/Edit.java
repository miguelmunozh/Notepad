package myNotepad;

/**
 * This class performs the actions of of the Edit menu.
 * @author miguel munoz
 *
 */
public class Edit {
    GUI gui;
    /**
     * Constructor
     * @param gui
     */
    public Edit(GUI gui) {
	this.gui = gui;
    }
    /**
     * Calls the undo manager undo method.
     */
    public void undo() {
	gui.um.undo();
    }
    /**
     * Calls the redo manager undo method.
     */
    public void redo() {
	gui.um.redo();
    }
}
