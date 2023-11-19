import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class InvalidTreeSyntax {
static JFrame frame = new JFrame();
	
	public static void uncheckedException() {	
		JOptionPane.showMessageDialog(frame, "Sorry, an invalid string was applied.");
	}
	
	public static void noTreeException() {
		JOptionPane.showMessageDialog(frame, "Please create a tree first!");
	}
	
	public static void blankTree() {
		JOptionPane.showMessageDialog(frame, "Field cannot be blank!");
	}
	
	public static void treeSuccess() {
		JOptionPane.showMessageDialog(frame, "Tree Created Successfully!");
	}
}
