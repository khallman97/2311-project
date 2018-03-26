package enamel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * this class takes control over everything for editing 
 * the "txt" files and writing to them
 *
 * @author kyleh
 *
 */
public class Editor {
	
	private File scenario;
	private Scanner reader;
	private List<String> elements;
	private List<String> toWrite;
	
	public Editor(File fileName) {
		this.scenario = fileName;
		try {
			this.reader  = new Scanner(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/** 
	 * Converts the current lines of the list
	 * to what we want the user to see
	 */
	public void parseToApp(){
		
		elements = new LinkedList<String>();
		
		while(reader.hasNextLine()) {
			
			String currentLine = reader.nextLine();
			
			
			//Check for skip
			if (currentLine.substring(0, 7).equals("/~skip:")) {
				String skipTo = currentLine.substring(7);
				
				//This line change depending on layout
				currentLine = "Program will skip to"+skipTo;
				elements.add(currentLine);
				
			}
			
			//Check for sound
			else if (currentLine.substring(0, 8).equals("/~sound:")) {
				String pauseDur = currentLine.substring(8);
				currentLine = "Playing sound: "+pauseDur;
				elements.add(currentLine);
			}
			
			// Check for pause
			else if (currentLine.substring(0, 8).equals("/~pause:")) {
				String pauseDur = currentLine.substring(8);
				currentLine = "Pause for "+pauseDur;
				elements.add(currentLine);
			}
			
			// Check for repeat button
			else if (currentLine.substring(0, 16).equals("/~repeat-button:")) {
				String repeatBut = currentLine.substring(16);
				currentLine = "Repeat button set to "+repeatBut;
				elements.add(currentLine);
			}
			
			//Check for repeat ***Need to check up on repeat
			else if (currentLine.substring(0, 8).equals("/~repeat")) {
				
				currentLine = "Repeating";
				elements.add(currentLine);
			}
			
			//Check for button reset
			else if (currentLine.substring(0, 15).equals("/~reset-buttons")) {
				currentLine = "Resetting buttons";
				elements.add(currentLine);
			}
			
			//Checks for the button that the skip is set too
			else if (currentLine.substring(0, 14).equals("/~skip-button:")) {
				String skipBut = currentLine.substring(14);
				currentLine = "Answer set to: "+skipBut+" Button";
				elements.add(currentLine);
			}
			
			//Checks for when display is cleared
			else if (currentLine.substring(0, 15).equals("/~disp-clearAll")) {
				currentLine = "Clearning cells";
				elements.add(currentLine);
			}
			
			// Checks for what pins are to be diplayed
			else if (currentLine.substring(0, 17).equals("/~disp-cell-pins:")) {
				String pins = currentLine.substring(17);
				currentLine = "Displaying pins "+pins;
				elements.add(currentLine);
			}
			
			// Checks for the string that is being displayed
			else if (currentLine.substring(0, 14).equals("/~disp-string:")) {
				String st = currentLine.substring(14);
				currentLine = "Displaying the string "+st;
				elements.add(currentLine);
			}
			
			// Checks for a character 
			else if (currentLine.substring(0, 17).equals("/~disp-cell-char:")) {
				String charact = currentLine.substring(17);
				currentLine = "Displaying the char "+charact;
				elements.add(currentLine);
			}
			
			// Checks which pins are to be raised
			else if (currentLine.substring(0, 18).equals("/~disp-cell-raise:")) {
				String pins = currentLine.substring(18);
				currentLine = "Displaying the pins: "+pins;
				elements.add(currentLine);
			}
			
			// Check whichs pins are to be lowered
			else if (currentLine.substring(0, 18).equals("/~disp-cell-lower:")) {
				String lowered = currentLine.substring(18);
				currentLine = "The following pins are lowered "+lowered;
				elements.add(currentLine);
			}
			
			// Pharases to clear cells
			//Clears selected cells
			else if (currentLine.substring(0, 18).equals("/~disp-cell-clear:")) {
				String cleared = currentLine.substring(18);
				currentLine = "Pins "+cleared+" are to be lowered";
				elements.add(currentLine);
			} 
			
		    //Lowers all pins
			else if (currentLine.substring(0, 21).equals("/~disp-cell-lowerPins")) {
				currentLine = "Lowered all pins";
				elements.add(currentLine);
			}
			
			// Check for user input
			else if (currentLine.substring(0, 12).equals("/~user-input")) {
				currentLine = "Wait for answer";
				elements.add(currentLine);
			}
			
			//Check for text to speach
			else {
				currentLine = "TTS: "+currentLine;
				elements.add(currentLine);
			}
			
			
		}
		
		
	
		
	}
	
	public void parseToFileFormat() {
		
		toWrite = new LinkedList<String>();
		
		for ( int i = 0; i <= elements.size(); i++) {
			
			
			String currentLine = elements.get(i);
			
			
			
			//Check for skip
			if (currentLine.substring(0, 20).equals("Program will skip to")) {
				String skipTo = currentLine.substring(20);
				currentLine = "/~skip:"+skipTo;
				toWrite.add(currentLine);
				
			}
			
			//Check for sound
			else if (currentLine.substring(0, 15).equals("Playing sound: ")) {
				String sound = currentLine.substring(15);
				currentLine = "/~sound:"+sound;
				toWrite.add(currentLine);
			}
			
			// Check for pause
			else if (currentLine.substring(0, 10).equals("Pause for ")) {
				String pauseDur = currentLine.substring(10);
				currentLine = "/~pause:"+pauseDur;
				toWrite.add(currentLine);
			}
			
			//*********************************************************************//
			
			// Check for repeat button
			else if (currentLine.substring(0, 16).equals("/~repeat-button:")) {
				String repeatBut = currentLine.substring(16);
				currentLine = "Repeat button set to "+repeatBut;
				elements.add(currentLine);
			}
			
			//Check for repeat ***Need to check up on repeat
			else if (currentLine.substring(0, 8).equals("/~repeat")) {
				
				currentLine = "Repeating";
				elements.add(currentLine);
			}
			
			//Check for button reset
			else if (currentLine.substring(0, 15).equals("/~reset-buttons")) {
				currentLine = "Resetting buttons";
				elements.add(currentLine);
			}
			
			//Checks for the button that the skip is set too
			else if (currentLine.substring(0, 14).equals("/~skip-button:")) {
				String skipBut = currentLine.substring(14);
				currentLine = "Answer set to: "+skipBut+" Button";
				elements.add(currentLine);
			}
			
			//Checks for when display is cleared
			else if (currentLine.substring(0, 15).equals("/~disp-clearAll")) {
				currentLine = "Clearning cells";
				elements.add(currentLine);
			}
			
			// Checks for what pins are to be diplayed
			else if (currentLine.substring(0, 17).equals("/~disp-cell-pins:")) {
				String pins = currentLine.substring(17);
				currentLine = "Displaying pins "+pins;
				elements.add(currentLine);
			}
			
			// Checks for the string that is being displayed
			else if (currentLine.substring(0, 14).equals("/~disp-string:")) {
				String st = currentLine.substring(14);
				currentLine = "Displaying the string "+st;
				elements.add(currentLine);
			}
			
			// Checks for a character 
			else if (currentLine.substring(0, 17).equals("/~disp-cell-char:")) {
				String charact = currentLine.substring(17);
				currentLine = "Displaying the char "+charact;
				elements.add(currentLine);
			}
			
			// Checks which pins are to be raised
			else if (currentLine.substring(0, 18).equals("/~disp-cell-raise:")) {
				String pins = currentLine.substring(18);
				currentLine = "Displaying the pins: "+pins;
				elements.add(currentLine);
			}
			
			// Check whichs pins are to be lowered
			else if (currentLine.substring(0, 18).equals("/~disp-cell-lower:")) {
				String lowered = currentLine.substring(18);
				currentLine = "The following pins are lowered "+lowered;
				elements.add(currentLine);
			}
			
			// Pharases to clear cells
			//Clears selected cells
			else if (currentLine.substring(0, 18).equals("/~disp-cell-clear:")) {
				String cleared = currentLine.substring(18);
				currentLine = "Pins "+cleared+" are to be lowered";
				elements.add(currentLine);
			} 
			
		    //Lowers all pins
			else if (currentLine.substring(0, 21).equals("/~disp-cell-lowerPins")) {
				currentLine = "Lowered all pins";
				elements.add(currentLine);
			}
			
			// Check for user input
			else if (currentLine.substring(0, 12).equals("/~user-input")) {
				currentLine = "Wait for answer";
				elements.add(currentLine);
			}
			
			//Check for text to speach
			else {
				currentLine = "TTS: "+currentLine;
				elements.add(currentLine);
			}
		}
		
	}
	
	
}
