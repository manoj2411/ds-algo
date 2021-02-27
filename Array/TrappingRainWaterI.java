/*
	https://www.geeksforgeeks.org/trapping-rain-water/
*/
class TrappingRainWaterI {
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

        int[] maxFromLeft = new int[n];
        int[] maxFromRight = new int[n];

        maxFromLeft[0] = arr[0];
        for(int i = 1; i < n ; i++)
            maxFromLeft[i] = Math.max(maxFromLeft[i-1], arr[i]);

        maxFromRight[n-1] = arr[n-1];
        for(int i = n-2; i >= 0 ; i--)
            maxFromRight[i] = Math.max(maxFromRight[i+1], arr[i]);

        // System.out.println(Arrays.toString(maxFromLeft));
        // System.out.println(Arrays.toString(maxFromRight));

        int res = 0;

        for(int i = 0 ; i < n; i++)
            res += Math.min(maxFromLeft[i], maxFromRight[i]) - arr[i];

        return res;
    }
}
