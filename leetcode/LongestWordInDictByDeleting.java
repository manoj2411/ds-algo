import java.util.*;

/*
	https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
*/
class LongestWordInDictByDeleting {
	public static void main(String[] args) {
		String str = "abpcplea";
		List<String> dict = List.of("ale","apple","monkey","plea");
		System.out.println(new Solution().findLongestWord(str, dict)); // apple

		str = "abpcplea" ;
		dict = List.of("a","b","c");
		System.out.println(new Solution().findLongestWord(str, dict)); // a

		str = "aaa";
		dict = List.of("aaa","aa","a");
		System.out.println(new Solution().findLongestWord(str, dict)); // aaa

	}
}

class Solution {
    public String findLongestWord(String s, List<String> d) {
        // Collections.sort(d, (String w1, String w2) -> {
        //     if(w1.length() == w2.length())
        //         return w1.compareTo(w2);
        //     return -Integer.compare(w1.length(), w2.length());
        // });

        String res = "";

        for(String word : d) {

            if(hasWord(s, word)){
                if(word.length() > res.length() || (word.length() == res.length() && word.compareTo(res) < 0))
                    res = word;
            }
        }

        return res;
    }

    private boolean hasWord(String str, String word) {
        int j = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == word.charAt(j)) {
                if(++j == word.length()) return true;
            }
        }

        return false;
    }
}
