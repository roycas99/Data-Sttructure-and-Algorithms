
import java.util.Comparator;

public class NodeSorted  implements Comparator<Node>{

	@Override
	// sorted by names
	public int compare(Node node1, Node node2) {
		return node1.getName().compareTo(node2.getName());
	}

}
