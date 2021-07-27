import java.util.*;

class SlowSums {
	public static void main(String[] args) {
		int[] arr = {4, 2, 1, 3};
		System.out.println(new Solution().getTotalTime(arr)); // 26

		arr = new int[] {2, 3, 9, 8, 4};
		System.out.println(new Solution().getTotalTime(arr)); // 88
	}
}

class Solution {
  int getTotalTime(int[] arr) {
    // Write your code here
    if (arr.length == 1) return 0;

    Arrays.sort(arr);

    int sum = arr[arr.length - 1];
    int penalties = 0;

    for(int i = arr.length - 2; i >= 0; i--) {
      sum += arr[i];
      penalties += sum;
    }

    return penalties;
  }
}
