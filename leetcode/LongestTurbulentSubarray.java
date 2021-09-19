/*
	https://leetcode.com/problems/longest-turbulent-subarray/
*/
class LongestTurbulentSubarray {
	public static void main(String[] args) {
		int[] arr = {9,4,2,10,7,8,8,1,9};
		System.out.println(new Solution().maxTurbulenceSize(arr)); // 5
	}
}

class Solution {
    public int maxTurbulenceSize(int[] arr) {

        int max = 1;
        int count = 1;
        Boolean prev_res = null;
        for(int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[i - 1]) {
                max = Math.max(max, count);
                prev_res = null;
                count = 1;
                continue;
            }

            Boolean is_curr_less = arr[i] < arr[i - 1];

            if (is_curr_less == prev_res) {
                max = Math.max(max, count);
                count = 2;
            } else {
                count++;
            }
            prev_res = is_curr_less;
        }

        max = Math.max(max, count);
        return max;
    }
}
