package GUIforAna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;

public class ParentScreen {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ParentScreen window = new ParentScreen();
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
	public ParentScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 820, 512);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnWelcomeParentsHere = new JTextPane();
		txtpnWelcomeParentsHere.setBackground(new Color(255, 255, 204));
		txtpnWelcomeParentsHere.setEditable(false);
		txtpnWelcomeParentsHere.setFont(new Font("Arial", Font.BOLD, 19));
		txtpnWelcomeParentsHere.setText("Here you can create a child account or view information from an existing child account. Parents do not really need to play the game themselves. Please remember your child's login info if you wish to access their account directly (or feel like playing the game!)");
		txtpnWelcomeParentsHere.setBounds(41, 84, 677, 128);
		frame.getContentPane().add(txtpnWelcomeParentsHere);
		
		JLabel lblWelcomeParents = new JLabel("WELCOME, PARENTS!!!");
		lblWelcomeParents.setForeground(new Color(153, 0, 204));
		lblWelcomeParents.setFont(new Font("Impact", Font.PLAIN, 23));
		lblWelcomeParents.setBounds(41, 26, 376, 45);
		frame.getContentPane().add(lblWelcomeParents);
		
		JTextPane txtpnPlaceholderChildScore = new JTextPane();
		txtpnPlaceholderChildScore.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtpnPlaceholderChildScore.setBackground(new Color(153, 255, 204));
		txtpnPlaceholderChildScore.setText("Placeholder child score");
		txtpnPlaceholderChildScore.setBounds(487, 310, 231, 104);
		frame.getContentPane().add(txtpnPlaceholderChildScore);
		
		JButton btnCreateNewChild = new JButton("Create New Child Account");
		btnCreateNewChild.setBackground(new Color(255, 153, 153));
		btnCreateNewChild.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCreateNewChild.setBounds(41, 379, 264, 35);
		frame.getContentPane().add(btnCreateNewChild);
		
		JLabel lblYourChildsLatest = new JLabel("Your Child's Latest Score Is:");
		lblYourChildsLatest.setForeground(new Color(204, 0, 102));
		lblYourChildsLatest.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblYourChildsLatest.setBounds(421, 253, 297, 41);
		frame.getContentPane().add(lblYourChildsLatest);
	}
}
