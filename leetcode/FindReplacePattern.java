import java.util.*;

/*
	https://leetcode.com/problems/find-and-replace-pattern/
*/
class FindReplacePattern {
	public static void main(String[] args) {
		String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
		String pattern = "abb";

		System.out.println(new Solution().findAndReplacePattern(words, pattern));
		// Output: ["mee","aqq"]

	}
}

class Solution {

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> matched = new LinkedList<>();

        for(String word : words) {
            if (isMatching(pattern, word))
                matched.add(word);
        }

        return matched;
    }

    boolean isMatching(String pattern, String word) {

        Map<Character, Character> mapping = new HashMap<>();

        boolean[] alreadyMapped = new boolean[26];

        for(int i = 0; i < word.length(); i++) {

            char wordChar = word.charAt(i);
            char patternChar = pattern.charAt(i);

            if(!mapping.containsKey(patternChar)) {

                if (alreadyMapped[wordChar-'a'])
                    return false;

                mapping.put(patternChar, wordChar);
                alreadyMapped[wordChar-'a'] = true;
            } else if (mapping.get(patternChar) != wordChar) {
                return false;
            }
        }

        return true;
    }
}
