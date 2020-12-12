import java.util.Arrays;
/*
	https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
*/
class RemoveDuplicatesSortedArrII {

	public static void main(String[] args) {
		int[][] input = {
			{0,0,0,1,1,1,1,2,3,3,3,4,4,4,5,5,5},
			{1,1,1,2,2,3},
			{1,2,3,4},
			{1,1,1,1},
		};

		for(int[] arr : input) {
			System.out.println("List: " + Arrays.toString(arr));
			int len = new Solution().removeDuplicates(arr);
			int[] res = Arrays.copyOfRange(arr, 0, len);
			System.out.println("Duplicates removed: " + Arrays.toString(res));
			System.out.println();
		}
	}
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2)
            return nums.length;

        int j = 1;
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1])
                count++;
            else
                count = 1;

            if(count <= 2) {
                nums[j++] = nums[i];
            }
        }

        return j;
    }
}
