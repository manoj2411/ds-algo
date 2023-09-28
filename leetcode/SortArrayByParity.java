import java.util.*;

/*
	https://leetcode.com/problems/sort-array-by-parity/description/
*/
class SortArrayByParity {
	public static void main(String... args) {
		int[] arr1 = {3,1,2,4};
		System.out.println(Arrays.toString(
			new Solution().sortArrayByParity(arr1))); // [2,4,1,3]
	}
}

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        for(int num : nums) {
            if (num % 2 == 0) {
                result[left++] = num;
            } else {
                result[right--] = num;
            }
        }

        return result;
    }
}
