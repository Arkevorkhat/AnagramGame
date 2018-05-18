package GUIforAna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class ChildScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChildScreen window = new ChildScreen();
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
	public ChildScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 255));
		frame.setBounds(100, 100, 775, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeKids = new JLabel("WELCOME, KIDS!!!");
		lblWelcomeKids.setFont(new Font("Impact", Font.PLAIN, 27));
		lblWelcomeKids.setBounds(252, 16, 328, 49);
		frame.getContentPane().add(lblWelcomeKids);
		
		JTextPane txtpnHereIsYour = new JTextPane();
		txtpnHereIsYour.setForeground(new Color(153, 0, 153));
		txtpnHereIsYour.setBackground(new Color(204, 255, 255));
		txtpnHereIsYour.setFont(new Font("Arial", Font.BOLD, 21));
		txtpnHereIsYour.setText("Here is your super cool Child Account information. Click \"start\" to begin a new Anagram game, or see your previous scores in the corner there.");
		txtpnHereIsYour.setBounds(37, 81, 638, 81);
		frame.getContentPane().add(txtpnHereIsYour);
		
		JTextArea txtrScorePlaceholder = new JTextArea();
		txtrScorePlaceholder.setBackground(new Color(255, 255, 153));
		txtrScorePlaceholder.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtrScorePlaceholder.setText("Score placeholder");
		txtrScorePlaceholder.setBounds(499, 231, 195, 95);
		frame.getContentPane().add(txtrScorePlaceholder);
		
		JLabel lblYourLatestScore = new JLabel("Your Latest Score:");
		lblYourLatestScore.setForeground(new Color(51, 0, 102));
		lblYourLatestScore.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblYourLatestScore.setBounds(484, 178, 221, 49);
		frame.getContentPane().add(lblYourLatestScore);
		
		JLabel lblClickToBegin = new JLabel("Click to begin a new game:");
		lblClickToBegin.setForeground(new Color(0, 0, 153));
		lblClickToBegin.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClickToBegin.setBounds(47, 204, 265, 49);
		frame.getContentPane().add(lblClickToBegin);
		
		JButton btnStart = new JButton("START!!!!");
		btnStart.setBackground(new Color(255, 102, 255));
		btnStart.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnStart.setBounds(75, 254, 185, 55);
		frame.getContentPane().add(btnStart);
	}

}
