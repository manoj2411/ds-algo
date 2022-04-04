import java.util.*;

/*
	https://leetcode.com/problems/longest-common-subsequence/
*/
class LongestCommonSubsequence {
	public static void main(String[] args) {
		String text1 = "abcde", text2 = "ace";
		System.out.println(
			new Solution().longestCommonSubsequence(text1, text2)); // 3
	}
}


class Solution {
    int[][] cache;
    public int longestCommonSubsequence(String text1, String text2) {
        cache = new int[text1.length()][text2.length()];
        for(int[] row : cache)  Arrays.fill(row, -1);

        return helper(text1, 0, text2, 0);
    }

    int helper(String s1, int i, String s2, int j) {
        if (i == s1.length() || j == s2.length()) return 0;

        if (cache[i][j] != -1) return cache[i][j];


        int result;
        if (s1.charAt(i) == s2.charAt(j)) {
            result = 1 + helper(s1, i + 1, s2, j + 1);
        } else {
            result = Math.max(helper(s1, i + 1, s2, j), helper(s1, i, s2, j + 1));
        }
        cache[i][j] = result;
        return result;
    }
}
