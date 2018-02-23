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


public class ScenarioCreator  {
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
	private String question;
	private boolean QRunning;
	
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
	
	public  ScenarioCreator(String SENNAME)  {
		this.senName=SENNAME;
		createEmptyDoc();
	}
	/*opens a window to create the name of the screen
	private void popupForName() {
		String name = JOptionPane.showInputDialog("Choose a scenario name");
		if(name == null) {
			cancelButton = true;
		} else {
			this.senName = name;
		}
	}
	*/
		
	/*This creates the new file for the scenario */
	private void createEmptyDoc()  {
		try {
		     file = new File("SavedScenarios/Scenario_"+this.senName+".txt"); 
		     fileName = "Scenario_"+this.senName+".txt";
		      writer = new BufferedWriter(new FileWriter("SavedScenarios/Scenario_"+this.senName+".txt"));
		     
	             boolean fvar = file.createNewFile();
		     if (fvar){
		          //System.out.println("File has been created successfully");
		     }
		     else{
		    	 //JOptionPane.showMessageDialog(null, "Error: File name already exists");
		     }
	    	} catch (IOException e) {
	    		//System.out.println("Exception Occurred:");
		        //e.printStackTrace();
		  }
		   
		
	}
	
	public void save() {
		try {
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean questionRunning() {
		return this.QRunning;
	}
	
	public void QRunning(boolean bol) {
		this.QRunning = bol;
	}

	public String getQuestion() {
		return this.question;
	}
	
	public void setQuestion(String quest) {
		this.question = quest;
	}

	public void questionForString() {
		
		String Question="";
		String cellValue=""; 
		String currentButton=""; 
		boolean soundSelected=false;
		String rightResponse="";
		String wrongResponse="";
		
		QRunning(true);
		
		
			
		
		
		
		/*This makes the frame and questions for 
		 * creating questions
		 */
		
		
		
		
		JFrame testFrame = new JFrame();
		testFrame.setSize(800, 500);
		testFrame.setLayout(new GridLayout(7,0));
		
		JTextField questionDes = new JTextField("Enter what you want your question to ask here:");
		questionDes.setEditable(false);
		testFrame.add(questionDes);
		
		JTextField questionAnswer = new JTextField();
		questionAnswer.setSize(1, 1);
		testFrame.add(questionAnswer);
		
		
		JTextField pinSetQuestion = new JTextField("Enter what you want to display on the braille cells: ");
		pinSetQuestion.setEditable(false);
		testFrame.add(pinSetQuestion);
		
		JTextField cellAnswer = new JTextField();
		cellAnswer.setSize(1, 1);
		testFrame.add(cellAnswer);
		
		JTextField ButtonQuestion = new JTextField("Choose which button will contain the answer");
		ButtonQuestion.setEditable(false);
		testFrame.add(ButtonQuestion);
		
		String[] buttonNum = new String[Button];
		
		for ( int i=0 ; i < Button ; i++) {
			int current = i+1;
			
			buttonNum[i] = Integer.toString(current);
		}
		
		JComboBox buttonList = new JComboBox(buttonNum);
		buttonList.setSelectedItem(0);
		testFrame.add(buttonList);
		
		JTextField soundsQuestion = new JTextField("Do you want to use the built in correct and incorrect sounds? Click The box if you wish to do so");
		soundsQuestion.setEditable(false);
		testFrame.add(soundsQuestion);
		
		JCheckBox soundsTrue = new JCheckBox("Yes");
		testFrame.add(soundsTrue);
		
		JTextField rightAnswerText = new JTextField("Enter a message you wish to say here if the answer is correct.");
		rightAnswerText.setEditable(false);
		testFrame.add(rightAnswerText);
		
		JTextField rightAnswer = new JTextField();
		rightAnswer.setSize(1, 1);
		testFrame.add(rightAnswer);
		
		JTextField wrongQuestion = new JTextField("Enter a message you wish to say here if the answer is wrong.");
		wrongQuestion.setEditable(false);
		testFrame.add(wrongQuestion);
		
		JTextField wrongAnswer = new JTextField();
		wrongAnswer.setSize(1, 1);
		testFrame.add(wrongAnswer);
		
		JButton done = new JButton("finished");
		testFrame.add(done);
		done.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  String Question = questionAnswer.getText();
				  String cellValue = cellAnswer.getText();
				  String currentButton = (String) buttonList.getSelectedItem();
				  boolean soundSelected = soundsTrue.isSelected();
				  String rightResponse = rightAnswer.getText();
				  String wrongResponse = wrongAnswer.getText();
				  
				  setQuestion(Question);
				
					
					try {
						writer.write("\n");
						writer.write("/~pause:1\n");
						writer.write("/~disp-clearAll \n");
						writer.write("/~disp-string:"+cellValue+"\n");
						writer.write(Question+"\n");
						
						for(int i = 0; i < 4 ; i ++) {
							int check = i+1;
							if(Integer.toString(check).equals(currentButton)) {
								writer.write("/~skip-button:"+check+" ONEE \n");
							} else {
								writer.write("/~skip-button:"+check+" TWOO \n");
							}
						}
						writer.write("/~user-input \n");
						writer.write("\n");
						writer.write("/~ONEE\n");
						if (soundSelected==true) {
							writer.write("/~sound:correct.wav \n");
						}
						writer.write(rightResponse+" \n");
						writer.write("/~skip:NEXTT\n");
						writer.write("\n");
						
						writer.write("/~TWOO\n");
						if (soundSelected==true) {
							writer.write("/~sound:wrong.wav \n");
						}
						writer.write(wrongResponse+"\n");
						writer.write("/~skip:NEXTT\n");
						writer.write("\n");
						
						writer.write("/~NEXTT\n");
						
						
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					testFrame.setVisible(false);
					
				    
				  
				  } 
				} );
		
		
		testFrame.setVisible(true);
		
		
	
		
		
	
		
		

	}
	
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
			writer.write(tts+"\n");
			//writer.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tts;
		//display.append("TTS: "+tts+"\n");
	}
			

	
	
	


	
}