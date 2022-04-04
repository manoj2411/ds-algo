import java.util.*;

/*
	https://leetcode.com/problems/sort-colors/
*/
class SortColors {
	public static void main(String[] args) {
		int[] nums = {2,0,2,1,0,1,0,0,2};
		new Solution().sortColors(nums);
		System.out.println(Arrays.toString(nums));

		nums = new int[] {2,0,1};
		new Solution().sortColors(nums);
		System.out.println(Arrays.toString(nums));
	}
}

class Solution {
    public void sortColors(int[] nums) {
        int left = -1;
        int right = nums.length - 1;
        int i = 0;

        while(i <= right) {
            if (nums[i] == 2) {
                int tmp = nums[right];
                nums[right--] = nums[i];
                nums[i] = tmp;
            } else if (nums[i] == 0) {
                int tmp = nums[++left];
                nums[left] = nums[i];
                nums[i++] = tmp;
            } else {
                i++;
            }

        }
    }
}
