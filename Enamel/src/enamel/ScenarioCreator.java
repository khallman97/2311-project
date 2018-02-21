package enamel;


import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.accessibility.*;



/*This class creates the scenarios for the application*/


public class ScenarioCreator extends JFrame  {
	/*TO DO FOR MID TERM
	 * Testing cases
	 * Accesbilties functions
	 * edit and test buttons to do something
	 * finish new scenario creator
	 * attepmt to impliment edit
	 * updates our docs
	 * 
	 */
	
	private String senName;
	private String fileName;
	
	private TextArea display;
	
	private Button cellAndButton; 
	private Button questions;
	private Button setBraille;
	private Button addTTS;
	private Button test;
	private Button addPause;
	
	private File file;
	
	private boolean cellAndButtonEntered = false;
	
	private boolean cancelButton;
	
	private BufferedWriter writer;
	
	private int Cell;
	private int Button;
	
	public  ScenarioCreator(String name)  {
		//popupForName();
		//INT();
		//elements();
		this.senName = name;
		createEmptyDoc();
	}
	/*opens a window to create the name of the scen*/
	private void popupForName() {
		String name = JOptionPane.showInputDialog("Choose a scenario name");
		if(name == null) {
			cancelButton = true;
		} else {
			this.senName = name;
		}
	}
		
	/*This creates the new file for the scenario */
	private void createEmptyDoc()  {
		try {
		     file = new File("SavedScenarios/Scenario_"+senName+".txt"); 
		     fileName = "Scenario_"+senName+".txt";
		      writer = new BufferedWriter(new FileWriter("SavedScenarios/Scenario_"+senName+".txt"));
		     
	             boolean fvar = file.createNewFile();
		     if (fvar){
		          //System.out.println("File has been created successfully");
		     }
		     else{
		    	 JOptionPane.showMessageDialog(null, "Error: File name already exists");
		     }
	    	} catch (IOException e) {
	    		//System.out.println("Exception Occurred:");
		        //e.printStackTrace();
		  }
		   
		
	}

	public void INT() {
		setLayout(new FlowLayout());
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		if(cancelButton == true) {
			dispose();
		} else {
			setVisible(true);
		}
		
		addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        if (JOptionPane.showConfirmDialog( 
		            getParent(), "Are you sure to close this window?", "Really Closing?", 
		            JOptionPane.YES_NO_OPTION,
		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		        	try {
						writer.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
		        	dispose();
		            //System.exit(0);
		        }
		    }
		});
	}
	
	//for buttons
	
	public void elements()  {
		//Text Fields
		display = new TextArea(15 , 50);
		display.setEditable(false);
		
		//Buttons
		cellAndButton = new Button("Set cell and button");
		questions = new Button("Add activity");
		addTTS = new Button("Add text to speech");
		test = new Button("Test Scenario");
		addPause = new Button("Add a pause");
		
		
		//action listiners 
		/*
		cellAndButton.addActionListener(this);
		questions.addActionListener(this);
		addTTS.addActionListener(this);
		test.addActionListener(this);
		addPause.addActionListener(this);
		*/
		
		//disable buttons until cell and button is eneted
		enableButtons(false);
		
		//add elements		
		add(display);
		add(cellAndButton);
		add(questions);
		add(addTTS);
		add(addPause);
		add(test);
		
	}
	
	public void enableButtons(boolean bol) {
		questions.setEnabled(bol);
		addTTS.setEnabled(bol);
		test.setEnabled(bol);
		addPause.setEnabled(bol);
	}
	
	/*public void actionPerformed(ActionEvent e) { 
	 
		if(e.getSource() == cellAndButton) {
			
			addCellAndButton();
			
		} else if (e.getSource() == questions) {
			
			/*1. pull up whole new window with all the options for creating buttons.
			 * 
			 
			
			
		} else if (e.getSource() == addTTS) {
			addTTS();
			
		
			
		} else if (e.getSource() == test)  {
			test();
		} else if (e.getSource() == addPause) {
			String duration = JOptionPane.showInputDialog("How long is the pause?");
			addPause(duration);
		}
		
			
		
		
	} */
	
	
	public void test() {
		try {
			writer.flush();
			System.out.println("closed file");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ScenarioParser sp = new ScenarioParser(true);
		sp.setScenarioFileWithFile(file);
	}
	/*
	 * Returns the string back
	 */
	public String addPause() {
		String duration = JOptionPane.showInputDialog("How long is the pause?");
		
		try {
			writer.write("/~pause:"+duration+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return duration;
		//display.append("Pause for: "+dur+" seconds\n"); ignore
	}
	/*..
	 * does not return call the getCell and getButton for values
	 */
	public void addCellAndButton() {
		JTextField cell = new JTextField();
		JTextField button = new JTextField();
		Object[] cAB = {
				"Cell(s):", cell , "Button(s):" , button }; 
		boolean wasNotEntered = true;
		do {
			
		
			int option = JOptionPane.showConfirmDialog(null, cAB , "Enter the number of cells and buttons", JOptionPane.OK_CANCEL_OPTION);
			System.out.println(option);
			
				
			if (option == -1 || option ==2){
				break;
			} else {
				
			
				try {
					
						String cellNum = cell.getText();
						String buttonNum = button.getText();
						Cell = Integer.parseInt(cellNum);
						Button = Integer.parseInt(buttonNum);
						this.cellAndButtonEntered = true;
						enableButtons(true);
						try {
						
							writer.write("Cell "+Cell+"\n");
							writer.write("Button "+Button+"\n");
							//writer.newLine();
						
						
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						//display.append("Number of cells: " +cellNum+"\n");
						//display.append("Number of buttons: "+buttonNum+"\n");
						wasNotEntered = false;
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Error: Please enter valid Integers greater then 0");
				} 
				
					
			}
		}while (wasNotEntered);
				
			
			
	}
	
	public int getCell() {
		return this.Cell;
	}
	public int getButton() {
		return this.Button;
	}
	
	
	

	
	public String addTTS () {
		
	
		String tts="";
		Object[] options = {
				"EnterText ", "Use Voice"
			};
			int response = JOptionPane.showOptionDialog(null, "Choose Input Method", "" ,   JOptionPane.YES_NO_OPTION, 
					JOptionPane.INFORMATION_MESSAGE ,null , options , options[0]);
			//System.out.println(response);
			if (response == 0) {
				tts = JOptionPane.showInputDialog("Enter your text to speech");
				if(tts == null) {
					JOptionPane.showMessageDialog(null, "Error: Please enter text");
				}
				
			} else if (response == 1) {
				JOptionPane.showMessageDialog(null, "not yet implimented");
			} 
				
		
		try {
			writer.write(tts);
			//writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tts;
		//display.append("TTS: "+tts+"\n");
	}
			

	
	
	


	
}