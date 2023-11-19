/*
 * Name: gingerSou1
 * Date: May 23, 2023
 * Course: CMSC 350
 * Description: Class that will run the postfix of the code
 * Source: Similar code from https://www.geeksforgeeks.org/postfix-prefix-conversion/ 
 * 	used as example to test theory
 */

import java.util.Stack;

public class PostfixConv {
    static String getPostfix(String postWord)
    {
		// tokenize
		Stack<String> revStack = new Stack<String>();
		//Stack<String> opStack = new Stack<String>();


     // variable for length of user supplied word
     		int length = postWord.length();
     		int loopPass = 0;
     		// while rev stack isn't empty, loop through tokenized word
     		while (loopPass < length) {
     			// variables for storing popped character
     			String op1 = null;
     			String op2 = null;			

     			// if the character is an operator perform pop
     			
     			if (PrefixConv.isOperator(postWord.charAt(loopPass))) {

     				// pop first character in stack
     				op1 = revStack.peek();
     				revStack.pop();
     				// pop second character in stack
     				op2 = revStack.peek();
     				revStack.pop();
     					
     				// create string with operands and operators
     				String temp = postWord.charAt(loopPass) + op2 + op1;

     				revStack.push(temp);
     				//length--;
     				
     			}
     			else {
     				// character is and operand, push to stack
     				revStack.push(postWord.charAt(loopPass) + "");
     				//length--;
     			}
     			loopPass++;
     		}	
     		return revStack.pop();
     	}
//	// main method to run program
//	public static void main(String[] args) {
//		String Word = "12345";
//		System.out.println("Before: " + Word);
//		String text = getPostfix(Word);
//		System.out.println("After: " + text);
//	}
}
