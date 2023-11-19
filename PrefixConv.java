/*
 * Name: gingerSou1
 * Date: May 23, 2023
 * Course: CMSC 350
 * Description: Class that will run the prefix of the code
 * Source: Similar code from https://www.geeksforgeeks.org/postfix-prefix-conversion/ 
 * 	used as example to test theory
 */

import java.util.*;

public class PrefixConv {

	static boolean isOperator(char opChar)
    {
		switch (opChar) {
		case '+':
		case '-':
		case '/':
		case '*':
			return true;
		}
		return false;
    }
	static String getPrefix(String preWord) {
		// tokenize
		Stack<String> revStack = new Stack<String>();
		//Stack<String> opStack = new Stack<String>();
		
		// variable for length of user supplied word
		int length = preWord.length();
		int loopPass = length - 1;
		// while rev stack isn't empty, loop through tokenized word
		while (loopPass >= 0) {
			
			// variables for storing popped character
			String op1 = null;
			String op2 = null;			

			// if the character is an operator perform pop
			if (isOperator(preWord.charAt(loopPass))) {
				
				// pop first character in stack
				op1 = revStack.peek();
				revStack.pop();
				// pop second character in stack
				op2 = revStack.peek();
				revStack.pop();
					
				// create string with operands and operators
				String temp = op1 + op2 + preWord.charAt(loopPass);

				revStack.push(temp);
				//length--;
			}
			else {
				// character is and operand, push to stack
				revStack.push(preWord.charAt(loopPass) + "");
				//length--;

			}
			loopPass--;
		}	
		//return postfix expression off the stack
		return revStack.pop();
	}
	
//	// main method to run program
//	public static void main(String[] args) {
//		//String Word = "*2+2-+1292";
//		String Word = "*-A/BC-/AKL";
//		System.out.println("Before: " + Word);
//		String text = getPrefix(Word);
//		System.out.println("After: " + text);
//	}
}
