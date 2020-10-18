public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int max = nums[0];
        int currMax = max;
        int currMin = max;

        for(int i = 1; i < nums.length; i++) {

            if(nums[i] > 0) {
                currMax = Math.max(nums[i], nums[i] * currMax);
                currMin = nums[i] * currMin;
            } else if(nums[i] < 0) {
                int tmp = currMax;
                currMax = currMin * nums[i];
                currMin = Math.min(nums[i], nums[i] * tmp);
            } else {
                currMin = nums[i]; // 0
                currMax = nums[i]; // 0
            }

            if(currMax > max)
                max = currMax;
        }

        return max;
    }


    public static void main(String[] args) {
        MaximumProductSubarray sol = new MaximumProductSubarray();
        int[] input1 = {2,3,-2,4};
        System.out.println("Result: " + sol.maxProduct(input1));
        // res: 6

        int[] input2 = {-2,0,-1};
        System.out.println("Result: " + sol.maxProduct(input2));
        // res: 0
    }


}
