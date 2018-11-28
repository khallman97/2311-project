package enamel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
/**
 * Scenario Creator Class
 * (GUI for Scenario Creator) 
 *	- Provides one single window for user to create scenario
 *  - Allows user to edit and delete parts of the scenario 
 * @author Chun-Wah Chung , kyle hallman	
 * 
 *
 */
public class ScenarioCreator extends javax.swing.JFrame implements ActionListener {
	
	
	private JFrame frame;
	private JPanel p, pi;
	private JButton ok, close;
	private JTextField name, cell, button;
	private File newFile;
	private String newFilePath;
	
	private String numOfCell, numOfButton;
	
	private LinkedList<String> contents;
	private Editor editor;
	private Scanner reader;
	private BufferedWriter writer;
	private DefaultListModel<String> model = new DefaultListModel<>();
	
	private boolean isRunningStart;
	
	   private javax.swing.JComboBox<String> buttonSelect;
	   private javax.swing.JButton correctAudio;
	   private javax.swing.JTextArea correctQuestion;
	   private javax.swing.JButton delete;
	   private javax.swing.JButton edit;
	   private javax.swing.JButton exitBut;
	   private javax.swing.JButton finish;
	   private javax.swing.JSlider inputMethodSlider;
	   private javax.swing.JButton jButton1;
	   private javax.swing.JButton jButton2;
	   private javax.swing.JLabel jLabel1;
	   private javax.swing.JLabel jLabel2;
	   private javax.swing.JLabel jLabel3;
	   private javax.swing.JLabel jLabel4;
	   private javax.swing.JLabel jLabel5;
	   private javax.swing.JLabel jLabel6;
	   private javax.swing.JPanel jPanel1;
	   private javax.swing.JPanel jPanel2;
	   private javax.swing.JPanel jPanel3;
	   private javax.swing.JPanel jPanel4;
	   private javax.swing.JScrollPane jScrollPane1;
	   private javax.swing.JScrollPane jScrollPane2;
	   private javax.swing.JScrollPane jScrollPane3;
	   private javax.swing.JScrollPane jScrollPane4;
	   private javax.swing.JScrollPane jScrollPane5;
	   private javax.swing.JTextArea jTextArea1;
	   private javax.swing.JTextArea jTextArea2;
	   private javax.swing.JList<String> list;
	   private javax.swing.JRadioButton rad1;
	   private javax.swing.JRadioButton rad2;
	   private javax.swing.JRadioButton rad3;
	   private javax.swing.JRadioButton rad4;
	   private javax.swing.JRadioButton rad5;
	   private javax.swing.JRadioButton rad6;
	   private javax.swing.JRadioButton rad7;
	   private javax.swing.JRadioButton rad8;
	   private javax.swing.JButton radButBack;
	   private javax.swing.JButton radButNext;
	   private javax.swing.JButton saveBut;
	   private javax.swing.JButton testBut;
	   private javax.swing.JTextArea ttsArea;
	   private javax.swing.JButton ttsAudio;
	   private javax.swing.JTextField txtFldForBinary;
	   // End of variables declaration  

	
	private InitialScenarioCreator ISC;

	/**
	 * Create the application.
	 */
	public ScenarioCreator(boolean newFile) {
		if(newFile == true) {
			isRunningStart = true;
			//while (isRunningStart) {
				//Int();
		//	}
			Int();
			initialize(false);
			setEnabled(false);
		} else {
			initialize(true);
			setEnabled(true);
			//enableFile();
		}
	}
	
	public ScenarioCreator(File fileName, boolean newFile) {
		/*
		if(newFile == true) {
			Int();
			initialize(false);
			setEnabled(false);
		} else {
		*/
			this.newFile = fileName;
			this.newFilePath = fileName.getAbsolutePath();
			//System.out.println(newFilePath);
			initialize(true);
			setEnabled(true);
			enableFile(fileName);
		//}
	}
	
	private void fillList() {
		for (int i =0; i < editor.getSize(); i++) {
			model.addElement(editor.getElement(i));
		}
	}
	
	private void enableFile(File file) {
		editor = new Editor(file);
		System.out.print(editor.getElement(0));
		if(editor.getElement(0) == null) {
			
		} else {
			fillList();
		}
		
		
		
		/*
		for (int i = 0 ; edit.getSize() > i ; i++) {
			String currentLine = edit.getElement(i);
			System.out.println(currentLine);
			
		}*/
	}
	
	
	private void Int() {
		frame = new JFrame("New Scenario");
		frame.isActive();
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
		
		
	
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 *
	 */
	private void initialize(boolean visable) {
		
		   jPanel2 = new javax.swing.JPanel();
	       jLabel1 = new javax.swing.JLabel();
	       jScrollPane1 = new javax.swing.JScrollPane();
	       jTextArea1 = new javax.swing.JTextArea();
	       inputMethodSlider = new javax.swing.JSlider();
	       jLabel2 = new javax.swing.JLabel();
	       jLabel3 = new javax.swing.JLabel();
	       txtFldForBinary = new javax.swing.JTextField();
	       rad1 = new javax.swing.JRadioButton();
	       rad2 = new javax.swing.JRadioButton();
	       rad3 = new javax.swing.JRadioButton();
	       rad4 = new javax.swing.JRadioButton();
	       rad5 = new javax.swing.JRadioButton();
	       rad6 = new javax.swing.JRadioButton();
	       rad7 = new javax.swing.JRadioButton();
	       rad8 = new javax.swing.JRadioButton();
	       radButNext = new javax.swing.JButton();
	       radButBack = new javax.swing.JButton();
	       buttonSelect = new javax.swing.JComboBox<>();
	       jLabel4 = new javax.swing.JLabel();
	       jScrollPane2 = new javax.swing.JScrollPane();
	       correctQuestion = new javax.swing.JTextArea();
	       correctAudio = new javax.swing.JButton();
	       jScrollPane3 = new javax.swing.JScrollPane();
	       jTextArea2 = new javax.swing.JTextArea();
	       jButton2 = new javax.swing.JButton();
	       finish = new javax.swing.JButton();
	       jPanel1 = new javax.swing.JPanel();
	       jLabel5 = new javax.swing.JLabel();
	       jScrollPane4 = new javax.swing.JScrollPane();
	       ttsArea = new javax.swing.JTextArea();
	       ttsAudio = new javax.swing.JButton();
	       jLabel6 = new javax.swing.JLabel();
	       jButton1 = new javax.swing.JButton();
	       jPanel3 = new javax.swing.JPanel();
	       jScrollPane5 = new javax.swing.JScrollPane();
	       list = new javax.swing.JList<String>(model);
	       delete = new javax.swing.JButton();
	       edit = new javax.swing.JButton();
	       jPanel4 = new javax.swing.JPanel();
	       testBut = new javax.swing.JButton();
	       saveBut = new javax.swing.JButton();
	       exitBut = new javax.swing.JButton();

	       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	       setTitle("Scenario Creator");
	       setPreferredSize(new java.awt.Dimension(900, 800));
	       setResizable(false);

	       jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	       jPanel2.setToolTipText("Create your questions in this zone");
	       jPanel2.setName(""); // NOI18N

	       jLabel1.setText("Question Builder");

	       jTextArea1.setColumns(20);
	       jTextArea1.setRows(5);
	       jTextArea1.setToolTipText("Enter your question here");
	       jScrollPane1.setViewportView(jTextArea1);
	       jTextArea1.getAccessibleContext().setAccessibleName("Question");

	       inputMethodSlider.setMaximum(1);
	       inputMethodSlider.setMinimum(-1);
	       inputMethodSlider.setMinorTickSpacing(1);
	       inputMethodSlider.setPaintLabels(true);
	       inputMethodSlider.setPaintTicks(true);
	       inputMethodSlider.setToolTipText("Slide to direction of what you would like to input with");
	       inputMethodSlider.setValue(0);
	       inputMethodSlider.addChangeListener(new javax.swing.event.ChangeListener() {
	           public void stateChanged(javax.swing.event.ChangeEvent evt) {
	               inputMethodSliderStateChanged(evt);
	           }
	       });
	       inputMethodSlider.addMouseListener(new java.awt.event.MouseAdapter() {
	           public void mouseClicked(java.awt.event.MouseEvent evt) {
	               inputMethodSliderMouseClicked(evt);
	           }
	       });

	       jLabel2.setText("Enter String");

	       jLabel3.setText("Manually Enter");

	       txtFldForBinary.setToolTipText("Enter word here");
	       txtFldForBinary.setEnabled(false);
	       

	       rad1.setEnabled(false);

	       rad2.setEnabled(false);

	       rad3.setEnabled(false);
	     
	       rad4.setEnabled(false);

	       rad5.setEnabled(false);

	       rad6.setEnabled(false);

	       rad7.setEnabled(false);

	       rad8.setEnabled(false);

	       radButNext.setText(">");
	       radButNext.setEnabled(false);

	       radButBack.setText("<");
	       radButBack.setEnabled(false);

	       buttonSelect.setToolTipText("Select the button which will have the right answer");

	       jLabel4.setText("Select button for the correct answer");

	       correctQuestion.setColumns(20);
	       correctQuestion.setRows(5);
	       correctQuestion.setToolTipText("Add text to what you want to be said when the correct answer is selected");
	       jScrollPane2.setViewportView(correctQuestion);
	       correctQuestion.getAccessibleContext().setAccessibleName("Correct Answer Text");
	       correctQuestion.getAccessibleContext().setAccessibleDescription("Enter text for the correct answer");

	       correctAudio.setText("Add Audio For Correct");

	       jTextArea2.setColumns(20);
	       jTextArea2.setRows(5);
	       jTextArea2.setToolTipText("add text to what you want to be said when an incorrect answer is selected");
	       jScrollPane3.setViewportView(jTextArea2);
	       jTextArea2.getAccessibleContext().setAccessibleName("incorrect answer text");
	       jTextArea2.getAccessibleContext().setAccessibleDescription("enter text for the incorrect answer");

	       jButton2.setText("Add Audio For Incorrect");

	       finish.setText("Finish");
	       
	       finish.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                finishActionPerformed(evt);
	            }
	        });
	       
	       

	       javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
	       jPanel2.setLayout(jPanel2Layout);
	       jPanel2Layout.setHorizontalGroup(
	           jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(jPanel2Layout.createSequentialGroup()
	               .addGap(34, 34, 34)
	               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                       .addComponent(radButNext)
	                       .addContainerGap())
	                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                           .addGroup(jPanel2Layout.createSequentialGroup()
	                               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                   .addComponent(txtFldForBinary)
	                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                                       .addGap(0, 0, Short.MAX_VALUE)
	                                       .addComponent(jLabel2)))
	                               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                               .addComponent(inputMethodSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
	                               .addGap(28, 28, 28)
	                               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                   .addComponent(jLabel3)
	                                   .addGroup(jPanel2Layout.createSequentialGroup()
	                                       .addComponent(rad3)
	                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                       .addComponent(rad4))
	                                   .addGroup(jPanel2Layout.createSequentialGroup()
	                                       .addComponent(rad1)
	                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                       .addComponent(rad2))))
	                           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                               .addGap(0, 0, Short.MAX_VALUE)
	                               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                                       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                                           .addComponent(rad7)
	                                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                                           .addComponent(rad8))
	                                       .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                                           .addComponent(rad5)
	                                           .addGap(40, 40, 40)
	                                           .addComponent(rad6)))
	                                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                                       .addComponent(radButBack)
	                                       .addGap(50, 50, 50)))))
	                       .addGap(33, 33, 33))))
	           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	               .addContainerGap()
	               .addComponent(jScrollPane1))
	           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                       .addComponent(jLabel4)
	                       .addGap(58, 58, 58))
	                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                       .addComponent(buttonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                       .addGap(133, 133, 133))
	                   .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
	                       .addComponent(finish)
	                       .addGap(127, 127, 127))))
	           .addGroup(jPanel2Layout.createSequentialGroup()
	               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(jPanel2Layout.createSequentialGroup()
	                       .addContainerGap()
	                       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                           .addGroup(jPanel2Layout.createSequentialGroup()
	                               .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                               .addGap(18, 18, 18)
	                               .addComponent(correctAudio))
	                           .addGroup(jPanel2Layout.createSequentialGroup()
	                               .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                               .addGap(18, 18, 18)
	                               .addComponent(jButton2))))
	                   .addGroup(jPanel2Layout.createSequentialGroup()
	                       .addGap(128, 128, 128)
	                       .addComponent(jLabel1)))
	               .addGap(0, 0, Short.MAX_VALUE))
	       );
	       jPanel2Layout.setVerticalGroup(
	           jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(jPanel2Layout.createSequentialGroup()
	               .addContainerGap()
	               .addComponent(jLabel1)
	               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	               .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
	               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(jPanel2Layout.createSequentialGroup()
	                       .addGap(35, 35, 35)
	                       .addComponent(jLabel3)
	                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                           .addComponent(rad3)
	                           .addComponent(rad4))
	                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                           .addComponent(rad1)
	                           .addComponent(rad2))
	                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                           .addComponent(rad6)
	                           .addComponent(rad5)))
	                   .addGroup(jPanel2Layout.createSequentialGroup()
	                       .addGap(17, 17, 17)
	                       .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                           .addComponent(inputMethodSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                           .addComponent(jLabel2))
	                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                       .addComponent(txtFldForBinary, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
	               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
	                   .addComponent(rad7)
	                   .addComponent(rad8))
	               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                   .addComponent(radButNext)
	                   .addComponent(radButBack))
	               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	               .addComponent(jLabel4)
	               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	               .addComponent(buttonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(jPanel2Layout.createSequentialGroup()
	                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                       .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
	                   .addGroup(jPanel2Layout.createSequentialGroup()
	                       .addGap(19, 19, 19)
	                       .addComponent(correctAudio)))
	               .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(jPanel2Layout.createSequentialGroup()
	                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                       .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
	                   .addGroup(jPanel2Layout.createSequentialGroup()
	                       .addGap(17, 17, 17)
	                       .addComponent(jButton2)))
	               .addGap(18, 18, 18)
	               .addComponent(finish)
	               .addContainerGap(30, Short.MAX_VALUE))
	       );

	       buttonSelect.getAccessibleContext().setAccessibleName("Correct Button");
	       buttonSelect.getAccessibleContext().setAccessibleDescription("Select the answer for the corret button");
	       correctAudio.getAccessibleContext().setAccessibleDescription("Click to add audio for the correct answer");
	       jButton2.getAccessibleContext().setAccessibleDescription("Click to add audio for the correct answer");
	       finish.getAccessibleContext().setAccessibleDescription("Click to finish the question");

	       jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

	       jLabel5.setText("Add Text-To-Speech");

	       ttsArea.setColumns(20);
	       ttsArea.setRows(5);
	       ttsArea.setToolTipText("add text to be converted to text to speech");
	       jScrollPane4.setViewportView(ttsArea);

	       ttsAudio.setText("Add Audio");

	       jLabel6.setText("OR");

	       jButton1.setText("Finish");

	       javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
	       jPanel1.setLayout(jPanel1Layout);
	       jPanel1Layout.setHorizontalGroup(
	           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(jPanel1Layout.createSequentialGroup()
	               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addGroup(jPanel1Layout.createSequentialGroup()
	                       .addContainerGap()
	                       .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
	                       .addGap(18, 18, 18)
	                       .addComponent(jLabel6)
	                       .addGap(29, 29, 29)
	                       .addComponent(ttsAudio))
	                   .addGroup(jPanel1Layout.createSequentialGroup()
	                       .addGap(126, 126, 126)
	                       .addComponent(jLabel5)))
	               .addContainerGap(46, Short.MAX_VALUE))
	           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
	               .addGap(0, 0, Short.MAX_VALUE)
	               .addComponent(jButton1)
	               .addGap(126, 126, 126))
	       );
	       jPanel1Layout.setVerticalGroup(
	           jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(jPanel1Layout.createSequentialGroup()
	               .addContainerGap()
	               .addComponent(jLabel5)
	               .addGap(18, 18, 18)
	               .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
	                   .addGroup(jPanel1Layout.createSequentialGroup()
	                       .addGap(15, 15, 15)
	                       .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                           .addComponent(jLabel6)
	                           .addComponent(ttsAudio))))
	               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	               .addComponent(jButton1)
	               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	       );

	       jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

	       list.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
	       jScrollPane5.setViewportView(list);
	       
	       //System.out.print(editor.getSize());
	       
	       

	       delete.setText("Delete selected");

	       edit.setText("Edit Selected");

	       javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
	       jPanel3.setLayout(jPanel3Layout);
	       jPanel3Layout.setHorizontalGroup(
	           jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(jPanel3Layout.createSequentialGroup()
	               .addContainerGap()
	               .addComponent(jScrollPane5)
	               .addContainerGap())
	           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
	               .addGap(60, 60, 60)
	               .addComponent(edit)
	               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
	               .addComponent(delete)
	               .addGap(41, 41, 41))
	       );
	       jPanel3Layout.setVerticalGroup(
	           jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(jPanel3Layout.createSequentialGroup()
	               .addContainerGap()
	               .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
	               .addGap(18, 18, 18)
	               .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                   .addComponent(delete)
	                   .addComponent(edit))
	               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	       );

	       delete.getAccessibleContext().setAccessibleDescription("Delete the selected option");
	       edit.getAccessibleContext().setAccessibleDescription("Edit the selected option");

	       jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

	       testBut.setText("Test");

	       saveBut.setText("Save");

	       exitBut.setText("Exit");

	       javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
	       jPanel4.setLayout(jPanel4Layout);
	       jPanel4Layout.setHorizontalGroup(
	           jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(jPanel4Layout.createSequentialGroup()
	               .addGap(29, 29, 29)
	               .addComponent(testBut)
	               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	               .addComponent(saveBut)
	               .addGap(109, 109, 109)
	               .addComponent(exitBut)
	               .addGap(109, 109, 109))
	       );
	       jPanel4Layout.setVerticalGroup(
	           jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
	               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	               .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                   .addComponent(testBut)
	                   .addComponent(saveBut)
	                   .addComponent(exitBut))
	               .addGap(54, 54, 54))
	       );

	       testBut.getAccessibleContext().setAccessibleDescription("Test the file");
	       saveBut.getAccessibleContext().setAccessibleDescription("Save the file");
	       exitBut.getAccessibleContext().setAccessibleDescription("Exit the file");

	       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	       getContentPane().setLayout(layout);
	       layout.setHorizontalGroup(
	           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(layout.createSequentialGroup()
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                   .addGroup(layout.createSequentialGroup()
	                       .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	                       .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
	                   .addGroup(layout.createSequentialGroup()
	                       .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                       .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
	               .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	       );
	       layout.setVerticalGroup(
	           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	           .addGroup(layout.createSequentialGroup()
	               .addContainerGap()
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
	                   .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                   .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	               .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
	               .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                   .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                   .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
	               .addContainerGap())
	       );

	       jPanel2.getAccessibleContext().setAccessibleName("Question Builder");
	       jPanel2.getAccessibleContext().setAccessibleDescription("This is the zone where you can create questions");

	       setSize(new java.awt.Dimension(1100, 800));
	       setLocationRelativeTo(null);
	       setVisible(visable);
	   }// </editor-fold>     

                                         
	   /*
	public void setEnabled(boolean initialState) {
		//cellNumTxtField.setEnabled(!initialState);
		//btnNumTxtField.setEnabled(!initialState);
		txtAudioFileName.setEnabled(initialState);
		ttsTxtField.setEnabled(initialState);
		QuestionTxtFld.setEnabled(initialState);
		ScenarioTxtFld.setEnabled(initialState);
		btnUpload.setEnabled(initialState);
		btnAdd.setEnabled(initialState);
		removeSpeechBtn.setEnabled(initialState);
		removeAudioFileBtn.setEnabled(initialState);
		rad1.setEnabled(initialState);
		rad2.setEnabled(initialState);
		rad3.setEnabled(initialState);
		rad4.setEnabled(initialState);
		rad5.setEnabled(initialState);
		rad6.setEnabled(initialState);
		rad7.setEnabled(initialState);
		rad8.setEnabled(initialState);
		AddQuestionBtn.setEnabled(initialState);
		RmQuestBtn.setEnabled(initialState);
	}
	
	/*
	 * Checks to see if cell and button are ints
	 */
	
	   private void inputMethodSliderMouseClicked(java.awt.event.MouseEvent evt) {                                               
	       
	       // TODO add your handling code here:
	       //test what value slider is and enable/disable the other option for input
	       if(inputMethodSlider.isMaximumSizeSet() == true) {
	           enableManual(true);
	       }
	   }                                              
	/*
	   Try to figure out how to update slider and change states 
	   */
	   private void enableManual(boolean set) {
	       rad1.setEnabled(set);
	       rad2.setEnabled(set);
	       rad3.setEnabled(set);
	       rad4.setEnabled(set);
	       rad5.setEnabled(set);
	       rad6.setEnabled(set);
	       rad7.setEnabled(set);
	       rad8.setEnabled(set);
	       radButNext.setEnabled(set);
	       radButBack.setEnabled(set);
	}                                  

	 private void inputMethodSliderStateChanged(javax.swing.event.ChangeEvent evt) {                                               
	       // TODO add your handling code here:
	       if(inputMethodSlider.getValue() == 1) {
	           enableManual(true);
	       } else if (inputMethodSlider.getValue() == -1) {
	           txtFldForBinary.setEnabled(true);
	       } else {
	           enableManual(false);
	           txtFldForBinary.setEnabled(false);
	           
	       }
	   } 
	 
	 private void finishActionPerformed(java.awt.event.ActionEvent evt) {                                       
		 
		 /* add actions to the file and scenario creator when making the question here */
		 
		 String questionTTS = jTextArea1.getText();
		 editor.add("TTS: "+questionTTS);
		 model.addElement("Question being displayed: "+questionTTS);
		 
		 //Decides what to add to the editor
		 if(inputMethodSlider.getValue() == 1) {
	           enableManual(true);
	       } else if (inputMethodSlider.getValue() == -1) {
	    	   String wordToConvert = txtFldForBinary.getText();
	    	   editor.add("Displaying the string " + wordToConvert);
	    	   model.addElement("Displaying the string " + wordToConvert);
	       } else {
	    	   boolean vRad1 = rad1.isSelected();
	    	   boolean vRad2 = rad2.isSelected();
		       boolean vRad3 = rad3.isSelected();
		       boolean vRad4 = rad4.isSelected();
		       boolean vRad5 = rad5.isSelected();
		       boolean vRad6 = rad6.isSelected();
		       boolean vRad7 = rad7.isSelected();
		       boolean vRad8 = rad8.isSelected();
		       
		      
		       
		      
	           
	       }
		 
		 
		 
		
		 
		 
		 
		 
		// JOptionPane.showMessageDialog(null, "Hello World");
		 
		 // TODO add your handling code here:
	    }  
	 
	 
	
	public static boolean cellAndButtonInt(String cell , String button) {
	    try { 
	        Integer.parseInt(cell); 
	        Integer.parseInt(button);
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    if ((Integer.parseInt(cell) > 0)&&(Integer.parseInt(button) > 0) ) {
	    	return true;
	    } else {
	    	return false;
	    }
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String arg = arg0.getActionCommand();
		/*
		 * This checks for the name and correct information of the file
		 */
		if (arg == "Save and continue") {
		String fileName = name.getText().toString();
					String numOfCells = cell.getText().toString();
					String numOfButtons = button.getText().toString();
					newFile = new File(System.getProperty("user.dir")+"/SavedScenarios/"+fileName+".txt");
					newFilePath = newFile.getAbsolutePath();
					
					try {
						this.writer = new BufferedWriter(new FileWriter(newFile));
						if(cellAndButtonInt(numOfCells,numOfButtons)) {
							writer.write("Cell " + numOfCells+"\n");
							writer.write("Button " + numOfButtons+"\n");
							writer.flush();
							frame.dispose();
							initialize(true);
							setEnabled(true);
							enableFile(newFile);
							
							this.numOfCell = numOfCells;
							this.numOfButton = numOfButtons;
							
							
							
							
									
							
						} else {
							JOptionPane.showMessageDialog(null, "Please enter a vaild number greater then 0", "WARNING", JOptionPane.WARNING_MESSAGE);
						}
						
						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						
					}
					//
					
					
					
				 /*
				  * This closes the intital information panel
				  */
					
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
	
	   
		
	}

