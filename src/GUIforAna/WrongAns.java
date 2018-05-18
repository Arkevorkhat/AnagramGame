package GUIforAna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTextPane;

public class WrongAns {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WrongAns window = new WrongAns();
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
	public WrongAns() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 51, 51));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnSorryWrongAnswer = new JTextPane();
		txtpnSorryWrongAnswer.setFont(new Font("Tahoma", Font.BOLD, 34));
		txtpnSorryWrongAnswer.setEditable(false);
		txtpnSorryWrongAnswer.setBackground(new Color(255, 51, 51));
		txtpnSorryWrongAnswer.setText("Sorry, Wrong Answer. Please Try Again");
		txtpnSorryWrongAnswer.setBounds(27, 38, 354, 168);
		frame.getContentPane().add(txtpnSorryWrongAnswer);
	}
}
