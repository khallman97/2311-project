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
	
	public Editor(File fileName) {
		this.scenario = fileName;
		try {
			this.reader  = new Scanner(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readFile();
	}
	
	
	public void readFile() {
	
		try {
			
			elements = new LinkedList<String>();
			
			/**
			 * Add the current lines to the list
			 */
			
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				elements.add(line);
				
				
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/** 
	 * Converts the current lines of the list
	 * to what we want the user to see
	 */
	public void parser(){
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
				currentLine = "Pause for "+pauseDur;
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
			// The key phrase to assign a button to skip to another part of the
			// scenario.
			else if (currentLine.substring(0, 14).equals("/~skip-button:")) {
				skipButton(fileLine.substring(14));
			}
			// The key phrase to clear the display of all of the braille cells.
			else if (currentLine.substring(0, 15).equals("/~disp-clearAll")) {
				player.clearAllCells();
			}
			// The key phrase to set a Braille cell to a string.
			else if (currentLine.substring(0, 17).equals("/~disp-cell-pins:")) {
				dispCellPins(fileLine.substring(17));
			}
			// The key phrase to represent a string in Braille.
			else if (currentLine.substring(0, 14).equals("/~disp-string:")) {
				player.displayString(fileLine.substring(14));
			}
			// The key phrase to change the cell to represent a character in
			// Braille.
			else if (currentLine.substring(0, 17).equals("/~disp-cell-char:")) {
				dispCellChar(fileLine.substring(17));
			}
			// The key phrase to raise a pin of the specified Braille cell.
			else if (currentLine.substring(0, 18).equals("/~disp-cell-raise:")) {
				dispCellRaise(fileLine.substring(18));
			}
			// The key phrase to lower a pin of the specified Braille cell.
			else if (currentLine.substring(0, 18).equals("/~disp-cell-lower:")) {
				dispCellLower(fileLine.substring(18));
			}
			// The key phrase to clear a Braille cell.
			else if (currentLine.substring(0, 18).equals("/~disp-cell-clear:")) {
				dispCellClear(fileLine.substring(18));
			} else if (currentLine.substring(0, 21).equals("/~disp-cell-lowerPins")) {
				dispCellRaise("0");
			}
			// The key phrase to wait for the program to receive a user's input.
			else if (currentLine.substring(0, 12).equals("/~user-input")) {
				userInput = true;
			}
			// Anything other than the specified commands above, is to be
			// interpreted as text that
			// will be spoken for the user to hear.
			else {
				speak(fileLine);
			}
			
			
		}
		
		
		
		
	}
	
	
}
