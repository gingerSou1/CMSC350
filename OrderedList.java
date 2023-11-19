/*
 * Name: gingerSou1
 * Date: June 13, 2023
 * Course: CMSC 350
 * Description: Ordered List class. Contains two overloaded implementations of a method
 * named checkSorted.
 */
public class OrderedList {
	static Polynomial poly = new Polynomial();
	

	public static boolean checkSorted(Float x, Float y, int a, int b) {
		// TODO Auto-generated method stub
		if (a != b) {
			if (x < y) {
				return true;
			}
		}
		else if (a==b) {
			if (x>y){
				return true;
			}
		}
		return false;
	}
	public static boolean checkSorted(int a, int b) {
//		Collections.sort(weakSortedPolys, (thisP, otherP) -> {
//		    Iterator<Term> thisIterator = thisP.iterator();
//		    Iterator<Term> otherIterator = otherP.iterator();
//		    while (thisIterator.hasNext()) {
//		        float thisTermExp = thisIterator.next().exp;
//		        float otherTermExp = otherIterator.next().exp;
//		        if (thisTermExp == otherTermExp) {
//		            continue;
//		        } else if (thisTermExp > otherTermExp) {
//		            return 1;
//		        } else {
//		            return -1;
//		        }
//		    }
//		    return 0;
//		});
		if (a<b) {
			return true;
		}
		return false;

	}
	
}
