import java.util.*;

/*
	https://leetcode.com/problems/max-number-of-k-sum-pairs/
*/
class MaxNumberOfKsumPairs {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4};
		int k = 5;
		System.out.println(new Solution().maxOperations(nums, k)); // 2

		nums = new int[] {3,1,3,4,3};
		k = 6;
		System.out.println(new Solution().maxOperations(nums, k)); // 1

		nums = new int[] {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
		k = 3;
		System.out.println(new Solution().maxOperations(nums, k)); // 4
	}
}

class Solution {
    public int maxOperations(int[] nums, int k) {

        /*
			Idea is to traverse then array and keep a num counter, check
			 if there is a num2 exists in the counter then
			  decrement the counter and increment result by 1
			 else
			  increment counter for num

			Time: 	O(N)
			Space:	O(N)
        */

        Map<Integer, Integer> counter = new HashMap<>(); // (3, 1)

        int result = 0; // 0

        for(int num : nums) { // 3
            int num2 = k - num; // 3
            if (counter.containsKey(num2)) {
                result++;
                if (counter.get(num2) == 1) {
                    counter.remove(num2);
                } else {
                    counter.put(num2, counter.get(num2) - 1);
                }
            } else {
                counter.put(num, 1 + counter.getOrDefault(num, 0));
            }

        }

        return result;
    }
}
