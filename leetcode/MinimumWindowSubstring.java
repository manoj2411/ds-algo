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
        s = "abcaabcdcccafb";
        t = "abd";
        System.out.println(new Solution().minWindow(s, t)); // abcd

	}
}


class Solution {
    public String minWindow(String s, String t) {
       int slen = s.length();

        int[] tchars = new int[128];
        for(char ch : t.toCharArray())
            tchars[ch]++;

        int[] schars = new int[128];

        int start = 0;
        int end = 0;
        int best = s.length() + 1;
        String res = "";

        while(end < slen) {

            while(!isValid(schars, tchars) && end < slen) {
                schars[s.charAt(end++)]++;
            }

            while(isValid(schars, tchars)) {
                if (best > end - start) {
                    best = end - start;
                    res = s.substring(start, end);
                }

                schars[s.charAt(start++)]--;
            }
        }

        return best <= s.length() ? res : "";
    }

    private boolean isValid(int[] schars, int[] tchars) {

        for(int i = 0; i < 128; i++) {
            if(schars[i] < tchars[i])
                return false;
        }
        return true;
    }

}
