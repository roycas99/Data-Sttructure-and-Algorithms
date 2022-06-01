package algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndDocument;

public class BFS {

	public int BFSMethod(String beginWord, String endWord, List<String> wordList) {

		// arrayList to set for time complexity
		HashSet<String> set = new HashSet();
		for (String string : wordList) {
			set.add(string);

		} // end of forEach loop

		// if there no transformation Sequence return zero
		if (!set.contains(endWord)) {
			return 0;
		}
		// set up Queue
		Queue<String> queue = new LinkedList();
		// add begin word to the queue
		queue.offer(beginWord);
		// Because BFS based on level, init level
		int level = 1;

		while (!queue.isEmpty()) {

			int size = queue.size();
			for (int i = 0; i < size; i++) {
				// pop the word
				String current_wordString = queue.poll();
				// java String cannot be change so change into char.
				char[] word_chars = current_wordString.toCharArray();
				for (int j = 0; j < word_chars.length; j++) {
					// pick up first character
					char first_char = word_chars[j];
					// loop first character from a to z
					for (char k = 'a'; k <= 'z'; k++) {
						// if first character equal the current character continue
						if (word_chars[j] == k)
							continue;
						word_chars[j] = k;
						// back to String
						String new_wordString = String.valueOf(word_chars);
						if (new_wordString.equals(endWord))
							return level + 1;
						// if set contain new word , remove from set and add to queue ;
						if (set.contains(new_wordString)) {
							queue.offer(new_wordString);
							set.remove(new_wordString);
						}

					} // loop for first character

					word_chars[j] = first_char;

				} // looping individual Characters such as "a"

			} // iterating through Queue

			// go to next level
			level++;

		} // end of while loop

		// if we did not endWord in while loop return zero
		return 0;

	} // end of BFS Method

} // end of BFS class
