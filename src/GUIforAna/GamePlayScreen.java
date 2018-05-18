package GUIforAna;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import GameLogicAna.UserAna;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePlayScreen {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GamePlayScreen window = new GamePlayScreen();
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
	public GamePlayScreen() {
		initialize();
	}
	
	public String sortString( String w ) {
		 char[] ch = w.toCharArray();
		 for(int count = 0 ; count < ch.length ; count++) {
			 ch[count] = Character.toLowerCase(ch[count]);
		 }
		 Arrays.sort(ch);
	     return new String(ch);
	 }
	 
	 public boolean isanagrams(ArrayList<String> l) {
		 boolean isanagrams=true;
		 ArrayList<String> anagrams = null;
	     HashMap<String, ArrayList<String>> map =  new HashMap<String, ArrayList<String>>();
	     for(int i=0;i<l.size();i++) {
	    	 String word = l.get(i);
	    	 String sortedWord = sortString(word);
	         anagrams = map.get( sortedWord );
	         if( anagrams == null ) anagrams = new ArrayList<String>();
	         anagrams.add(word);
	         map.put(sortedWord, anagrams);
	     }

	     for(int h=0;h<l.size();h++) {
	    	 if(!anagrams.contains(l.get(h))) {
	    		 isanagrams=false;
	             break;
	         }
	     }

	     return isanagrams;
	 }
	 
	 public String getRandomText(String text) {
		 String csvFile = "words.csv";
		 BufferedReader br = null;
	     String line = "";
	     String returnText = "";
	        
	     String[] words = new String[300];
	     int numberOfWords = 0;
	        
	     try {
	    	 br = new BufferedReader(new FileReader(csvFile));
	    	 while ((line = br.readLine()) != null) {

	    		 // use comma as separator
	    		 if(!line.equals("")) {
	    			 words[numberOfWords] = line;
	    			 numberOfWords++;
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
	     
	     Random r = new Random();
	     
	     returnText = words[r.nextInt(numberOfWords)];
	     
	     while (returnText.equals(text)) {
	    	 returnText = words[r.nextInt(numberOfWords)];
	     }
	     
	     return returnText;
	     
	 }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 204, 255));
		frame.setBackground(new Color(204, 204, 255));
		frame.setBounds(100, 100, 913, 599);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPlayTheGame = new JLabel("Play the Game In This Window:");
		lblPlayTheGame.setForeground(new Color(51, 0, 153));
		lblPlayTheGame.setFont(new Font("Impact", Font.PLAIN, 30));
		lblPlayTheGame.setBounds(254, 16, 382, 57);
		frame.getContentPane().add(lblPlayTheGame);
		
		JLabel lblYourWordIs = new JLabel("Your Word Is:");
		lblYourWordIs.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblYourWordIs.setBounds(58, 222, 134, 51);
		frame.getContentPane().add(lblYourWordIs);
		
		JTextArea txtrPlaceholderWord = new JTextArea();
		txtrPlaceholderWord.setEditable(false);
		txtrPlaceholderWord.setBackground(new Color(204, 255, 204));
		txtrPlaceholderWord.setFont(new Font("Tahoma", Font.BOLD, 25));
		txtrPlaceholderWord.setText("Placeholder Word");
		txtrPlaceholderWord.setBounds(230, 210, 498, 64);
		txtrPlaceholderWord.setText(getRandomText(""));
		frame.getContentPane().add(txtrPlaceholderWord);
		
		JLabel lblAnAnagramIs = new JLabel("An Anagram Is:");
		lblAnAnagramIs.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAnAnagramIs.setBounds(58, 336, 134, 41);
		frame.getContentPane().add(lblAnAnagramIs);
		
		JTextPane txtpnDirectionsSeeThe = new JTextPane();
		txtpnDirectionsSeeThe.setForeground(new Color(0, 102, 153));
		txtpnDirectionsSeeThe.setBackground(new Color(204, 204, 255));
		txtpnDirectionsSeeThe.setEditable(false);
		txtpnDirectionsSeeThe.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtpnDirectionsSeeThe.setText("Directions: See the word displayed by the computer. Now, where it says \"An Anagram Is\", type a word that you think is an anagram of the word presented. If you remember, an anagram is a different word, but one that has the same letters (in a different order)");
		txtpnDirectionsSeeThe.setBounds(58, 89, 770, 91);
		frame.getContentPane().add(txtpnDirectionsSeeThe);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 18));
		textField.setBounds(230, 331, 498, 51);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCheckMyAnswer = new JButton("Check My Answer!!!");
		btnCheckMyAnswer.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				 ArrayList<String> l=new ArrayList<String>();
				 l.add(txtrPlaceholderWord.getText());
				 l.add(textField.getText());
				 
				 //System.out.println(txtrPlaceholderWord.getText());
				 //System.out.println(textField.getText());
				
				if(isanagrams(l)) {
					//this is line to test program in console
					//System.out.println("True");
					CorrectAns yes= new CorrectAns();
					yes.frame.setVisible(true);
					
					txtrPlaceholderWord.setText(getRandomText(txtrPlaceholderWord.getText()));
					textField.setText("");
					
					//String newText = getRandomText(txtrPlaceholderWord.getText());
					
					
				} else {
					//this is also to test program in console:
					//System.out.println("False");
					WrongAns wrong= new WrongAns();
					wrong.frame.setVisible(true);
				}
				
			}
			
		});
		btnCheckMyAnswer.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnCheckMyAnswer.setBackground(new Color(255, 204, 102));
		btnCheckMyAnswer.setBounds(539, 457, 325, 57);
		frame.getContentPane().add(btnCheckMyAnswer);
	}
}
