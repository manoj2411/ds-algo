import java.util.*;

/*
	https://leetcode.com/problems/random-pick-with-weight/
*/
class RandomPickWithWeight {
	public static void main(String[] args) {
		int[] nums = {1, 3, 2};
		Solution sol = new Solution(nums);

		System.out.println(sol.pickIndex());
		System.out.println(sol.pickIndex());
		System.out.println(sol.pickIndex());
		System.out.println(sol.pickIndex());
		System.out.println(sol.pickIndex());
		System.out.println(sol.pickIndex());
		System.out.println(sol.pickIndex());

	}
}

class Solution {

    int[] range;
    Random random;

    public Solution(int[] w) {

        for(int i = 1; i < w.length; i++) {
            w[i] += w[i-1];
        }

        range = w;
        random = new Random();
    }

    public int pickIndex() {
        int l = 0;
        int r = range.length - 1;

        int target = random.nextInt(range[r]) + 1;

        while( r - l > 1) {

            int mid = (l + r) / 2;

            if (range[mid] > target) {
                r = mid;
            } else if (range[mid] < target) {
                l = mid + 1;
            } else {
                return mid;
            }
        }

        return range[l] >= target ? l : r ;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
