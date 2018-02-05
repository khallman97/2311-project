package enamel;

import java.awt.event.*;
import java.io.File;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.accessibility.*;

public class Authoring extends JFrame implements ActionListener{
	GroupLayout layout = new GroupLayout(getContentPane());
	JFileChooser chooser;
	JButton openButton = new JButton("Open");
	JButton EditButton = new JButton("Edit");
	JButton testButton = new JButton("Test");
	JButton exitButton = new JButton("Exit");
	JButton newButton = new JButton("New");
	JTextArea output = new JTextArea();
	JScrollPane scr = new JScrollPane();
	
	public Authoring() {
		UI();
		buttons();
		menu();
		fileChooser();
		pack();
	}
	private void UI() {
		getContentPane().setLayout(layout);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
	}
	private void buttons() {
		//TODO make buttons
		setTitle("File Chooser app");
		output.setColumns(20);
		output.setRows(5);
		scr.setViewportView(output);
		layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(scr, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
	                .addGap(44, 44, 44)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                    .addComponent(testButton, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
	                    .addComponent(openButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(EditButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(newButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                    .addComponent(exitButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	                .addGap(137, 137, 137))
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addGap(63, 63, 63)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                    .addComponent(scr)
	                    .addGroup(layout.createSequentialGroup()
	                    	.addComponent(newButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
		                     .addGap(18, 18, 18)
	                    	.addComponent(openButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(EditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(testButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
	                        .addGap(18, 18, 18)
	                        .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap(95, Short.MAX_VALUE))
	        );

	        pack();
		
		openButton.addActionListener(this);
		EditButton.addActionListener(this);
		testButton.addActionListener(this);
		exitButton.addActionListener(this);
		newButton.addActionListener(this);
	}
	private void menu() {
		//TODO make menu
		JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenuItem editItem = new JMenuItem("Edit");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem runItem = new JMenuItem("Test");
        JMenuItem newItem = new JMenuItem("New");
        
        exitItem.addActionListener(this);
        openItem.addActionListener(this);
        runItem.addActionListener(this);
        editItem.addActionListener(this);
        newItem.addActionListener(this);
        
        file.add(openItem);file.add(editItem);file.add(runItem);file.add(exitItem);file.add(newItem);
        menuBar.add(file);
        setJMenuBar(menuBar);
	}
	private void fileChooser() {
		chooser = new JFileChooser();
		//FileFilter filter = new FileFilter();
		//chooser.setFileFilter(filter);
	}
	public void actionPerformed(ActionEvent e){
		output.append("You Clicked: "+e.getActionCommand()+"\n");
		if (e.getActionCommand() == "Open"){
			int rep = chooser.showOpenDialog(getContentPane());
			if (rep == JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				output.append("Opening "+file.getName()+"\n");
			}
		}else if(e.getActionCommand() == "Exit") {
			System.exit(0);
		}else if(e.getActionCommand() == "Edit") {
			output.append("Hasn't been built yet \n");
		}else if(e.getActionCommand() == "Test") {
			output.append("Hasn't been built yet \n");
		}else if(e.getActionCommand() == "New") {
			output.append("works");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authoring au = new Authoring();
		au.setVisible(true);
	}

}
