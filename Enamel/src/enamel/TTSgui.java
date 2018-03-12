package enamel;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
/**
 * 
 * @author Chun-Wah Chung
 *
 */
public class TTSgui {

		private JFrame frame;
		private JTextField txtTypeHere;

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						TTSgui window = new TTSgui();
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public TTSgui() {
			initialize();
		}
		
		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			
			frame = new JFrame();
			frame.setResizable(false);
			frame.setBounds(100, 100, 450, 300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblInsertTexttospeech = new JLabel("Insert text-to-speech");
			lblInsertTexttospeech.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblInsertTexttospeech.setBounds(22, 13, 320, 35);
			frame.getContentPane().add(lblInsertTexttospeech);
			
			JButton btnNewButton = new JButton("Add Text");
			btnNewButton.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			btnNewButton.setBackground(Color.LIGHT_GRAY);
			btnNewButton.setMnemonic(KeyEvent.VK_S);
			btnNewButton.setBounds(32, 122, 159, 25);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			frame.getContentPane().add(btnNewButton);
			
			txtTypeHere = new JTextField();
			txtTypeHere.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtTypeHere.setBounds(32, 74, 236, 35);
		//	txtTypeHere.setText("Type text here...");
			frame.getContentPane().add(txtTypeHere);
			txtTypeHere.setColumns(10);
			
			JButton btnClose = new JButton("Close", new ImageIcon("Pictures/exit.png"));
			btnClose.setFont(new Font("Tw Cen MT", Font.PLAIN, 16));
			btnClose.setToolTipText("Press Alt+Q to close window");
			btnClose.setForeground(Color.BLUE);
			btnClose.setBackground(Color.WHITE);
			
			btnClose.setBounds(315, 205, 105, 35);
			frame.getContentPane().add(btnClose);
			
			btnClose.setMnemonic(KeyEvent.VK_Q);
			
			btnClose.addActionListener((ActionEvent e) -> {
				System.exit(0);
			});
			
		}

	

}
