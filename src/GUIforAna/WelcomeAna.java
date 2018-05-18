package GUIforAna;

import GameLogicAna.FilehandlerAna;
import GameLogicAna.UserServiceAna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WelcomeAna {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeAna window = new WelcomeAna();
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
	public WelcomeAna() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 102));
		frame.setBounds(100, 100, 1029, 708);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("WELCOME TO THE ANAGRAM GAME!!!!");
		lblWelcomeToThe.setFont(new Font("Impact", Font.BOLD, 50));
		lblWelcomeToThe.setForeground(new Color(0, 51, 153));
		lblWelcomeToThe.setBounds(75, 35, 897, 128);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JTextArea txtrAnAnagramIs = new JTextArea();
		txtrAnAnagramIs.setBackground(new Color(255, 255, 102));
		txtrAnAnagramIs.setEditable(false);
		txtrAnAnagramIs.setColumns(10);
		txtrAnAnagramIs.setFont(new Font("Arial", Font.PLAIN, 28));
		txtrAnAnagramIs.setWrapStyleWord(true);
		txtrAnAnagramIs.setLineWrap(true);
		txtrAnAnagramIs.setRows(10);
		txtrAnAnagramIs.setText("An Anagram is a puzzle where a word's letters have been scrambled to form a new word (with the same letters). Kids, it is your job to unscramble the word as fast as you can. Parents and Kids, please click the button to continue with setting up the logistics");
		txtrAnAnagramIs.setBounds(86, 204, 828, 194);
		frame.getContentPane().add(txtrAnAnagramIs);
		
		JButton btnStartTheGame = new JButton("ENTER ANAGRAM LAND!!!");
		btnStartTheGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AccountCreation newAcct =new AccountCreation();
				newAcct.frame.setVisible(true);
			}
		});
		btnStartTheGame.setBackground(new Color(255, 102, 255));
		btnStartTheGame.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnStartTheGame.setBounds(212, 430, 511, 128);
		frame.getContentPane().add(btnStartTheGame);
	}
}
