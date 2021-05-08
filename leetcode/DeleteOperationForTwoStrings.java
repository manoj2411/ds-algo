/*
	https://leetcode.com/problems/delete-operation-for-two-strings/
*/

class DeleteOperationForTwoStrings {
	public static void main(String[] args) {
		var word1 = "sea";
		var word2 = "eat";
		System.out.println(new Solution().minDistance(word1, word2)); // 2

		word1 = "abxazn";
		word2 = "baaz";
		System.out.println(new Solution().minDistance(word1, word2)); // 4
	}
}


class Solution {
    String w1;
    String w2;
    int[][] cache;

    public int minDistance(String word1, String word2) {
        w1 = word1;
        w2 = word2;

        cache = new int[w1.length()][w2.length()];

        for(int i = 0; i < w1.length(); i++)
            for(int j = 0; j < w2.length(); j++)
                cache[i][j] = -1;


        int longestCommonSubseqLen = longestCommonSubseqLen(0, 0);

        return word1.length() + word2.length() - (longestCommonSubseqLen * 2);
    }

    int longestCommonSubseqLen(int i1, int i2) {

        if (i1 == w1.length() || i2 == w2.length()) return 0;

        if (cache[i1][i2] != -1) return cache[i1][i2];

        int max = 0;

        for (int i = i1; i < w1.length(); i++) {
            char ch = w1.charAt(i);

            int j = w2.indexOf(ch, i2);

            if (j != -1) {
                max = Math.max(max, 1 + longestCommonSubseqLen(i+1, j+1));
            }
        }

        cache[i1][i2] = max;
        return max;
    }
}
