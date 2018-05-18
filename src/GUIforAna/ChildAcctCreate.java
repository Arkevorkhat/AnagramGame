package GUIforAna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextPane;

import GameLogicAna.UserAna;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChildAcctCreate {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField parentUsername;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChildAcctCreate window = new ChildAcctCreate();
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
	public ChildAcctCreate() {
		initialize();
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
                    users[numberOfUsers] = new UserAna(userinfo[0], userinfo[1], userinfo[2].equals("C"), userinfo[3]);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 204));
		frame.setBounds(100, 100, 741, 474);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextPane txtpnThisIsWhere = new JTextPane();
		txtpnThisIsWhere.setBackground(new Color(255, 255, 204));
		txtpnThisIsWhere.setForeground(new Color(102, 0, 102));
		txtpnThisIsWhere.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnThisIsWhere.setEditable(false);
		txtpnThisIsWhere.setText("This is where parents create an account for their child. Be sure to give the login information to the child.");
		txtpnThisIsWhere.setBounds(30, 16, 636, 69);
		frame.getContentPane().add(txtpnThisIsWhere);
		
		JLabel lblCreateChildUsername = new JLabel("Create Child Username:");
		lblCreateChildUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreateChildUsername.setBounds(50, 101, 183, 40);
		frame.getContentPane().add(lblCreateChildUsername);
		
		JLabel lblCreateChildPassword = new JLabel("Create Child Password:");
		lblCreateChildPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreateChildPassword.setBounds(50, 171, 183, 33);
		frame.getContentPane().add(lblCreateChildPassword);
		
		textField = new JTextField();
		textField.setBounds(248, 108, 260, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 174, 257, 26);
		frame.getContentPane().add(passwordField);
		
		JButton btnCreate = new JButton("Create!");
		btnCreate.addMouseListener(new MouseAdapter() {
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
						
						writer.write(textField.getText()+","+passwordField.getText()+",C,"+parentUsername);
						writer.newLine();
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					EstLoginScreen login= new EstLoginScreen();
					login.frame.setVisible(true);
				} else {
					System.out.println("Account already existed!");
				}

			}
		});
		btnCreate.setBackground(new Color(255, 204, 102));
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCreate.setBounds(564, 348, 115, 29);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblYourParent = new JLabel("YOUR ( parent) username, again please:");
		lblYourParent.setForeground(new Color(204, 0, 0));
		lblYourParent.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYourParent.setBounds(50, 249, 356, 33);
		frame.getContentPane().add(lblYourParent);
		
		parentUsername = new JTextField();
		parentUsername.setBackground(new Color(204, 255, 255));
		parentUsername.setBounds(50, 298, 325, 26);
		frame.getContentPane().add(parentUsername);
		parentUsername.setColumns(10);
	}
}
