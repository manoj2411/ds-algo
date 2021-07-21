import java.util.*;

/*
	https://leetcode.com/problems/shuffle-an-array/
*/
class ShuffleAnArray {
	public static void main(String[] args) {
		Solution obj = new Solution(nums);
		int[] param_1 = obj.reset();
		int[] param_2 = obj.shuffle();

	}
}

class Solution {

    Random rand = new Random();
    int[] original;

    public Solution(int[] nums) {
        original = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] arr = original.clone();

        for(int length = arr.length; length >= 1; length--) {
            int i = rand.nextInt(length); // length is exclusive
            swap(arr, length - 1, i);
        }

        return arr;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


