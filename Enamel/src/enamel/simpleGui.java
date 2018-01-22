package enamel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;

public class simpleGui extends JFrame {
	
	private File file;

	JButton bChange ; // reference to the button object

	  // constructor for ButtonFrame
	  simpleGui(String title) 
	  {
	    super( title );                     // invoke the JFrame constructor
	    setLayout( new FlowLayout() );      // set the layout manager
	    
	    setSize(600,600);
	    
	    bChange = new JButton("select file"); // construct a JButton
	    add(bChange);  
	    final JFileChooser fc = new JFileChooser();
	    bChange.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		int returnVal = fc.showOpenDialog(fc);
	    		if(returnVal == JFileChooser.APPROVE_OPTION)   {  
	    			  file = fc.getSelectedFile(); 
	    			  if (file != null){
	    				  setVisible(false);
	    			  }
	    			}
	    	}
	    });
	    
	    
	    // add the button to the JFrame
	    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );   
	  }
	  
	  public File getFile() {
		  return this.file;
	  }
	  
	  

	  
	  
	
	
}

