import java.util.*;

class LengthOfLongestSubstrUniqueChars {
	public static void main(String[] args) {
		String[] input = {"ABDEFGABEF", "BBBB", "abcd"};

		for(String str : input) {
			System.out.println("String: " + str +
				"\nLength of longest substring: " + lengthOfLongestString(str) +
				"\n" // + lenUsingQueueAndSet(str)
			);

		}
	}

	static int lengthOfLongestString(String str) {
	    int[] indices = new int[124];
	    for(int i = 0; i < indices.length; i++)
	        indices[i] = -1;

	    int maxLen = 0;
	    int start = 0;

	    for(int i = 0; i < str.length(); i++) {
	        char ch = str.charAt(i);
	        if(indices[ch] >= start)
	            start = indices[ch] + 1;

	        indices[ch] = i;
	        maxLen = Math.max(maxLen, i - start + 1);
	    }

	    return maxLen;
	}

	static int lenUsingQueueAndSet(String str) {
	   Set<Character> set = new HashSet(26, 1.0f);
	   Queue<Character> que = new LinkedList<>();
	    int maxLen = 0;

	   for(int i = 0; i < str.length(); i++) {
	       char ch = str.charAt(i);
	       if(set.contains(ch)) {
	           while(que.peek() != ch) {
	               set.remove(que.poll());
	           }
	           que.poll();
	       }
	       que.add(ch);
	       set.add(ch);
	       if(que.size() > maxLen)
	           maxLen = que.size();
	   }

	   return maxLen;
	}
}