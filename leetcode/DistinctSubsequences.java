import java.util.*;

/*
	https://leetcode.com/problems/distinct-subsequences/
*/
class DistinctSubsequences {
	public static void main(String[] args) {
		System.out.println(new Solution().numDistinct("rabbbit", "rabbit")); // 3

		System.out.println(new Solution().numDistinct("babgbag", "bag")); // 5

	}
}

class Solution {

    int[][] cache;

    public int numDistinct(String s, String t) {

        cache = new int[s.length() + 1][t.length()];
        for(int[] row : cache) Arrays.fill(row, -1);

        return helper(s, t, 0, 0);
    }

    private int helper(String s, String t, int sIndex, int tIndex) {
        int i = sIndex;
        int j = tIndex;

        if (j == t.length()) return 1;
        else if (i == s.length()) return 0;
        else if (cache[sIndex][tIndex] != -1) return cache[i][j];

        while(i < s.length() && s.charAt(i) != t.charAt(j)) i++;

        int result;
        if (i == s.length()) {
            result = 0;
        }  else {
            result = helper(s, t, i + 1, j + 1) + helper(s, t, i + 1, j);
        }

        cache[sIndex][tIndex] = result;
        return result;
    }


}
