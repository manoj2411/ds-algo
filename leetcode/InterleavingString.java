/*
	https://leetcode.com/problems/interleaving-string/
*/
class InterleavingString {
	public static void main(String... args) {
		System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbcbcac")); // true
		System.out.println(new Solution().isInterleave("aabcc", "dbbca", "aadbbbaccc")); // false
		System.out.println(new Solution().isInterleave("", "", "")); // true
		System.out.println(new Solution().isInterleave("a", "d", "a")); // false
	}
}

class Solution {
    Boolean[][] cache;

    public boolean isInterleave(String s1, String s2, String s3) {
        cache = new Boolean[s1.length() + 1][s2.length() + 1];

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        return canSolve(s1, s2, s3, 0, 0, 0);
    }

    private boolean canSolve(String s1, String s2, String s3, int i, int j, int k) {
        if (k == s3.length()) {
            return true;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k) && canSolve(s1, s2, s3, i + 1, j, k + 1)) {
            return true;
        }

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k) && canSolve(s1, s2, s3, i, j + 1, k + 1)) {
            return true;
        }

        cache[i][j] = false;
        return false;
    }
}
