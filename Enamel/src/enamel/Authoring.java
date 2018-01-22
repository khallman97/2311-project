package enamel;

import java.awt.event.*;
import java.io.File;
import java.awt.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.accessibility.*;

public class Authoring extends JFrame implements ActionListener{
	JPanel Panel = new JPanel();
	JButton openButton;
	JFileChooser chooser;
	JTextArea output;
	public Authoring() {
		UI();
		buttons();
		menu();
		fileChooser();
		//test2
	}
	private void UI() {
		getContentPane().add(Panel);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		output = new JTextArea(15, 20);
		output.setDragEnabled(true);
		Panel.add(output);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void buttons() {
		//TODO make buttons
		setTitle("File Chooser app");
		openButton = new JButton("Open");
		openButton.addActionListener(this);
		Panel.add(openButton);
	}
	private void menu() {
		//TODO make menu
		JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem menuItem = new JMenuItem("Exit");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
        file.add(menuItem);
        menuBar.add(file);
        setJMenuBar(menuBar);
	}
	private void fileChooser() {
		chooser = new JFileChooser();
		//FileFilter filter = new FileFilter();
		//chooser.setFileFilter(filter);
	}
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == openButton){
			int rep = chooser.showOpenDialog(Panel);
			if (rep == JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				output.setText("Opening "+file.getName());			
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authoring au = new Authoring();
		au.setVisible(true);
	}

}
