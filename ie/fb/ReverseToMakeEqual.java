import java.io.*;
import java.util.*;

class ReverseToMakeEqual {
	public static void main(String[] args) {

    	int[] array_a = {1, 2, 3, 4};
    	int[] array_b = {1, 4, 3, 2};
    	System.out.println(new Main().areTheyEqual(array_a, array_b)); // true


    	array_a = new int[] {1, 2, 3, 4};
    	array_b = new int[] {1, 4, 3, 3};
    	System.out.println(new Main().areTheyEqual(array_a, array_b)); // false

	}
}

class Main {

  boolean areTheyEqual(int[] array_a, int[] array_b) {
    // Write your code here
    Map<Integer, Integer> nums = new HashMap<>();

    for(int i = 0; i < array_a.length; i++) {
      int a = array_a[i];
      int b = array_b[i];
      if (!nums.containsKey(a)) nums.put(a, 0);
      if (!nums.containsKey(b)) nums.put(b, 0);

      nums.put(a, nums.get(a) + 1);
      nums.put(b, nums.get(b) - 1);

    }

    for(int count : nums.values())
      if (count != 0) return false;

    return true;

  }

}
