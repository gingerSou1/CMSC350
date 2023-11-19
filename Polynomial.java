/*
 * Name: gingerSou1
 * Date: June 13, 2023
 * Course: CMSC 350
 * Description: Polynomial class that has methods for creating a linked list,
 * convert to string, and create a iterator
 */
import java.io.IOException;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Polynomial implements Comparable<Polynomial>{
	static JFrame frame = new JFrame();;
	Node start;
	Float x, y;

	int a;
	
	// create constructor
	static class Node {
		String coef;
		Node next;
		
		Node(String data) {
			coef = data;
			next = null;
		}
		

	}
	
	@Override
	public int compareTo(Polynomial o) {
		// TODO Auto-generated method stub
		if (this.x.compareTo(o.x) < this.y.compareTo(y)) {
			return 0;
		}
		return 1;
	}
	
	// Method to load the Link List
	public static Polynomial loadList(Polynomial polyList, String coef) {
		Node newPoly = new Node(coef);
		
		// if the lists start is null go to next
		if (polyList.start == null) {
			polyList.start = newPoly;
		}
		else {
			Node endPoly = polyList.start;
			
			// while last node is not null go to next
			while (endPoly.next != null) {
				endPoly = endPoly.next;
			}
			endPoly.next = newPoly;
		}
		
		// return link list
		return polyList;
	}
		
	// create iterator method
	public static Iterator<String> iterator(Polynomial polyList) throws IOException {
		// call variables and create a string
		StringBuilder str = new StringBuilder();
		String myStr = null;
		Node currPoly = polyList.start;
		ArrayList<String> strList = new ArrayList<String>();
		
		// while loop to create a string
		while (currPoly != null) {
			str.append(currPoly.coef + " ");
			currPoly = currPoly.next;
			myStr = str.toString();
		}
		
		// again replace lines with spaces
		myStr = myStr.replace("\r\n", " ");
		String[] strArr = myStr.split(" ");
		
		// assign array to ArrayList
		for (int i = 0; i < strArr.length; i++) {
	    	strList.add(strArr[i]);
		}
		
		// assignt ArrayList to an iterator
		Iterator<String> iterate = strList.iterator();
		
		// call toString and pass iterator
		toString(iterate);
		return iterate;
	}
	
	// create toString method
	public static void toString(Iterator<String> iterate) throws IOException
	{
		String coef = null;
		// set iterator to Iterator() method
//		iterate = iterator(polyList);;
		
		boolean isExpo = false;
		boolean getCompare = Project2.comparePoly();   
		// while loop that checks if iterate has a next value
		while(iterate.hasNext()) {
		   	String curExpo = iterate.next();
//		   	System.out.print(curExpo);
		   	// if loop to check if variable is an exponent(2nd integer)
		   	if(isExpo) {
		   		// if value = 1 set to x
		   		if (curExpo.equals("1")) {
		   			coef = coef + "x + ";
		   		}
		   		// if value = 0 skip
		   		else if (curExpo.equals("0")) {
		   			coef = coef;
		   		}
		   		// else it is set to a coef or expo
		   		else {
		   			coef = coef + "x^" + curExpo;
		    		
		    		if(iterate.hasNext()) {
		    			coef = coef + " + ";
		    		}
		   		}
		   	}
		   	else {
		   		coef = coef + curExpo;
		   	}
		   	isExpo = !isExpo;
		   }
		
		if (getCompare == true) {
			JOptionPane.showMessageDialog(frame, "The Polynomials are:\n" + coef +
					"\n-----------------------" + "\nThese are in STRONG order");
			System.exit(0);
//			System.out.println("\n---------------------");
//			System.out.println("These are in STRONG order");
		}
		else {
			JOptionPane.showMessageDialog(frame, "The Polynomials are:\n" + coef +
					"\n-----------------------" + "\nThese are in WEAK order");
			System.exit(0);
		}
//		JOptionPane.showMessageDialog(frame, "The Polynomials are:\n" + coef);
//		System.out.print(coef);
	}

}
