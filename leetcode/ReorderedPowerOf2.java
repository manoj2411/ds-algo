import java.util.*;

/*
        https://leetcode.com/problems/reordered-power-of-2/
*/
class ReorderedPowerOf2 {
    public static void main(String[] args) {
        System.out.println(new Solution().reorderedPowerOf2(1)); // t
        System.out.println(new Solution().reorderedPowerOf2(10)); // f
        System.out.println(new Solution().reorderedPowerOf2(61)); // t
        System.out.println(new Solution().reorderedPowerOf2(24)); // f
    }
}

class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[][] nums = new int[30][10];

        for(int i = 0; i < 30; i++)
            fillDigitCounts(nums[i], (int)Math.pow(2, i));


        int[] num = new int[10];
        fillDigitCounts(num, N);

        for(int[] curr : nums)
            if(Arrays.equals(curr, num))
                return true;

        return false;
    }

    private void fillDigitCounts(int[] arr, int num) {
        while (num > 0) {
            arr[num % 10]++;
            num /= 10;
        }

    }
}
