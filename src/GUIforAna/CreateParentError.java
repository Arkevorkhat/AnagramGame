package GUIforAna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class CreateParentError {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateParentError window = new CreateParentError();
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
	public CreateParentError() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 51));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrParentAccountCreation = new JTextArea();
		txtrParentAccountCreation.setEditable(false);
		txtrParentAccountCreation.setBackground(new Color(255, 255, 51));
		txtrParentAccountCreation.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtrParentAccountCreation.setLineWrap(true);
		txtrParentAccountCreation.setWrapStyleWord(true);
		txtrParentAccountCreation.setText("Parent account creation failed. Please try again. Make sure no other account has the same information. Make sure your username and password are not similar to each other. Remember everything is case-sensitive.");
		txtrParentAccountCreation.setBounds(15, 28, 398, 200);
		frame.getContentPane().add(txtrParentAccountCreation);
	}

}
