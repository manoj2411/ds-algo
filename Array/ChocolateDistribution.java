import java.util.*;

class ChocolateDistribution {

	public static void main(String[] args) {
		int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
		int m = 5;
		System.out.println(findMinDiff(arr, m));
		// res = 6

		arr = new int[]{12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
		m = 7 ;
		System.out.println(findMinDiff(arr, m));
		// res = 10

	}

	static int findMinDiff(int[] arr, int m) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for(int i = 0; i + m - 1 < arr.length; i++) {
			min = Math.min(min, arr[i + m - 1] - arr[i]);
		}
		return min;
	}
}

