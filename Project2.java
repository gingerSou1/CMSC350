/*
 * Name: Corey Glover
 * Date: June 13, 2023
 * Course: CMSC 350
 * Description: Main class that calls the main method. A named lambda expression is defined.
 */
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import javax.swing.JFileChooser;


// class that allows user to choose the file for variables
class FileChooser {
	public static String getLocal() {	
	    // create instance of JFileChooser		
		JFileChooser fileLoc = new JFileChooser("C:\\Users\\");
		String fullPath = null;
		
		fileLoc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if (fileLoc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			File myFile = fileLoc.getSelectedFile();
			fullPath = myFile.getAbsolutePath();
		}
	    //System.out.println(fullPath);
	    return fullPath;
	}
}

// class for project 2
public abstract class Project2 implements Comparable<Float>{	
	static ArrayList<String[]> list = new ArrayList<String[]>();
	static Path fileName = Path.of(FileChooser.getLocal());
	
	// method to run comparePoly to determine strong or weak order
	public static boolean comparePoly() throws IOException{
		// call variables and read in the file as strings
		ArrayList<String[]> list = new ArrayList<String[]>();	
		
		try {
			String str = Files.readString(fileName);
			Scanner scan = new Scanner(Files.readString(fileName));
			// take strings and replace returns and new lines with spaces
			str = str.replace("\r", " ");
			// assign to array and split with spaces
			String[] strArr = str.split(" ");
			
			while (scan.hasNext()) {
				str = scan.nextLine();
				str = str.replace("\r"," ");
				strArr = str.split(" ");

				list.add(strArr);
			}
		}
		catch (NullPointerException e){
			InvalidPolynomialSyntax.nullState();
		}
		

		boolean bool = false;
		try {
			
			for (int i = 0; i < list.size(); i++) {
				String[] array = list.get(i);
				
				float y = Float.valueOf(array[0]);
				int a = Integer.valueOf(array[1]);
				float z = Float.valueOf(array[2]);
				int b = Integer.valueOf(array[3]);
				
				bool = OrderedList.checkSorted(y,z,a,b);

			}
		}
		catch (NumberFormatException e) {
			InvalidPolynomialSyntax.uncheckedException();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			InvalidPolynomialSyntax.generalError();
		}

		return bool;
	}
	
	// method to get the lines of the file
	public static void getLines()  throws IOException {
		try {
			Polynomial polyList = new Polynomial();

			// call to choose file of variables
			String str = Files.readString(fileName);
			String coef = null;
			
			// take strings and replace returns and new lines with spaces
			str = str.replace("\r", " ");
			// assign to array and split with spaces
			String[] strArr = str.split(" ");
			
			// to loop to send items to Linked List
			for (int i = 0; i < strArr.length; i++) {
		    	coef = strArr[i];
		    	//System.out.print(coef);
		    	polyList = Polynomial.loadList(polyList, coef);
		    	
			}
			// call iterator class
			Polynomial.iterator(polyList);
			comparePoly();
		}
		catch (IOException e) {
			InvalidPolynomialSyntax.generalError();
		}
	}
	
	// main method
	public static void main(String[] args) throws IOException {
		// call the getlines method
		Project2.getLines();
	}
}
