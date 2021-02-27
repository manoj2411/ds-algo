/*
    https://www.geeksforgeeks.org/trapping-rain-water/
*/
class TrappingRainWaterII {
	public static void main(String[] args) {
		int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

    	System.out.println(Solution.trappingWater(arr, arr.length)); // 6
	}
}

class Solution {

    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static int trappingWater(int arr[], int n) {

        int l = 0;
        int r = n - 1;
        int lmax = arr[l];
        int rmax = arr[r];
        int res = 0;

        while (l < r) {

            if (arr[l] < arr[r]) {
                l++;
                if (arr[l] > lmax)  lmax = arr[l];
                else res += Math.min(lmax, rmax) - arr[l];
            } else {
                r--;
                if (arr[r] > rmax) rmax = arr[r];
                else res += Math.min(lmax, rmax) - arr[r];
            }
        }

        return res;
    }
}
