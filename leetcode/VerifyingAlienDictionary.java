import java.util.*;

/*
	https://leetcode.com/problems/verifying-an-alien-dictionary/
*/
class VerifyingAlienDictionary {
	public static void main(String[] args) {
		String[] words = {"hello","leetcode"};
		String order = "hlabcdefgijkmnopqrstuvwxyz";
		System.out.println(new Solution().isAlienSorted(words, order)); // true

		words = new String[] {"word","world","row"};
		order = "worldabcefghijkmnpqstuvxyz";
		System.out.println(new Solution().isAlienSorted(words, order)); // false
	}
}

class Solution {
    Map<Character, Integer> ordering;

    public boolean isAlienSorted(String[] words, String order) {
        ordering = new HashMap<>();
        for(int i = 0; i < 26; i++) ordering.put(order.charAt(i), i);

        for(int i = 1; i < words.length; i++) {
            if (isOutOfOrder(words[i-1], words[i]))
                return false;
        }
        return true;
    }

    private boolean isOutOfOrder(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int minLen = Math.min(len1, len2);

        for(int i = 0; i < minLen; i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if (ch1 != ch2)
                return ordering.get(ch1) > ordering.get(ch2);
        }

        return len1 > len2;
    }
}
