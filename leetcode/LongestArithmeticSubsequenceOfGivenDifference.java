import java.util.*;

/*
	https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/description/
*/
class LongestArithmeticSubsequenceOfGivenDifference {
	public static void main(String... args) {
		int[] input = {1,5,7,8,5,3,4,2,1};
		System.out.println(new Solution().longestSubsequence(input, -2)); // 4
	}
}

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int num : arr) {
            count.put(num, 1 + count.getOrDefault(num - difference, 0));
        }
        return count.values().stream().max(Integer::compareTo).orElse(1);
    }
}
