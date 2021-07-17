import java.io.*;
import java.util.*;

/*	Contiguous Subarrays

	 Given an array of N integers. For each index i, determine the number of contiguous
	 subarrays that fulfill the following conditions:
	  - The value at index i must be the maximum element in the contiguous subarrays, and
	  - These contiguous subarrays must either start from or end on index i

*/
class ContiguousSubarrays {
	public static void main(String[] args) {
		int[] arr = {3, 4, 1, 6, 2};
		int[] res;
		res = new Main().countSubarrays(arr);
		System.out.println(Arrays.toString(res));
		// res: [1, 3, 1, 5, 1]

		int[] test_2 = {2, 4, 7, 1, 5, 3};
		res = new Main().countSubarrays(test_2);
		System.out.println(Arrays.toString(res));
		// res: [1, 2, 6, 1, 3, 1]

	}
}


class Main {

  void reverse(int[] arr) {
    int left = 0;
    int right = arr.length - 1;

    while(left < right) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }

  int[] countLeftSubarrays(int[] arr) {
    int[] res = new int[arr.length];

    // to keep element's indice in decreasing order
    Stack<Integer> stack = new Stack<>();

    res[0] = 1;
    stack.add(0);

    for(int i = 1; i < arr.length; i++) {
      int subarr_sum = 1;

      while(stack.size() > 0 && arr[stack.peek()] < arr[i]) {
        subarr_sum += res[stack.pop()];
      }

      stack.add(i);
      res[i] = subarr_sum;
    }

    return res;

  }


  int[] countSubarrays(int[] arr) {
    // Write your code here
    int[] left = countLeftSubarrays(arr);
    reverse(arr);
    int[] right = countLeftSubarrays(arr);
    reverse(right);

    int[] result = new int[arr.length];

    for(int i = 0; i < arr.length; i++) {
      result[i] = left[i] + right[i] - 1;
    }

    return result;
  }
}

