/*
	https://leetcode.com/problems/range-sum-query-immutable/
*/
class RangeSumQueryImmutable {
	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0, 2));
		// return (-2) + 0 + 3 = 1

		System.out.println(numArray.sumRange(2, 5));
		// return 3 + (-5) + 2 + (-1) = -1

		System.out.println(numArray.sumRange(0, 5));
		// return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3

	}
}

class NumArray {

    int[] prefixSum;

    public NumArray(int[] nums) {
        this.prefixSum = getPrefixSum(nums);
    }

    public int sumRange(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }

    private int[] getPrefixSum(int[] nums) {
        int[] sum = new int[nums.length + 1];


        for(int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
        }

        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
