import java.util.*;
import java.util.regex.Pattern;


public class BinaryTree {
	String word;
	int size;
	Node root;
	// create a class for nodes
	class Node {
		char data;
		Node left, right;
		Node(char obj) {
			data = obj;
			left = right = null;
		}
	}
	
	// function to build a tree from user provided string
	public Node buildTree(String str) {
		word = str;
		size = 0;
		return add();
	}
	
	// function to add nodes from string
	public Node add() {
		if (size >= word.length()) {
			return null;
		}
		
		char chWrd = word.charAt(size++);
		Node newNode = new Node(chWrd);
		
		if (chWrd == '(' || chWrd == ')') {
			return add();
		}
		
		if (size < word.length() && word.charAt(size) == '(') {
			size++;
			newNode.left = add();
			size++;
		}
		if (size < word.length() && word.charAt(size) == '(') {
			size++;
			newNode.right = add();
			size++;
		}
		return newNode;
	}
	
	// function to determine if tree is balanced
	public boolean isBalanced(Node myNode) {
		if (myNode == null) {
			return true;
		}
			
		int leftHeight = height(myNode.left);
		int rightHeight = height(myNode.right);
		
		
		if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(myNode.left) 
				&& isBalanced(myNode.right)) {
			return true;
		}
		return false;
	}
	
	// function to determine if the tree is full or empty
	boolean isFull(Node myNode) {
		if(myNode == null) {
			return true;
		}

		if(myNode.left == null && myNode.right == null) {
			return (isFull(myNode.left) && isFull(myNode.right));
		}
		return false;
	}
	
	// function to get whether the tree is proper or not
	public boolean isProper(Node myNode) {
		if (myNode != null) {
			if (myNode.left == null && myNode.right == null || myNode.right == myNode.left) {
				return true;
			}
			
			if (myNode.left == null || myNode.right == null) {
				return false;
			}
		}
		return isProper(myNode.left) && isProper(myNode.right); 
	}
	
	// function to get the height of the tree
	public int height(Node myNode) {
		if (myNode != null) {
			int leftHeight = height(myNode.left);
			int rightHeight = height(myNode.right);
			
			if (leftHeight > rightHeight) {
				return leftHeight + 1;
			}
			else {
				return rightHeight + 1;
			}
		}
		return 0;
	}

	// function to get the number of nodes
	public int getNodes() {
		String wrd = word;
		wrd = word.replaceAll("[\\[\\](){}]", "");
		int len = wrd.length();
		return len;
		}
	
	// helper function to create an Inorder tree
	public String inOrderTravel(Node root) {
		StringBuilder strBuild = new StringBuilder();
		inOrder(root, strBuild);
		return strBuild.toString();
	}
	// secondary function to build an inorder string
	public void inOrder(Node root, StringBuilder strBuild) {
		if (root != null) {
			strBuild.append("(");
			inOrder(root.left, strBuild);
			strBuild.append(root.data);
			inOrder(root.right, strBuild);
			strBuild.append(")");
		}
	}
}
