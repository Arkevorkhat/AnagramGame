package GUIforAna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

public class CorrectAns {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CorrectAns window = new CorrectAns();
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
	public CorrectAns() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 35));
		frame.getContentPane().setBackground(new Color(102, 255, 51));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblYouAreCorrect = new JLabel("YOU ARE CORRECT!!!!!");
		lblYouAreCorrect.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblYouAreCorrect.setBounds(15, 30, 377, 148);
		frame.getContentPane().add(lblYouAreCorrect);
	}
}
