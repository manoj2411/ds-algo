import java.util.*;

/*
	https://leetcode.com/problems/number-of-good-pairs/
*/
class NumberOfGoodPairs {
	public static void main(String... args) {
		int[] input1 = {1,2,3,1,1,3};
		System.out.println(new Solution().numIdenticalPairs(input1)); // 4

		int[] input2 = {1,1,1,1};
		System.out.println(new Solution().numIdenticalPairs(input2)); // 6

		int[] input3 = {1,2,3};
		System.out.println(new Solution().numIdenticalPairs(input3)); // 0
	}
}

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> pairCount = new HashMap<>();

        int count = 0;
        for(int num : nums) {
            int pairs = pairCount.getOrDefault(num, 0);
            count += pairs;
            pairCount.put(num, 1 + pairs);
        }

        return count;
    }
}
