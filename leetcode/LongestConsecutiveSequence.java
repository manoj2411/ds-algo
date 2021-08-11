import java.util.*;

/*
	https://leetcode.com/problems/longest-consecutive-sequence/
*/
class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] nums = {100,4,200,1,3,2};
		System.out.println(new Solution().longestConsecutive(nums)); // 4
	}
}


class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        int result = 0;
        for(int num : nums) {

            if (set.contains(num - 1)) continue;

            int currLen = 1;
            while(set.contains(++num)) currLen++;

            result = Math.max(currLen, result);
        }

        return result;
    }

    /*  alternative solution  */

    public int longestConsecutiveNew(int[] nums) {
        int maxLen = 0;

        Set<Integer> set = new HashSet<Integer>();

        for(int num : nums) set.add(num);

        for(int num : nums) {

            if (!set.contains(num)) continue;

            int len = 0;
            int curr = num;
            while(set.contains(curr)) { // expand towards right
                len++;
                set.remove(curr++);
            }

            curr = num - 1;
            while(set.contains(curr)) { // expand towards left
                len++;
                set.remove(curr--);
            }

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }
}
