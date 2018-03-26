package enamel;

import javax.accessibility.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.AccessibleObject;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class tempScenarioCreatorGUI {

	private JFrame frmScenarioCreatorWindow;
	private JTextField cellNumTxtField;
	private JTextField btnNumTxtField;
	private JTextField txtAudioFileName;
	private JTextField ttsTxtField;
	private JTextField QuestionTxtFld;
	private JTextField ScenarioTxtFld;

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tempScenarioCreatorGUI window = new tempScenarioCreatorGUI();
					window.frmScenarioCreatorWindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public tempScenarioCreatorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 *
	 */
	private void initialize() {
		frmScenarioCreatorWindow = new JFrame();
		frmScenarioCreatorWindow.setTitle("Scenario Creator Window");
		frmScenarioCreatorWindow.setBounds(100, 100, 1009, 436);
		frmScenarioCreatorWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
		
		JLabel lblInsertAudioFile = new JLabel("Insert Audio File");
		lblInsertAudioFile.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		txtAudioFileName = new JTextField();
		txtAudioFileName.setText("Audio File Name");
		txtAudioFileName.setColumns(10);
		
		txtAudioFileName.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  txtAudioFileName.setText("");
			  }
			});
		
		JButton btnUpload = new JButton("Upload");
		
		btnUpload.setBackground(Color.LIGHT_GRAY);
		
		JButton removeAudioFileBtn = new JButton("Remove");
		removeAudioFileBtn.setBackground(Color.LIGHT_GRAY);
		removeAudioFileBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JLabel lblBrailleCell = new JLabel("Braille Cell");
		lblBrailleCell.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblTTS = new JLabel("Insert Text-To-Speech");
		lblTTS.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		ttsTxtField = new JTextField();
		ttsTxtField.setText("Type text here");
		ttsTxtField.setColumns(10);
		
		ttsTxtField.addMouseListener(new MouseAdapter() {
			  @Override
			  public void mouseClicked(MouseEvent e) {
				  ttsTxtField.setText("");
			  }
			});
		
		JSeparator separator = new JSeparator();
		
		JButton btnAdd = new JButton("Add ");
		btnAdd.setBackground(Color.LIGHT_GRAY);
		
		JButton removeSpeechBtn = new JButton("Remove");
		removeSpeechBtn.setBackground(Color.LIGHT_GRAY);
		removeSpeechBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JRadioButton rad1 = new JRadioButton("");
		
		JRadioButton rad2 = new JRadioButton("");
		
		JRadioButton rad3 = new JRadioButton("");
		
		JRadioButton rad4 = new JRadioButton("");
		
		JRadioButton rad5 = new JRadioButton("");
		
		JRadioButton rad6 = new JRadioButton("");
		
		JRadioButton rad7 = new JRadioButton("");
		
		JRadioButton rad8 = new JRadioButton("");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JButton btnSave = new JButton("Save");
		
		QuestionTxtFld = new JTextField();
		QuestionTxtFld.setText("Enter question here");
		QuestionTxtFld.setColumns(10);
		
		JLabel lblAddQuestion = new JLabel("Add Question");
		lblAddQuestion.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JButton AddQuestionBtn = new JButton("Add ");
		AddQuestionBtn.setBackground(Color.LIGHT_GRAY);
		
		JButton RmQuestBtn = new JButton("Remove");
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
						.addComponent(cellNumTxtField)
						.addComponent(btnNumTxtField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(lblNumberOfButtons)
						.addComponent(lblNumberOfCells)
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
						.addComponent(ScenarioTxtFld, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblScenarioFile, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(814, Short.MAX_VALUE)
					.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
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
										.addComponent(lblNumberOfCells)
										.addComponent(lblInsertAudioFile))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(cellNumTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtAudioFileName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnUpload))
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(removeAudioFileBtn))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(18)
											.addComponent(lblNumberOfButtons)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnNumTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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
															.addComponent(lblAddQuestion, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
															.addGap(4))
														.addGroup(groupLayout.createSequentialGroup()
															.addPreferredGap(ComponentPlacement.RELATED)
															.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
																.addComponent(rad8)
																.addComponent(rad7)))))
												.addComponent(rad6))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
												.addComponent(QuestionTxtFld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(AddQuestionBtn))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(RmQuestBtn)))
									.addGap(36)
									.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
										.addComponent(btnCancel)
										.addComponent(btnSave)))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(23)
							.addComponent(lblScenarioFile, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(ScenarioTxtFld, GroupLayout.PREFERRED_SIZE, 291, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		frmScenarioCreatorWindow.getContentPane().setLayout(groupLayout);
	}
}
