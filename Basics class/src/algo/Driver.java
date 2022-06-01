package algo;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String bgnString = "hot";
		String endString = "cog";
		List <String>wordList= new ArrayList<String>();
		wordList.add("hot" );
		wordList.add( "dog");
		wordList.add("lot" );
		wordList.add("log" );
		wordList.add("cog" );
		
		
		BFS bfs = new BFS();
		System.out.println(bfs.BFSMethod(bgnString, endString, wordList));
		

	}

}
