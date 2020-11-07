class SmallestDivisorBelowThreshold {
    public static void main(String[] args) {
        Solution sol = new Solution();
        /*
            Input: nums = [1,2,5,9], threshold = 6
            Output: 5
        */
        int[] arr1 = {1,2,5,9};
        System.out.println(sol.smallestDivisor(arr1, 6));

        /*
            Input: nums = [2,3,5,7,11], threshold = 11
            Output: 3
        */
        int[] arr2 = {2,3,5,7,11};
        System.out.println(sol.smallestDivisor(arr2, 11));

    }
}

class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1;

        for(int n : nums)
            right = Math.max(right, n);

        while(right - left > 1) {
            int mid = (left + right) / 2;

            if(calculate_result(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return calculate_result(nums, left) > threshold ? right : left;

    }

    private int calculate_result(int[] nums, int d) {
        int res = 0;
        for(int n : nums) {
            int division = n / d;
            res += (n % d == 0) ? division : division + 1;
        }
        // System.out.println("d: " + d + ", res: " + res);
        return res;
    }
}
