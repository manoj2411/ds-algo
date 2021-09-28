import java.util.*;

/*
	https://leetcode.com/problems/sort-array-by-parity-ii/
*/
class SortArrayByParityII {
	public static void main(String[] args) {

		int[] nums = {4,2,5,7};
		System.out.println(Arrays.toString(
			new Solution().sortArrayByParityII(nums))); // [4, 5, 2, 7]
	}
}

class Solution {

    public int[] sortArrayByParityII(int[] nums) {
        int weven = 0;
        int wodd = 1;

        int len = nums.length;
        while(weven < len && wodd < len) {

            while(weven < len && nums[weven] % 2 == 0) {
                weven += 2;
            }

            while(wodd < len && nums[wodd] % 2 == 1) {
                wodd += 2;
            }

            if (weven < len) {
                int tmp = nums[weven];
                nums[weven] = nums[wodd];
                nums[wodd] = tmp;
            }
        }

        return nums;
    }
}
