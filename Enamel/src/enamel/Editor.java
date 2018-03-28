package enamel;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * this class takes control over everything for editing the "txt" files and
 * writing to them
 * 
 * 
 * 
 * Finish this Check audio player make it work
 * 
 *
 * @author kyleh
 *
 */
public class Editor {

	public File file;
	private Scanner reader;
	private BufferedWriter writer;

	private List<String> elements;
	private List<String> toWrite;

	public Editor(File fileName) {
		this.file = fileName;
		try {
			this.reader = new Scanner(fileName);

			parseToApp();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean isUpperCase(String s) {
		for (int i = 0; i < s.length(); i++) {
			if (!Character.isUpperCase(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Converts the current lines of the list to what we want the user to see
	 */
	public void parseToApp() {

		elements = new LinkedList<String>();

		while (reader.hasNextLine()) {

			String currentLine = reader.nextLine();

		
			if (currentLine.trim().isEmpty()) {

				elements.add(currentLine);

			}

			else if (isUpperCase(currentLine.substring(2, 3))) {

				currentLine = "Skip button called: " + currentLine.substring(2);
				elements.add(currentLine);
			}

			
			else if (!currentLine.contains("/~") && !currentLine.contains("Cell") && !currentLine.contains("Button")) {

				elements.add("TTS: " + currentLine);
			}

			else if (currentLine.substring(0, 4).equals("Cell")) {
				String numOfCells = currentLine.substring(5);
				currentLine = "Cells " + numOfCells;
				elements.add(currentLine);

			}

			else if (currentLine.substring(0, 6).equals("Button")) {
				String numOfCells = currentLine.substring(7);
				currentLine = "Buttons " + numOfCells;
				elements.add(currentLine);

			} else if (currentLine.substring(0, 7).equals("/~skip:")) {
				String skipTo = currentLine.substring(7);
				System.out.println("added skip");
				
				currentLine = "Program will skip to" + skipTo;
				elements.add(currentLine);

			}

			
			else if (currentLine.substring(0, 8).equals("/~sound:")) {
				String pauseDur = currentLine.substring(8);
				currentLine = "Playing sound: " + pauseDur;
				elements.add(currentLine);
			}

		
			else if (currentLine.substring(0, 8).equals("/~pause:")) {
				String pauseDur = currentLine.substring(8);
				currentLine = "Pause for " + pauseDur;
				elements.add(currentLine);
			}

			
			else if (currentLine.substring(0, 8).equals("/~repeat")) {

				currentLine = "Repeating";
				elements.add(currentLine);
			}

		
			else if (currentLine.substring(0, 12).equals("/~user-input")) {
				currentLine = "Wait for answer";
				elements.add(currentLine);
			}

			
			else if (currentLine.substring(0, 14).equals("/~disp-string:")) {
				String st = currentLine.substring(14);
				currentLine = "Displaying the string " + st;
				elements.add(currentLine);
			}

			
			else if (currentLine.substring(0, 14).equals("/~skip-button:")) {
				String skipBut = currentLine.substring(14);
				currentLine = "Answer set to: " + skipBut + " Button";
				elements.add(currentLine);
			}

			
			else if (currentLine.substring(0, 15).equals("/~reset-buttons")) {
				currentLine = "Resetting buttons";
				elements.add(currentLine);
			}

		
			else if (currentLine.substring(0, 15).equals("/~disp-clearAll")) {
				currentLine = "Clearning cells";
				elements.add(currentLine);
			}

			
			else if (currentLine.substring(0, 16).equals("/~repeat-button:")) {
				String repeatBut = currentLine.substring(16);
				currentLine = "Repeat button set to " + repeatBut;
				elements.add(currentLine);
			}

			
			else if (currentLine.substring(0, 17).equals("/~disp-cell-pins:")) {
				String pins = currentLine.substring(17);
				currentLine = "Displaying pins " + pins;
				elements.add(currentLine);
			}

		
			else if (currentLine.substring(0, 17).equals("/~disp-cell-char:")) {
				String charact = currentLine.substring(17);
				currentLine = "Displaying the char " + charact;
				elements.add(currentLine);
			}

			
			else if (currentLine.substring(0, 18).equals("/~disp-cell-raise:")) {
				String pins = currentLine.substring(18);
				currentLine = "Displaying the pins: " + pins;
				elements.add(currentLine);
			}

			else if (currentLine.substring(0, 18).equals("/~disp-cell-lower:")) {
				String lowered = currentLine.substring(18);
				currentLine = "The following pins are lowered " + lowered;
				elements.add(currentLine);
			}

			else if (currentLine.substring(0, 18).equals("/~disp-cell-clear:")) {
				String cleared = currentLine.substring(18);
				currentLine = "The following cells are cleared: " + cleared;
				elements.add(currentLine);
			}

			else if (currentLine.substring(0, 21).equals("/~disp-cell-lowerPins")) {
				currentLine = "Lowered all pins";
				elements.add(currentLine);
			}

			else {
				currentLine = "TTS: " + currentLine;
				elements.add(currentLine);
			}

		}
	}

	/*
	 * Edits an element
	 * 
	 */
	public void edit(int index, String replace) {
		elements.set(index, replace);
	}

	/*
	 * Converts the current list from the "english" to what needs to be read by the
	 * simulator from there it
	 * 
	 */
	public void parseToFileFormat() {

		toWrite = new LinkedList<String>();

		for (int i = 0; i < elements.size(); i++) {

			String currentLine = elements.get(i);

			if (currentLine.trim().isEmpty()) {
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 5).equals("TTS: ")) {
				currentLine = currentLine.substring(5);
				toWrite.add(currentLine);
			} else if (currentLine.substring(0, 6).equals("Cells ")) {
				currentLine = "Cell " + currentLine.substring(5);
				toWrite.add(currentLine);
			} else if (currentLine.substring(0, 8).equals("Buttons ")) {
				currentLine = "Cell " + currentLine.substring(8);
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 10).equals("Pause for ")) {
				String pauseDur = currentLine.substring(10);
				currentLine = "/~pause:" + pauseDur;
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 10).equals("Repeating")) {

				currentLine = "/~repeat";
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 15).equals("Playing sound: ")) {
				String sound = currentLine.substring(15);
				currentLine = "/~sound:" + sound;
				toWrite.add(currentLine);
			} else if (currentLine.substring(0, 15).equals("Answer set to: ")) {
				String skipBut = currentLine.substring(15);
				currentLine = "/~skip-button:" + skipBut;
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 15).equals("Clearning cells")) {
				currentLine = "/~disp-clearAll";
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 15).equals("Wait for answer")) {
				currentLine = "/~user-input";
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 16).equals("Displaying pins ")) {
				String pins = currentLine.substring(16);
				currentLine = "/~disp-cell-pins:" + pins;
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 17).equals("Resetting buttons")) {
				currentLine = "/~reset-buttons";
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 17).equals("Lowered all pins")) {
				currentLine = "/~disp-cell-lowerPins";
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 20).equals("Skip button called: ")) {

				currentLine = "/~" + currentLine.substring(20);
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 20).equals("Program will skip to")) {
				String skipTo = currentLine.substring(20);
				currentLine = "/~skip:" + skipTo;
				toWrite.add(currentLine);

			}

			else if (currentLine.substring(0, 20).equals("Displaying the char ")) {
				String charact = currentLine.substring(20);
				currentLine = "/~disp-cell-char:" + charact;
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 20).equals("Displaying the pins ")) {
				String pins = currentLine.substring(20);
				currentLine = "/~disp-cell-raise:" + pins;
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 21).equals("Repeat button set to ")) {
				String repeatBut = currentLine.substring(16);
				currentLine = "/~repeat-button:" + repeatBut;
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 22).equals("Displaying the string ")) {
				String st = currentLine.substring(22);
				currentLine = "/~disp-string:" + st;
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 32).equals("The following pins are lowered")) {
				String lowered = currentLine.substring(32);
				currentLine = "/~disp-cell-lower:" + lowered;
				toWrite.add(currentLine);
			}

			else if (currentLine.substring(0, 34).equals("The following cells are cleared:")) {
				String cleared = currentLine.substring(34);
				currentLine = "/~disp-cell-clear:" + cleared;

				toWrite.add(currentLine);
			}

		}
		try {
			this.writer = new BufferedWriter(new FileWriter(file));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (int i = 0; i < toWrite.size(); i++) {
			try {

				writer.write(toWrite.get(i) + "\n");
				System.out.println(toWrite.get(i));

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
