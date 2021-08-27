import java.util.*;

/*
	https://leetcode.com/problems/longest-uncommon-subsequence-ii/
*/
class LongestUncommonSubsequenceII {
	public static void main(String[] args) {
		String[] input1 = {"aba","cdc","eae"};
		System.out.println(new Solution().findLUSlength(input1)); // 3

		String[] input2 = {"aaa","aaa","aa"};
		System.out.println(new Solution().findLUSlength(input2)); // -1

		String[] input3 = {"aaa","aaaa","aa"};
		System.out.println(new Solution().findLUSlength(input3)); // 4
	}
}


class Solution {
    public int findLUSlength(String[] strs) {

        Arrays.sort(strs, (s1, s2) -> -Integer.compare(s1.length(), s2.length()));


        for(int i = 0; i < strs.length; i++) {

            if (isUncommon(i, strs)) {
                return strs[i].length();
            }
        }

        return -1;
    }

    private boolean isUncommon(int curr, String[] strs) {
        int minLen = strs[curr].length();

        for(int i = 0; i < strs.length; i++) {

            if (i == curr) continue;
            if (strs[i].length() < minLen) break;

            if (isSubsequence(strs[i], strs[curr]))
                return false;
        }

        return true;

    }

    private boolean isSubsequence(String str, String t) {

        int len1 = str.length();
        int len2 = t.length();

        int j = 0;
        for(int i = 0; i < len1 && j < len2; i++) {
            if (str.charAt(i) == t.charAt(j)) {
                j++;
            }
        }

        return j == len2;
    }
}
