package enamel;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.accessibility.*;

public class Authoring extends JFrame{
	JPanel Panel = new JPanel();
	public Authoring() {
		UI();
		buttons();
		menu();
		fileChooser();
	}
	private void UI() {
		getContentPane().add(Panel);
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void buttons() {
		//TODO make buttons
		setTitle("File Chooser app");
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
		JFileChooser chooser = new JFileChooser();
		chooser.setBounds(0, 75, 500, 300);
		Panel.add(chooser);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authoring au = new Authoring();
		au.setVisible(true);
	}

}
