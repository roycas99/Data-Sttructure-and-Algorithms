import java.util.Comparator;

public class SortedEdges implements Comparator<Edge> {

	

	public int compare(Edge e, Edge e1) {

		if (e.getDistance() > e1.getDistance()) {
			return 1;
		} else if (e.getDistance() < e1.getDistance()) {
			return -1;
		}
		// compare based on alphatically
		else {
			return e.getHead().getAbbrev().compareTo(e1.getHead().getAbbrev());
		} // else
	} 
	

	

} // end of the class
