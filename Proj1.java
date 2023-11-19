/*
 * Name: Corey Glover
 * Date: May 23, 2023
 * Course: CMSC 350
 * Description: Class along with Main function that will run the GUI of the project
 * 	as well as call the prefix and postfix classes
 * Source: Similar code from https://www.geeksforgeeks.org/postfix-prefix-conversion/ 
 * 	used as example to test theory
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Proj1 {
	static JFrame guiFrame;
	static JPanel guiPanel;
	static JButton preButton, postButton;
	static JLabel userExp;
	static JLabel userResult;
	static JLabel Result;
	static JTextField userEntry;
	static String userSelect;
	
	public static void createWindow() {
		// create panel/frame
		guiPanel = new JPanel();
		guiFrame = new JFrame("Expression Converter");
		// set frame size
		guiFrame.setSize(450, 250);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		guiFrame.add(guiPanel);
		
		guiPanel.setLayout(null);
		
		userExp = new JLabel("Enter Expression: ");
		userExp.setBounds(50, 20, 110, 25);
		guiPanel.add(userExp);
		
		userEntry = new JTextField();
		userEntry.setBounds(175, 20, 165, 25);
		guiPanel.add(userEntry);
		
		preButton = new JButton("Prefix to Postfix");
		preButton.setBounds(100, 70, 125, 25);
		guiPanel.add(preButton);
		
		postButton = new JButton("Postfix to Prefix");
		postButton.setBounds(250, 70, 125, 25);
		guiPanel.add(postButton);
		
		buttonAction();
		
		Result = new JLabel("Result: ");
		Result.setBounds(100, 100, 110, 25);
		guiPanel.add(Result);
		
		userResult = new JLabel();
		userResult.setBounds(150, 100, 110, 25);
		guiPanel.add(userResult);
		
		guiFrame.setVisible(true);
	}
	
	// method to determine what button actions do
		public static void buttonAction() {
			// set buttons to action listener, if pre run pre
			preButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						String preString = Proj1.userEntry.getText();
						String preArray = PrefixConv.getPrefix(preString);
						//String preArray = test1.preToPost(preString);
						userResult.setText(preArray);
					} catch (Exception Syntax2) {
						userResult.setText("");
						JOptionPane.showMessageDialog(Result, "Error: Try again.");
					}

				}
			});
			// set buttons to action listener, if post run post
			postButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						String postString = Proj1.userEntry.getText();
						String postArray = PostfixConv.getPostfix(postString);
						//String postArray = test.postToPre(postString);
						userResult.setText(postArray);
					} catch (Exception Syntax1) {
						userResult.setText("");
						JOptionPane.showMessageDialog(Result, "Error: Try again.");
					}
				}
			});
		}
		
		
		// main method to run program
		public static void main(String[] args) {
			createWindow();		
		}
}
