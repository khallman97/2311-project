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
 * the txt files and writing to them
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
		readFile();
	}
	
	
	public void readFile() {
	
		try {
			reader = new Scanner(this.scenario);
			elements = new LinkedList<String>();
			while (reader.hasNextLine()) {
				String line = reader.nextLine();
				elements.add(line);
				
				
				
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
}
