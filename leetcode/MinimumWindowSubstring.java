import java.util.*;

/*
	https://leetcode.com/problems/minimum-window-substring/
*/
class MinimumWindowSubstring {
	public static void main(String[] args) {
		String s, t;

		s = "ADOBECODEBANC";
		t = "ABC";
		System.out.println(new Solution().minWindow(s, t)); // BANC

		s = "baabcc";
		t = "cba";
		System.out.println(new Solution().minWindow(s, t)); // abc

		s = "cabwefgewcwaefgcf";
		t = "cae";
		System.out.println(new Solution().minWindow(s, t)); // cwae

	}
}


class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();

        for(char ch : t.toCharArray())
            mapt.put(ch, 1 + mapt.getOrDefault(ch, 0));

        String result = "";
        int start = 0;
        int end = 0;
        int slen = s.length();

        while (end < slen) {


            //expand end until find all chars in t
            while (end < slen && !containsAll(maps, mapt)) {
                char ch = s.charAt(end);
                maps.put(ch, 1 + maps.getOrDefault(ch, 0));
                end++;
            }

            // reduce gap between start & end until they are equal
            while (containsAll(maps, mapt)) {

                if (result.length() == 0 || result.length() > (end - start)) {
                    String substr = s.substring(start, end);
                    result = substr;
                }


                char ch = s.charAt(start++);
                maps.put(ch, maps.get(ch) - 1);
            }

        }

        return result;
    }

    boolean containsAll(Map<Character, Integer> maps, Map<Character, Integer> mapt) {

        for(char ch : mapt.keySet()) {
            if (maps.getOrDefault(ch, 0) < mapt.get(ch))
                return false;
        }

        return true;
    }
}
