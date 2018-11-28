package enamel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.UIManager;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;



public class Authoring extends JFrame implements ActionListener{
	GroupLayout layout = new GroupLayout(getContentPane());
	JFileChooser chooser;JButton addbut;JButton rembut;JButton editbut;JButton savebut;JButton testbut;
	DefaultListModel<String> opList;JTree opTree;JList<String> Listdisplay;
	ScenarioCreator sc;
	ImageIcon exit = new ImageIcon("Pictures/exit.png");
	ImageIcon edit = new ImageIcon("Pictures/edit.png");
	ImageIcon open = new ImageIcon("Pictures/open.png");
	ImageIcon run = new ImageIcon("Pictures/start.png");
	ImageIcon NEW = new ImageIcon("Pictures/new.png");
			
	JButton openButton = new JButton("Open",open);
	JButton EditButton = new JButton("Edit",edit);
	JButton testButton = new JButton("Test",run);
	JButton exitButton = new JButton("Exit",exit);
	JButton newButton = new JButton("New",NEW);
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

		Font f1 = new Font("Helvetica", Font.BOLD, 20);
		Font f2 = new Font("Helvetica", Font.PLAIN, 20);
		
		UIManager.put("Button.background", Color.gray);
		UIManager.put("Button.foreground", Color.black);		
		UIManager.put("Button.font", f1);
		UIManager.put("Menu.font", f2);
		UIManager.put("ToolTip.font", f2);
		
		openButton.setFont(f1);
		EditButton.setFont(f1);
		testButton.setFont(f1);
		newButton.setFont(f1);
		exitButton.setFont(f1);
		
		openButton.setBackground(Color.CYAN);
		EditButton.setBackground(Color.CYAN);
		testButton.setBackground(Color.CYAN);
		newButton.setBackground(Color.CYAN);
		exitButton.setBackground(Color.CYAN);
}
	private void buttons() {	
		setTitle("Authoring App");
		output.setColumns(20);
		output.setRows(5);			
		output.setEditable(false);		// Bug fix, to ensure user is not able to edit the text field
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
		ImageIcon exit = new ImageIcon("Pictures/exit.png");
		ImageIcon edit = new ImageIcon("Pictures/edit.png");
		ImageIcon open = new ImageIcon("Pictures/open.png");
		ImageIcon run = new ImageIcon("Pictures/start.png");
		ImageIcon NEW = new ImageIcon("Pictures/new.png");
		
		JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit",exit);
        JMenuItem editItem = new JMenuItem("Edit",edit);
        JMenuItem openItem = new JMenuItem("Open",open);
        JMenuItem runItem = new JMenuItem("Test",run);
        JMenuItem newItem = new JMenuItem("New",NEW);
        
		Font f2 = new Font("Helvetica", Font.PLAIN, 20);
    	exitItem.setFont(f2);
    	editItem.setFont(f2);
    	openItem.setFont(f2);
    	runItem.setFont(f2);
    	newItem.setFont(f2);
     
//      exitItem.setPreferredSize(new Dimension(200, exitItem.getPreferredSize().height));
        exitItem.setPreferredSize(new Dimension(200, 50));
        editItem.setPreferredSize(new Dimension(200, 50));
        openItem.setPreferredSize(new Dimension(200, 50));
        runItem.setPreferredSize(new Dimension(200, 50));
        newItem.setPreferredSize(new Dimension(200, 50));
        
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		editItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		openItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		runItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		newItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        exitItem.addActionListener(this);
        openItem.addActionListener(this);
        runItem.addActionListener(this);
        editItem.addActionListener(this);
        newItem.addActionListener(this);
        
        file.add(openItem);file.add(newItem);file.add(editItem);file.add(runItem);file.add(exitItem);
        file.setToolTipText("Alt+F");
		file.setMnemonic(KeyEvent.VK_F);
        menuBar.add(file);
        setJMenuBar(menuBar);
	}
	private void fileChooser() {
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Scenario Files", "txt","wav");
		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")+"/SavedScenarios"));
	}
	
	public void actionPerformed(ActionEvent e){
		//output.append("You Clicked: "+e.getActionCommand()+"\n");
		if (e.getActionCommand() == "Open"){
			int rep = chooser.showOpenDialog(getContentPane());
			if (rep == JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				output.append("Opening "+file.getName()+"\n");
				sc = new ScenarioCreator(file, false);
				//InitialScenarioCreator isc = new InitialScenarioCreator();
			}
		}else if(e.getActionCommand() == "Exit") {
			System.exit(0);
		}else if(e.getActionCommand() == "Edit") {
			int rep = chooser.showOpenDialog(getContentPane());
			if (rep == JFileChooser.APPROVE_OPTION){
				File file = chooser.getSelectedFile();
				output.append("Opening "+file.getName()+"\n");
				sc = new ScenarioCreator(file,false);
			}
		}else if(e.getActionCommand() == "Test") {
			File file = null;
			int rep = chooser.showOpenDialog(getContentPane());
			if (rep == JFileChooser.APPROVE_OPTION){
				file = chooser.getSelectedFile();
				output.append("Opening "+file.getName()+"\n");
			}
			String filepath = file.getAbsolutePath();
			//System.out.println(filepath);
			ScenarioParser sp = new ScenarioParser(true);
			sp.setScenarioFile(filepath);
		}else if(e.getActionCommand() == "New") {
			
			sc = new ScenarioCreator(true);
			
		}
	}
	public static void main(String[] args) {
		Authoring au = new Authoring();
		au.setVisible(true);
	}

}
