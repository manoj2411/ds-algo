import java.util.*;

class SeatingArrangements {
	public static void main(String[] args) {
		int[] arr_1 = {5, 10, 6, 8};
		System.out.println(new Solution().minOverallAwkwardness(arr_1)); // 4

		int[] arr_2 = {1, 2, 5, 3, 7};
		System.out.println(new Solution().minOverallAwkwardness(arr_2)); // 4

	}
}

class Solution {


	int minOverallAwkwardness(int[] arr) {
		Arrays.sort(arr);

		int[] perm = new int[arr.length];
		int l = 0;
		int r = arr.length - 1;
		for(int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				perm[l++] = arr[i];
			} else {
				perm[r--] = arr[i];
			}
		}

		int max = Math.abs(perm[0] - perm[arr.length - 1]);
		for(int i = 1; i < perm.length - 1; i++) {
			int diff1 = Math.abs(perm[i] - perm[i - 1]);
			int diff2 = Math.abs(perm[i] - perm[i + 1]);
			max = Math.max(max, Math.max(diff1, diff2));
		}

		return max;
	}

}
