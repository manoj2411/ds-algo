import java.util.*;

/*
	https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
*/
class MakeTwoArraysEqualByReversingSubarrays {
	public static void main(String[] args) {
		int[] arr_a = {1,2,3,4};
		int[] arr_b = {2,4,1,3};
		System.out.println(new Solution().canBeEqual(arr_a, arr_b));
	}
}

class Solution {
    public boolean canBeEqual(int[] array_a, int[] array_b) {
        Map<Integer, Integer> nums = new HashMap<>();

        for(int i = 0; i < array_a.length; i++) {
            int a = array_a[i];
            int b = array_b[i];
            if (!nums.containsKey(a)) nums.put(a, 0);
            if (!nums.containsKey(b)) nums.put(b, 0);

            nums.put(a, nums.get(a) + 1);
            nums.put(b, nums.get(b) - 1);

        }

        for(int count : nums.values())
            if (count != 0) return false;

        return true;

    }
}
