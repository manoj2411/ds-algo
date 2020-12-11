import java.util.*;
/*
		https://leetcode.com/problems/valid-mountain-array/
*/
class ValidMountainArray {
	public static void main(String[] args) {
		int[][] input = {
			{1,2},
			{1,2,3},
			{5,4,3},
			{0,2,3,4,5,2,1,0},
			{3,5,5},
			{0,3,2,1},
		};

		for(int[] arr : input) {
			Solution sol = new Solution();
			System.out.println("arr: " + Arrays.toString(arr) +
				"\nvalid Mountain? : " + sol.validMountainArray(arr));
		}
	}
}

class Solution {
    public boolean validMountainArray(int[] arr) {
        int i = 0;
        int len = arr.length;

        while(i + 1 < len && arr[i + 1] > arr[i])
            i++;

        if(i == 0 || i == len - 1)
            return false;

        while(i + 1 < len && arr[i + 1] < arr[i])
            i++;

        // System.out.println("i: " + i + ", []: " + arr[i]);
        return i == len - 1;
    }
}