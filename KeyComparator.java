import java.util.Comparator;

// important for Deliv C

public class KeyComparator  implements Comparator<Node>{

	@Override
	public int compare(Node n, Node n1) {
		if(n.getKey() < n1.getKey())
			return -1;
		else if (n.getKey() > n1.getKey())
			return 1;
		
		else return n.getName().compareTo(n1.getName());
	}

}
