import java.util.*;

/*
	https://leetcode.com/problems/remove-duplicates-from-sorted-array/
*/
class RemoveDupsFromSortedArray {
	public static void main(String[] args) {

		int[] arr = {0,0,1,1,1,2,2,3,3,4};
		int k = new Solution().removeDuplicates(arr);
		System.out.println(Arrays.toString(buildResult(arr, k))); // [0,1,2,3,4]
	}

	static int[] buildResult(int[] arr, int k) {
		int[] result = new int[k];

		for(int i = 0; i < k; i++) {
			result[i] = arr[i];
		}

		return result;
	}
}

class Solution {
    public int removeDuplicates(int[] nums) {

        int k = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}
