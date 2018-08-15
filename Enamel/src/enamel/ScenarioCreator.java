package enamel;

import java.awt.Color;
import java.awt.Dimension;
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
 *
 * @author Chun-Wah Chung 
 *
 */
public class ScenarioCreator implements ActionListener {
	
	
	private JFrame frame;
	private JPanel p, pi;
	private JButton ok, close;
	private JTextField name, cell, button;
	private File newFile;
	private String newFilePath;
	
	private LinkedList<String> contents;
	private Editor edit;
	private Scanner reader;
	private BufferedWriter writer;

	private JFrame frmScenarioCreatorWindow;
	private JTextField cellNumTxtField;
	private JTextField btnNumTxtField;
	private JTextField txtAudioFileName;
	private JTextField ttsTxtField;
	private JTextField QuestionTxtFld;
	private JTextField ScenarioTxtFld;
	
	private boolean initialState;
	private JButton removeAudioFileBtn;
	private JButton btnUpload;
	private JButton btnAdd;
	private JButton removeSpeechBtn;
	private JRadioButton rad1;
	private JRadioButton rad2;
	private JRadioButton rad3;
	private JRadioButton rad4;
	private JRadioButton rad5;
	private JRadioButton rad6;
	private JRadioButton rad7;
	private JRadioButton rad8;
	private JButton AddQuestionBtn;
	private JButton RmQuestBtn;
	
	private InitialScenarioCreator ISC;

	/**
	 * Create the application.
	 */
	public ScenarioCreator(boolean newFile) {
		if(newFile == true) {
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
		
		if(newFile == true) {
			Int();
			initialize(false);
			setEnabled(false);
		} else {
			this.newFile = fileName;
			this.newFilePath = fileName.getAbsolutePath();
			initialize(true);
			setEnabled(true);
			enableFile(fileName);
		}
	}
	
	private void enableFile(File file) {
		edit = new Editor(file);
		
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
		
		
		frmScenarioCreatorWindow = new JFrame();
		frmScenarioCreatorWindow.setTitle("Scenario Creator Window");
		frmScenarioCreatorWindow.setBounds(200, 200, 1600, 700);
		frmScenarioCreatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScenarioCreatorWindow.setResizable(false);
		frmScenarioCreatorWindow.setVisible(visable);
		/*
		JLabel lblNumberOfCells = new JLabel("Number of Cells");
		lblNumberOfCells.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		cellNumTxtField = new JTextField();
		cellNumTxtField.setText("Enter a positive integer here");
		cellNumTxtField.setColumns(10);
		
		cellNumTxtField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  cellNumTxtField.setText("");
			  }
			});
		
		JLabel lblNumberOfButtons = new JLabel("Number of Buttons");
		lblNumberOfButtons.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		btnNumTxtField = new JTextField();
		btnNumTxtField.setText("Enter a positive integer here");
		btnNumTxtField.setColumns(10);
		
		btnNumTxtField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  btnNumTxtField.setText("");
			  }
			});
			*/
		
		//*****************************************************  Action Listener for checking button and cell number fields have been set
		
		/*
		btnNumTxtField.getDocument().addDocumentListener(new DocumentListener() {
			
			  public void changedUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    warn();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    warn();
			  }

			  public void warn() {
			     if (Integer.parseInt(btnNumTxtField.getText())<=0){
			       JOptionPane.showMessageDialog(null,
			          "Error: Please enter number bigger than 0", "Error Massage",
			          JOptionPane.ERROR_MESSAGE);
			     }
			  }
			});
		*/
		
		//Audio Button
		
		JLabel lblInsertAudioFile = new JLabel("Insert Audio File");
		lblInsertAudioFile.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtAudioFileName = new JTextField(20);
		txtAudioFileName.setColumns(10);
		TextPrompt txtAudioFileP = new TextPrompt("Audio File Name" , txtAudioFileName); 
		//txtAudioFileName.setText("Audio File Name");
		
		/*
		txtAudioFileName.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  txtAudioFileName.setText("");
			  }
			});
		*/
		
		//Upload Button
		
		btnUpload = new JButton("Upload");
		btnUpload.setBackground(Color.LIGHT_GRAY);
		removeAudioFileBtn = new JButton("Remove");
		removeAudioFileBtn.setBackground(Color.LIGHT_GRAY);
		removeAudioFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//file chooser goes here
			}
		});
		
		//Braille cell info
		
		JLabel lblBrailleCell = new JLabel("Braille Cell");
		lblBrailleCell.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//text to speach header 
		
		JLabel lblTTS = new JLabel("Insert Text-To-Speech");
		lblTTS.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		//txt to speach text field
		
		ttsTxtField = new JTextField(20);
		ttsTxtField.setColumns(10);
		TextPrompt ttsTxtFieldP = new TextPrompt("Insert test-to-speach here" , ttsTxtField); 
		
		/*
		ttsTxtField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  ttsTxtField.setText("");
			  }
			});
		*/
		
		JSeparator separator = new JSeparator();
		
		btnAdd = new JButton("Add ");
		btnAdd.setBackground(Color.LIGHT_GRAY);
		
		removeSpeechBtn = new JButton("Remove");
		removeSpeechBtn.setBackground(Color.LIGHT_GRAY);
		removeSpeechBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		rad1 = new JRadioButton("");
		rad2 = new JRadioButton("");
		rad3 = new JRadioButton("");
		rad4 = new JRadioButton("");
		rad5 = new JRadioButton("");
		rad6 = new JRadioButton("");
		rad7 = new JRadioButton("");
		rad8 = new JRadioButton("");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		//save button
		JButton btnSave = new JButton("Save");
		
		//question text field
		
		QuestionTxtFld = new JTextField();
		QuestionTxtFld.setColumns(20);
		TextPrompt QuestionTxtFldP = new TextPrompt("Insert question here" , QuestionTxtFld); 
		
		/*
		QuestionTxtFld.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  QuestionTxtFld.setText("");
			  }
			});
			
			*/
		
		JLabel lblAddQuestion = new JLabel("Add Question");
		lblAddQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		 AddQuestionBtn = new JButton("Add ");
		AddQuestionBtn.setBackground(Color.LIGHT_GRAY);
		
		 RmQuestBtn = new JButton("Remove");
		RmQuestBtn.setBackground(Color.LIGHT_GRAY);
		
		ScenarioTxtFld = new JTextField();
		ScenarioTxtFld.setColumns(10);
		ScenarioTxtFld.setEditable(false);
		
		
		
		JLabel lblScenarioFile = new JLabel("Scenario File");
		lblScenarioFile.setFont(new Font("Tahoma", Font.BOLD, 16));
		GroupLayout groupLayout = new GroupLayout(frmScenarioCreatorWindow.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						//.addComponent(cellNumTxtField)
						//.addComponent(btnNumTxtField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						//.addComponent(lblNumberOfButtons)
						//.addComponent(lblNumberOfCells)
						.addComponent(lblBrailleCell, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(rad1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rad2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(rad7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(rad8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
										.addComponent(rad5, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(rad3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
									.addGap(4)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(rad6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(rad4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
							.addGap(50)))
					.addGap(38)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblTTS, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtAudioFileName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
								.addComponent(ttsTxtField, Alignment.LEADING)
								.addComponent(QuestionTxtFld, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAddQuestion, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(removeSpeechBtn, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
									.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
									.addComponent(removeAudioFileBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnUpload, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addComponent(AddQuestionBtn, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
								.addComponent(RmQuestBtn, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblInsertAudioFile))
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblScenarioFile, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(ScenarioTxtFld, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(separator, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										//.addComponent(lblNumberOfCells)
										.addComponent(lblInsertAudioFile))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										//.addComponent(cellNumTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtAudioFileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnUpload))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(removeAudioFileBtn))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											//.addComponent(lblNumberOfButtons)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												//.addComponent(btnNumTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblTTS, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(btnAdd)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(removeSpeechBtn))
												.addComponent(ttsTxtField, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
												.addGroup(groupLayout.createSequentialGroup()
													.addGap(15)
													.addComponent(lblBrailleCell, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(rad2)
														.addComponent(rad1))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(rad3)
														.addComponent(rad4))))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(rad5)
													.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addGroup(groupLayout.createSequentialGroup()
															.addGap(4)
															.addComponent(lblAddQuestion, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
														.addGroup(groupLayout.createSequentialGroup()
															.addPreferredGap(ComponentPlacement.RELATED)
															.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(rad8)
																.addComponent(rad7)))))
												.addComponent(rad6))
											.addGap(3)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(QuestionTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(AddQuestionBtn))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(RmQuestBtn))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(lblScenarioFile, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(ScenarioTxtFld, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancel)
								.addComponent(btnSave))))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		frmScenarioCreatorWindow.getContentPane().setLayout(groupLayout);
		
	
	}
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

