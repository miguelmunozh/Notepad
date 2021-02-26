package myNotepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class performs the actions of of the file menu.
 * @author miguel munoz
 *
 */
public class Actions {
    GUI gui;
    String fileName;
    String fileAddress;
    /**
     * constructor
     * @param gui
     */
    public Actions(GUI gui) {
	this.gui = gui;
    }
    /**
     * Resets the file.
     */
    public void newFile() {
	gui.textArea.setText("");
	gui.window.setTitle("New");
	fileName = null;
	fileAddress = null;
    }
    /**
     * Opens a file and displays its contents on the notepad.
     */
    public void open() {
	FileDialog fDialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
	fDialog.setVisible(true);
	
	//get file information and contents
	if(fDialog.getFile() != null) {
	    fileName = fDialog.getFile();
	    fileAddress = fDialog.getDirectory();
	    gui.window.setName(fileName);
	}
	//with the address of the file to open, read the info
	// of the file and write it to the text area
	
	BufferedReader br = null;
	try {
	    //we need the address to read the file
	     br = new BufferedReader(new FileReader(fileAddress+fileName));
	    String line = "";
	    gui.textArea.setText("");
	    while((line = br.readLine()) != null) {
		gui.textArea.append(line + "\n");
	    }
	    
	} catch (Exception e) {
	    System.out.println(e);
	}finally {
	    try {
		br.close();
	    } catch (Exception e2) {
		System.out.println(e2);
	    }
	}
    }
    /**
     * Saves the content (overrides) the same file.
     */
    public void save() {
	//if its the first time the file is saved (it doesn't exist)
	if(fileName == null) {
	    saveAs();
	}else { // you are working on an existing file, overwrite it
	    FileWriter fw = null;
	    try {
		fw = new FileWriter(fileAddress + fileName);
		fw.write(gui.textArea.getText());
		gui.window.setName(fileName);
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	    }finally {
		try {
		    fw.close();
		} catch (Exception e2) {
		    // TODO: handle exception
		}
	    }
	}
    }
    /**
     * Saves the content in a new file.
     */
    public void saveAs() {
	//opens a window to save the file at a location
	FileDialog fDialog = new FileDialog(gui.window, "Save", FileDialog.SAVE);
	fDialog.setVisible(true);
	
	if (fDialog.getFile() != null) {
	    fileName = fDialog.getFile();
	    fileAddress = fDialog.getDirectory();
	    gui.window.setName(fileName);
	}
	FileWriter fw = null;
	try {
	    fw = new FileWriter(fileAddress + fileName);
	    fw.write(gui.textArea.getText());
	} catch (Exception e) {
	    System.out.println(e);
	}finally {
	    try {
		fw.close();
	    } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
    /**
     * Closes the notepad.
     */
    public void exit() {
	System.exit(0);
    }
}
