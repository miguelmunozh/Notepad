package myNotepad;

import java.awt.Font;

/**
 * this class performs the actions of the format menu.
 * @author miguel munoz
 *
 */
public class Format {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;
    /**
     * Constructor
     * @param gui
     */
    public Format(GUI gui) {
	this.gui = gui;
    }
    /**
     * Makes the text in text area to wrap if it goes out of the 
     * scope of the window.
     */
    public void wordWrap() {
	if(gui.wordWrapBoolean == false) {
	    gui.wordWrapBoolean = true;
	    gui.textArea.setLineWrap(true);
	    gui.textArea.setWrapStyleWord(true);
	    gui.iWrap.setText("Word Wrap: On");
	}else {
	    gui.wordWrapBoolean = false;
	    gui.textArea.setLineWrap(false);
	    gui.textArea.setWrapStyleWord(false);
	    gui.iWrap.setText("Word Wrap: Off");
	}
    }
    /**
     * Creates a font with the specified size.
     * @param fontSize
     */
    public void createFont(int fontSize) {
	arial = new Font("Arial", Font.PLAIN, fontSize);
	comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
	timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
	
	setFont(selectedFont);
    }
    /**
     * Sets the font for the text area.
     * @param font
     */
    public void setFont(String font) {
	selectedFont = font;
	switch (font) {
	case "Arial": {
	    gui.textArea.setFont(arial);
	    break;
	}
	case "Comic sans MS": {
	    gui.textArea.setFont(comicSansMS);
	    break;
	}
	case "Times New Roman": {
	    gui.textArea.setFont(timesNewRoman);
	    break;
	}
	default:
	    throw new IllegalArgumentException("Unexpected value: " + font);
	}
    }
    
    
}
