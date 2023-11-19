/*
 * Name: gingerSou1
 * Date: June 13, 2023
 * Course: CMSC 350
 * Description: Invalid Polynomial Syntax class that is used to catch syntax
 * errors of the incoming polynomials from the file.
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InvalidPolynomialSyntax {
	static JFrame frame = new JFrame();
	
	public static void uncheckedException() {	
		JOptionPane.showMessageDialog(frame, "Sorry, an incorrect polynomial was found or invalid file format. Exiting Program!");
		System.exit(0);
	}
	
	public static void nullState() {
		JOptionPane.showMessageDialog(frame, "Sorry, a null value was detected, end of file or invalid link. Exiting Program!");
		System.exit(0);
	}
	
	public static void generalError() {
		JOptionPane.showMessageDialog(frame, "Sorry, an error has occured. Values shown after may not be valid!");
	}
	
}
