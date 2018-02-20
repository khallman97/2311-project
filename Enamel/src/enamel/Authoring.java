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
import javax.swing.tree.TreeSelectionModel;



public class Authoring extends JFrame implements ActionListener{
	GroupLayout layout = new GroupLayout(getContentPane());
	JFileChooser chooser;JButton addbut;JButton rembut;JButton editbut;
	DefaultListModel<String> opList;JTree opTree;JList<String> Listdisplay;
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
		//TODO improve system
		chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Scenario Files", "txt","wav");
		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		chooser.setCurrentDirectory(new File(System.getProperty("user.dir")+"/FactoryScenarios"));
	}
	
	public void submenuEDIT(String filename) {
		//items needed for menu
		JPanel menuBuild = new JPanel();
		JFrame secWIN = new JFrame();
		secWIN.setContentPane(menuBuild);
		JScrollPane sde = new JScrollPane();
		JScrollPane tde = new JScrollPane();
		opList = new DefaultListModel<>();
		opTree = new JTree();
		Listdisplay = new JList<>(opList);
		addbut = new JButton("Add item");
		rembut = new JButton("Remove item");
		editbut = new JButton("Edit item");
		
		//setup views
		sde.setViewportView(opTree);
		opTree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		tde.setViewportView(Listdisplay);
		//adjust the window
		secWIN.setBounds(100, 100, 600, 600);
		secWIN.setResizable(false);
		secWIN.setTitle("Scenario Editor");
		secWIN.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//some selection code
		rembut.setEnabled(false);rembut.addActionListener(this);
		editbut.setEnabled(false);editbut.addActionListener(this);
		addbut.setEnabled(false);addbut.addActionListener(this);
		Listdisplay.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				rembut.setEnabled(true);
				editbut.setEnabled(true);
			}
		});
		opTree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent e) {
				addbut.setEnabled(true);
			}
		});
		
		//layout all the data nicely
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(menuBuild);
        menuBuild.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(editbut)
                        .addGap(18, 18, 18)
                        .addComponent(rembut))
                    .addComponent(tde, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sde, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addbut)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tde, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(sde, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(editbut)
                        .addComponent(rembut))
                    .addComponent(addbut))
                .addGap(40, 40, 40))
        );
        secWIN.setVisible(true);
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
			//ScenarioCreator sc = new ScenarioCreator();
			String n = JOptionPane.showInputDialog("Please enter a file name:");
			if (!n.isEmpty()) {
				submenuEDIT(n);
			}else {
				output.append("No Filename given");
			}
		}else if(e.getActionCommand() == "Remove item") {
			opList.removeElementAt(Listdisplay.getSelectedIndex());
			Listdisplay.clearSelection();
			rembut.setEnabled(false);
			editbut.setEnabled(false);
		}else if(e.getActionCommand() == "Edit item") {
			Listdisplay.clearSelection();
			editbut.setEnabled(false);
			rembut.setEnabled(false);
		}else if(e.getActionCommand() == "Add item") {
			DefaultMutableTreeNode pick = (DefaultMutableTreeNode) opTree.getLastSelectedPathComponent();
			if (pick.isLeaf()) {
				opList.addElement((String) pick.getUserObject());
			}else {
				output.append("not a vaild option \n");
			}
			opTree.clearSelection();
			addbut.setEnabled(false);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Authoring au = new Authoring();
		au.setVisible(true);
	}

}
