import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Project3 {
	static JFrame guiFrame;
	static JPanel guiPanel;
	static JButton makeTree, isBalance, isFull, isProper, height, nodes, inOrder, clearField;
	static JLabel userInput;
	static JLabel output;
	static JTextField userEntry, userOutput;
	static boolean treeMade = false;
	static BinaryTree tree = new BinaryTree();
	static BinaryTree.Node root;
	
	public static void createWindow() {
		// create panel/frame
		guiPanel = new JPanel();
		guiFrame = new JFrame("Binary Tree Catagorizer");
		// set frame size
		guiFrame.setSize(725, 220);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		guiFrame.add(guiPanel);
		
		guiPanel.setLayout(null);
		
		userInput = new JLabel("Enter Tree: ");
		userInput.setBounds(150, 20, 110, 25);
		guiPanel.add(userInput);
		
		userEntry = new JTextField();
		userEntry.setBounds(225, 20, 300, 25);
		guiPanel.add(userEntry);
		
		clearField = new JButton("Clear");
		clearField.setBounds(550, 20, 100, 25);
		guiPanel.add(clearField);
		
		makeTree = new JButton("Make Tree");
		makeTree.setBounds(13, 70, 95, 25);
		guiPanel.add(makeTree);
		
		isBalance = new JButton("Is Balanced?");
		isBalance.setBounds(115, 70, 105, 25);
		guiPanel.add(isBalance);
		
		isFull = new JButton("Is Full?");
		isFull.setBounds(225, 70, 75, 25);
		guiPanel.add(isFull);
		
		isProper = new JButton("Is Proper?");
		isProper.setBounds(305, 70, 100, 25);
		guiPanel.add(isProper);
		
		height = new JButton("Height?");
		height.setBounds(410, 70, 100, 25);
		guiPanel.add(height);
		
		nodes = new JButton("Nodes");
		nodes.setBounds(515, 70, 75, 25);
		guiPanel.add(nodes);
		
		inOrder = new JButton("Inorder");
		inOrder.setBounds(595, 70, 100, 25);
		guiPanel.add(inOrder);
		
		buttonAction();
		
		output = new JLabel("Output: ");
		output.setBounds(150, 130, 120, 25);
		guiPanel.add(output);
		
		userOutput = new JTextField();
		userOutput.setBounds(200, 130, 300, 25);
		userOutput.setEditable(false);
		guiPanel.add(userOutput);
		
		guiFrame.setVisible(true);
	}
	
	// method to determine what button actions do
		public static void buttonAction() {
			
			// call to Clear the textfield
			clearField.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					userEntry.setText("");
					userOutput.setText("");
				}
			});
			
			// call makeTree function when button is pressed
			makeTree.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String make = Project3.userEntry.getText();
					String regex = "([AZaz0-9\\(\\)])";
					if (make.equals("")) {
						InvalidTreeSyntax.blankTree();
					}
//					else if (make.contains(regex)) {
						root = tree.buildTree(make);
						if (root != null) {
							InvalidTreeSyntax.treeSuccess();
							treeMade = true;
//						}
					}
					else {
						InvalidTreeSyntax.uncheckedException();
					}
				}
			});
			// call isBalanced function when button is pressed
			isBalance.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String make = Project3.userEntry.getText();
					if (treeMade == true) {
						root = tree.buildTree(make);
						if (tree.isBalanced(root) == true) {
							userOutput.setForeground(Color.BLACK);
							userOutput.setText("The tree is balanced.");
						}
						else {
							userOutput.setForeground(Color.RED);
							userOutput.setText("The tree is NOT balanced.");
						}
					}
					else {
						InvalidTreeSyntax.noTreeException();
					}
					
				}
			});
			// call isFull function when button pressed
			isFull.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String make = Project3.userEntry.getText();
					
					if (treeMade == true) {
						root = tree.buildTree(make);
						if (tree.isFull(root) == true) {
							userOutput.setForeground(Color.BLACK);
							userOutput.setText("Tree is full (null).");
						}
						else {
							userOutput.setForeground(Color.RED);
							userOutput.setText("Tree is NOT full.");
						}
					}
					else {
						InvalidTreeSyntax.noTreeException();
					}
				}
			});
			// call isProper function when button pressed
			isProper.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String make = Project3.userEntry.getText();
					if (treeMade == true) {
						root = tree.buildTree(make);
//						System.out.print(tree.isProper(root));
						if (tree.isProper(root) == true) {
							userOutput.setForeground(Color.BLACK);
							userOutput.setText("Tree is Proper.");
						}
						else {
							userOutput.setForeground(Color.RED);
							userOutput.setText("Tree is NOT Proper.");
						}
					}
					else {
						InvalidTreeSyntax.noTreeException();
					}
				}
			});
			// call height when button pressed
			height.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String make = Project3.userEntry.getText();
					root = tree.buildTree(make);
					if (treeMade == true) {
						userOutput.setForeground(Color.BLACK);
						String height = Integer.toString((tree.height(root)-1));
						userOutput.setText(height);
					}
					else {
						InvalidTreeSyntax.noTreeException();
					}
				}
			});
			// call nodes function when pressed
			nodes.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
//					String make = Project3.userEntry.getText();
					if (treeMade == true) {
						userOutput.setForeground(Color.BLACK);
						String len = Integer.toString(tree.getNodes()-1);
						userOutput.setText("Number of Nodes = " + len);
					}
					else {
						InvalidTreeSyntax.noTreeException();
					}
				}
			});
			// call inOrder function when button pressed
			inOrder.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String make = Project3.userEntry.getText();
					if (treeMade == true) {
						userOutput.setForeground(Color.BLACK);
						root = tree.buildTree(make);
						userOutput.setText(tree.inOrderTravel(root));
					}
					else {
						InvalidTreeSyntax.noTreeException();
					}

				}
			});
		}
		
		// main method to run program
		public static void main(String[] args) {

			createWindow();	
		}
}
