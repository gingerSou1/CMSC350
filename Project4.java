* Name: gingerSou1
 * Date: July10, 2023
 * Course: CMSC 350
 * Description: Class Project4 asks the user for a file with the data needed to run DirectedGraph.
 * Once selected the data is ran through the method BuildGraph then sent to DirectedGraph.
 * Source: Similar code from textbook provided by UMGS course, Youtube: https://www.youtube.com/watch?v=wMq9c_sKnyE
 * Youtube: https://www.youtube.com/watch?v=wJSTWTu4RHU, https://www.youtube.com/watch?v=q6xXq6Doj00 and 
 * https://www.youtube.com/watch?v=j5flXM4CmM4&list=PLLhXOOcUg89CBvj7ntb8DWFCkTVKrn-U1&index=18
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.*;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Project4{
	static JFrame frame = new JFrame();
	class FileChooser {
		public static String getLocal() {
			// create instance of JFileChooser	
		    String fullPath = null;
			JFileChooser fileLoc = new JFileChooser("C:\\Users\\Corey\\eclipse-workspace\\CMSC350\\Project4\\");				

			fileLoc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			if (fileLoc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File myFile = fileLoc.getSelectedFile();
				fullPath = myFile.getAbsolutePath();
			}
			//System.out.println(fullPath);
		    return fullPath;
		}
	}
	
	public static void buildGraph() throws IOException {
//		String string = "ClassA ClassC ClassE ClassJ\r\n"
//		+ "ClassB ClassD ClassG\r\n"
//		+ "ClassC ClassA\n"
//		+ "ClassE ClassB ClassF ClassH\r\n"
//		+ "ClassJ ClassB\r\n"
//		+ "ClassI ClassC";
//
//BufferedReader read = new BufferedReader(new StringReader(string));
		
		String fullPath = FileChooser.getLocal();
		if (fullPath == null) {
			JOptionPane.showMessageDialog(frame, "Program Exiting...");
			System.exit(0);
		}
		else {
			@SuppressWarnings("resource")
			BufferedReader read = new BufferedReader(new FileReader(fullPath));
			List<String[]> array = new ArrayList<String[]>();
			  
		    

			for (String line = read.readLine(); line != null; line = read.readLine()) {
				String[] fltStr = line.split(" ");
				String[] str = new String[fltStr.length];
				for (int i = 0; i <str.length; i++) {
					str[i] = fltStr[i];
				}
				array.add(str);
			  }
			int V = array.size();
			
		    ArrayList<ArrayList<String> > adj = new ArrayList<ArrayList<String> >(V);
		    for (int i = 0; i < V; i++)
		        adj.add(new ArrayList<String>());
			for (int a = 0; a < array.size(); a++) {  
				String[] word = array.get(a);
				
				for (int i = 1; i < word.length; i++) {
					DirectedGraph.addEdge(word[0], word[i]);
				  }
			  }
	        // Printing the graph
	        DirectedGraph.removeVertex();
	        DirectedGraph.print();
	        DirectedGraph.hierarchyPrint();
	        DirectedGraph.parenthesizedPrint();
	        // Display unreachable classes
	        DirectedGraph.notReached();
		}

	}
	
	// Driver Code
	public static void main(String[] args) throws IOException
	{

		buildGraph();
	}

}
