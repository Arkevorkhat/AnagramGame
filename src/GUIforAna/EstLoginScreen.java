package GUIforAna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;

import GameLogicAna.UserAna;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;

public class EstLoginScreen {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstLoginScreen window = new EstLoginScreen();
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
	public EstLoginScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		String csvFile = "userinfo.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        UserAna[] users=new UserAna[300];
        int numberOfUsers = 0;
        
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 255));
		frame.setBounds(100, 100, 841, 458);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblThisIsWhere = new JLabel("This is where parents and children log in to accounts already created");
		lblThisIsWhere.setForeground(new Color(0, 51, 153));
		lblThisIsWhere.setFont(new Font("Impact", Font.PLAIN, 25));
		lblThisIsWhere.setBounds(39, 16, 729, 69);
		frame.getContentPane().add(lblThisIsWhere);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblUsername.setBounds(97, 117, 110, 36);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPassword.setBounds(97, 205, 98, 27);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(226, 123, 334, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(226, 206, 334, 26);
		frame.getContentPane().add(passwordField);
		
		JButton btnEnter = new JButton("ENTER");
		btnEnter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			
				
                 boolean alreadyExist = false;
				
				int numberOfUsers = 0;
				
				for(int count = 0 ; count < 300 ; count++) {
					if(users[count] != null) {
						numberOfUsers++;
					}
				}
				
				for(int count = 0; !alreadyExist && count < numberOfUsers ; count++) {
					if(textField.getText().equals(users[count].getUsername())) {
						alreadyExist = true;
						
						
					}
				
				
				else { 
					alreadyExist=false;
					
				}
					
			}
				
		
			ParentScreen sc=new ParentScreen();
			sc.frame.setVisible(alreadyExist);
			}});
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEnter.setBackground(new Color(153, 255, 153));
		btnEnter.setBounds(340, 306, 160, 46);
		frame.getContentPane().add(btnEnter);
	}
}
