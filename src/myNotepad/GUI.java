package myNotepad;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.undo.UndoManager;
/**
 * This class creates the Graphical User Interface of the notepad.
 * @author miguel munoz
 *
 */
public class GUI implements ActionListener{
    JFrame window;
    //text area components
    JTextArea textArea;
    JScrollPane scrollPane;
    Boolean wordWrapBoolean = false;
    // top menu bar
    JMenuBar menuBar;
    JMenu file, edit, format, color;
    // file menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExIt;
    //format menu
    JMenu menufontSize, menufont;
    JMenuItem iWrap, fontArial,fontComicSMS, fontTNR, fontSize8,fontSize12,fontSize16,fontSize24,fontSize20,fontSize28;
    // color menu
    JMenuItem color1, color2, color3, color4;
    //edit menu
    JMenuItem redo, undo;
    
    //classes needed to perform actions on button press
    Actions actions = new Actions(this);
    Format mformat = new Format(this);
    color mColor = new color(this);
    Edit medit = new Edit(this);
    keys mKeys = new keys(this);
    
    UndoManager um = new UndoManager();
    
    
    /**
     * Constructor
     * Creates the GUI of the notepad.
     */
    public GUI() {
	createWindow();
	createTextArea();
	createMenuBar();
	createFormatMenu();
	createThemeMenu();
	createEditMenu();
	
	//general, default settings
	mformat.selectedFont = "Arial";
	mformat.createFont(14);
	mColor.changeColor("White");
	// to set visibility of the window and its components
	window.setVisible(true);
	window.getContentPane().setBackground(new Color(255, 204, 204));
	textArea.setBackground(new Color(255, 204, 204));
	textArea.setForeground(Color.black);
    }
    /**
     * Create the main window for the notepad.
     */
    public void createWindow() {
	window = new JFrame("Notepad");
	window.setSize(800,600);
	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /**
     * Creates the text area for the Notepad.
     */
    public void createTextArea() {
	textArea = new JTextArea();
	textArea.addKeyListener(mKeys);
	textArea.getDocument().addUndoableEditListener((e)->um.addEdit(e.getEdit()));
	
	scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	scrollPane.setBorder(BorderFactory.createEmptyBorder());
	window.add(scrollPane);
    }
    /**
     * Create the menu bar and create the main buttons of the menu.
     */
    public void createMenuBar() {
	menuBar = new JMenuBar();
	window.setJMenuBar(menuBar);
	
	file = new JMenu("File");
	menuBar.add(file);
	
	edit = new JMenu("Edit");
	menuBar.add(edit);
	
	format = new JMenu("Format");
	menuBar.add(format);
	
	color = new JMenu("Color");
	menuBar.add(color);
	
	fileMenu();
    }
    /**
     * Create the buttons for File menu in menu bar.
     */
    public void fileMenu() {
	iNew = new JMenuItem("New");
	// add the action listener overwritten in this class
	iNew.addActionListener(this); 
	// set action command to then check which action should be
	// performed based on the action command.
	iNew.setActionCommand("New"); 
	file.add(iNew);
	
	iOpen = new JMenuItem("Open");
	iOpen.addActionListener(this);
	iOpen.setActionCommand("Open");
	file.add(iOpen);
	
	iSave = new JMenuItem("Save");
	iSave.addActionListener(this);
	iSave.setActionCommand("Save");
	file.add(iSave);
	
	iSaveAs= new JMenuItem("Save As");
	iSaveAs.addActionListener(this);
	iSaveAs.setActionCommand("Save As");
	file.add(iSaveAs);
	
	iExIt = new JMenuItem("Exit");
	iExIt.addActionListener(this);
	iExIt.setActionCommand("Exit");
	file.add(iExIt);
    }
    /**
     * Create the buttons for the format menu in menu bar.
     */
    public void createFormatMenu() {
	iWrap = new JMenuItem("Word Wrap: off");
	iWrap.addActionListener(this);
	iWrap.setActionCommand("Word Wrap");
	format.add(iWrap);
	
	menufont = new JMenu("Font");
	format.add(menufont);
	
	// creates font type buttons for the fonts menu.
	fontArial = new JMenuItem("Arial");
	fontArial.addActionListener(this);
	fontArial.setActionCommand("Arial");
	menufont.add(fontArial);
	
	fontComicSMS = new JMenuItem("Comic sans MS");
	fontComicSMS.addActionListener(this);
	fontComicSMS.setActionCommand("Comic sans MS");
	menufont.add(fontComicSMS);
	
	fontTNR = new JMenuItem("Times New Roman");
	fontTNR.addActionListener(this);
	fontTNR.setActionCommand("Times New Roman");
	menufont.add(fontTNR);
	
	
	menufontSize = new JMenu("Font size");
	format.add(menufontSize);
	
	// creates buttons for the fontSize menu inside format menu.
	fontSize8 = new JMenuItem("8");
	fontSize8.addActionListener(this);
	fontSize8.setActionCommand("8");
	menufontSize.add(fontSize8);

	fontSize12 = new JMenuItem("12");
	fontSize12.addActionListener(this);
	fontSize12.setActionCommand("12");
	menufontSize.add(fontSize12);
	
	fontSize16 = new JMenuItem("16");
	fontSize16.addActionListener(this);
	fontSize16.setActionCommand("16");
	menufontSize.add(fontSize16);
	
	fontSize20 = new JMenuItem("20");
	fontSize20.addActionListener(this);
	fontSize20.setActionCommand("20");
	menufontSize.add(fontSize20);
	
	fontSize24 = new JMenuItem("24");
	fontSize24.addActionListener(this);
	fontSize24.setActionCommand("24");
	menufontSize.add(fontSize24);
	
	fontSize28 = new JMenuItem("28");
	fontSize28.addActionListener(this);
	fontSize28.setActionCommand("28");
	menufontSize.add(fontSize28);
    }
    /**
     * Create the buttons for theme menu in menu bar.
     */
    public void createThemeMenu() {
	color1 = new JMenuItem("Light");
	color1.addActionListener(this);
	color1.setActionCommand("White");
	color.add(color1);
	
	color2 = new JMenuItem("Grape");
	color2.addActionListener(this);
	color2.setActionCommand("Purple");
	color.add(color2);
	
	color3 = new JMenuItem("Dark");
	color3.addActionListener(this);
	color3.setActionCommand("Black");
	color.add(color3);
	
	color4 = new JMenuItem("Lucian");
	color4.addActionListener(this);
	color4.setActionCommand("Blue");
	color.add(color4);
    }
    /**
     * Create the buttons for Edit menu in menu bar.
     */
    public void createEditMenu() {
	undo = new JMenuItem("Undo");
	undo.addActionListener(this);
	undo.setActionCommand("Undo");
	edit.add(undo);
	
	redo = new JMenuItem("Redo");
	redo.addActionListener(this);
	redo.setActionCommand("Redo");
	edit.add(redo);
    }
    
    /**
     * Perform an action based on the action command set when  button is pressed
     */
        
    @Override
    public void actionPerformed(ActionEvent event) {
	
	String command = event.getActionCommand();
	
	switch (command) {
	// actions for file option
	case "New": 
	    actions.newFile();
	    break;
	case "Open": 
	    actions.open();
	    break;
	case "Save": 
	    actions.save();
	    break;
	case "Save As": 
	    actions.saveAs();
	    break;
	case "Exit": 
	    actions.exit();
	    break;
	// actions for edit option
	case "Undo": 
	    medit.undo();;
	    break;
	case "Redo": 
	    medit.redo();
	    break;
	//actions for format option
	case "Word Wrap": 
	    mformat.wordWrap();
	    break;
	//actions for font type
	case "Arial":
	    mformat.setFont(command);
	    break;
	case "Comic sans MS":
	    mformat.setFont(command);
	    break;
	case "Times New Roman":
	    mformat.setFont(command);
	    break;
	//actions for the font size
	case "8": 
	    mformat.createFont(8);
	    break;
	case "12": 
	    mformat.createFont(12);
	    break;
	case "16": 
	    mformat.createFont(16);
	    break;
	case "20": 
	    mformat.createFont(20);
	    break;
	case "24": 
	    mformat.createFont(24);
	    break;
	case "28":
	    mformat.createFont(28);
	    break;
	// actions for changing the theme
	case "White":
	    mColor.changeColor(command);
	    break;
	case "Purple":
	    mColor.changeColor(command);
	    break;
	case "Black": 
	    mColor.changeColor(command);
	    break;
	case "Blue":
	    mColor.changeColor(command);
	    break;
	default:
	    break;
	}
    }
}