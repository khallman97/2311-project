package enamel;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * The goal of this class is to get the name of the file created, 
 * the number of cells and buttons and then save the file.
 */
public class InitialScenarioCreator extends JFrame implements ActionListener  {

	
	private JFrame frame;
	private JPanel p, pi;
	private JButton ok, close;
	private JTextField name, cell, button;
	
	private Scanner reader;
	private BufferedWriter writer;
	
	public InitialScenarioCreator() {
		Int();
		
	}
	
	/* Initlize the frame and compontents */
	
	private void Int() {
		frame = new JFrame("New Scenario");
		
		p = new JPanel(new FlowLayout());
		
		ok = new JButton("Save and continue");
		ok.addActionListener(this);
		
		close = new JButton("Exit");
		close.addActionListener(this);
		
		name = new JTextField(20);
		name.setPreferredSize( new Dimension( 200, 24 ) );
		TextPrompt nameP = new TextPrompt("Enter the scenario name" , name);
		
		cell = new JTextField(20);
		cell.setPreferredSize( new Dimension( 200, 24 ) );
		TextPrompt cellP = new TextPrompt("Enter the number of cells" , cell);
		
		button = new JTextField(20);
		button.setPreferredSize( new Dimension( 200, 24 ) );
		TextPrompt buttonP = new TextPrompt("Enter the number of buttons" , button);
		
		
		p.add(name);
		p.add(cell);
		p.add(button);
		
		p.add(ok);
		p.add(close);
		
		frame.add(p);
		
		frame.setSize(300,200 );
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0);
		String arg = arg0.getActionCommand();
		//System.out.println(arg);
		
		if (arg == "Save and continue") {
			String fileName = name.getText().toString();
			String numOfCells = cell.getText().toString();
			String numOfButtons = button.getText().toString();
			File newFile = new File(System.getProperty("user.dir")+"/SavedScenarios/"+fileName+".txt");
			
			try {
				this.writer = new BufferedWriter(new FileWriter(newFile));
				writer.write("Cell " + numOfCells+"\n");
				writer.write("Button  " + numOfButtons+"\n");
				writer.flush();
				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			frame.dispose();
			
		  
		} else if (arg == "Exit") {
			int closeFrame = 0;
			String[] buttons = { "Yes", "No"};    
			int returnValue = JOptionPane.showOptionDialog(null, "Your file will not save. Do you wish to continue?","Exit" ,
			        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
			
			if (returnValue == 0) {
				closeFrame = 1;
			} else if (returnValue == 1) {
				//does nothing
			}
		if (closeFrame == 1) {
			frame.dispose();
		}
		}
	}

	public static void main(String[]args) {
		InitialScenarioCreator isc = new InitialScenarioCreator();
	}
	
}
