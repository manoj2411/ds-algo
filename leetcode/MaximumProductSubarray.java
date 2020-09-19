public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int max = nums[0];
        int currMax = max;
        int currMin = max;

        for(int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int tmp;
            if(curr > 0) {
                tmp = currMax;
                // can be : 0 , -10, 10
                currMax = Math.max(curr, tmp * curr);
                currMin = Math.min(currMin * curr, curr);
            } else if(curr < 0) {
                tmp = currMax;
                // can be : 0 , -10, 10
                currMax = Math.max(curr, currMin * curr);
                currMin = Math.min(tmp * curr, curr);
            } else {
                currMin = 0;
                currMax = 0;
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
