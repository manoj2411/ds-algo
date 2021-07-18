import java.util.*;

class PairSums {
	public static void main(String[] args) {
	    int k = 6;
	    int[] arr = {1, 2, 3, 4, 3};
	    // int expected = 2;
	    System.out.println(new Solution().numberOfWays(arr, k));


	    k = 6;
	    arr = new int[]{1, 5, 3, 3, 3};
	    // int expected_2 = 4;
	    System.out.println(new Solution().numberOfWays(arr, k));

	}
}

class Solution {

  int numberOfWays(int[] arr, int k) {
    // Write your code here
    Map<Integer, Integer> count = new HashMap<>();

    int result = 0;

    for(int num : arr) {
      result += count.getOrDefault(k - num , 0);
      int c = count.getOrDefault(num, 0);
      count.put(num, c + 1);
    }

    return result;
  }
}
