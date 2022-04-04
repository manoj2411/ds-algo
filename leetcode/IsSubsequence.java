/*
	https://leetcode.com/problems/is-subsequence/
*/
class IsSubsequence {
	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		System.out.println(new Solution().isSubsequence(s, t)); // true

		s = "axc";
		t = "ahbgdc";
		System.out.println(new Solution().isSubsequence(s, t)); // false
	}
}

class Solution {

    public boolean isSubsequence(String s, String t) {

        int j = 0;
        for(int i = 0; j < s.length() && i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(j))
                j++;
        }

        return j == s.length();
    }
}

