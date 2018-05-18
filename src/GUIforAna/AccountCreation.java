package GUIforAna;

import java.awt.EventQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JToggleButton;

import GUIforAna.EstLoginScreen;
import GameLogicAna.UserAna;
import GameLogicAna.UserServiceAna;

import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.List;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountCreation {

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
					AccountCreation window = new AccountCreation();
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
	public AccountCreation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		String csvFile = "userinfo.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        
        UserAna[] users = new UserAna[300];
        int numberOfUsers = 0;
        
        try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
            	if(!line.equals("")) {
            		String[] userinfo = line.split(cvsSplitBy);
                    users[numberOfUsers] = new UserAna(userinfo[0], userinfo[1], userinfo[2].equals("P"), userinfo[3]);
                    numberOfUsers++;
            	}
                
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 255, 153));
		frame.setBounds(100, 100, 987, 606);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHereStudentsAnd = new JLabel("Here Parents can create a new account, then later one for you kids");
		lblHereStudentsAnd.setForeground(new Color(0, 0, 153));
		lblHereStudentsAnd.setFont(new Font("Impact", Font.PLAIN, 30));
		lblHereStudentsAnd.setBounds(62, 16, 856, 87);
		frame.getContentPane().add(lblHereStudentsAnd);
		
		JTextArea txtrPleaseMakeSure = new JTextArea();
		txtrPleaseMakeSure.setEditable(false);
		txtrPleaseMakeSure.setBackground(new Color(204, 255, 153));
		txtrPleaseMakeSure.setFont(new Font("Arial", Font.PLAIN, 18));
		txtrPleaseMakeSure.setRows(10);
		txtrPleaseMakeSure.setWrapStyleWord(true);
		txtrPleaseMakeSure.setLineWrap(true);
		txtrPleaseMakeSure.setText("Please choose a username different from your password. Fields are case-sensitive. Make sure no other accounts have the same information. You can create your child's account later. Both Kids and Parents can select \"I already have an account\" to be taken to the relevant login pages.");
		txtrPleaseMakeSure.setBounds(62, 132, 777, 77);
		frame.getContentPane().add(txtrPleaseMakeSure);
		
		JLabel lblNewUsername = new JLabel("New Username:");
		lblNewUsername.setForeground(new Color(0, 51, 153));
		lblNewUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewUsername.setBackground(new Color(153, 255, 51));
		lblNewUsername.setBounds(72, 254, 148, 20);
		frame.getContentPane().add(lblNewUsername);
		
		textField = new JTextField();
		textField.setBounds(246, 251, 313, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password:");
		lblNewPassword.setForeground(new Color(0, 51, 153));
		lblNewPassword.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewPassword.setBounds(72, 322, 148, 20);
		frame.getContentPane().add(lblNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(246, 316, 313, 26);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("I Already Have an Account Here");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EstLoginScreen est= new EstLoginScreen();
				est.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(255, 204, 102));
		btnNewButton.setBounds(193, 407, 465, 77);
		frame.getContentPane().add(btnNewButton);
		
		Label label = new Label("Account User Type:");
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setForeground(new Color(0, 0, 102));
		label.setBounds(639, 234, 188, 27);
		frame.getContentPane().add(label);
		
		JButton btnParent = new JButton("Create Parent Account");
		
		btnParent.addMouseListener(new MouseAdapter() {

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
				}
				
				if(!alreadyExist) {
					BufferedWriter writer;
					try {
						writer = new BufferedWriter(new FileWriter("userinfo.csv", true));
						
						for(int count = 0 ; count < numberOfUsers ; count++) {
							//writer.write(userinfo[count].+","+passwordField.getText()+",P,0");
							writer.newLine();
						}
						
						writer.write(textField.getText()+","+passwordField.getText()+",P,0");
						writer.newLine();
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					EstLoginScreen login= new EstLoginScreen();
					login.frame.setVisible(true);
				} else {
					//this needs to be error window
					//System.out.println("Account already existed!");
					CreateParentError error=new CreateParentError();
					error.frame.setVisible(true);
					
				}
				
				
				//System.out.println(textField.getText());
				
				//System.out.println(passwordField.getText());
				
				
						
			}
		});
		btnParent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnParent.setBounds(632, 281, 228, 29);
		frame.getContentPane().add(btnParent);
	}
}
