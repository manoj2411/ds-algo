import java.util.*;

/*
	https://leetcode.com/discuss/interview-question/614096/facebook-interview-preparation-question-passing-yearbooks
*/
class PassingYearbooks {
	public static void main(String[] args) {

		int[] arr = {2, 1};
		var result = new Solution().findSignatureCounts(arr);
		System.out.println(Arrays.toString(result));
		// [2, 2]

		arr = new int[] {1, 2};
		result = new Solution().findSignatureCounts(arr);
		System.out.println(Arrays.toString(result));
		// [1, 1]

		arr = new int[] {3,6,5,1,4,2,7};
		result = new Solution().findSignatureCounts(arr);
		System.out.println(Arrays.toString(result));
		// [4,2,4,4,4,2,1]

		arr = new int[] {4,3,2,5,1};
		result = new Solution().findSignatureCounts(arr);
		System.out.println(Arrays.toString(result));
		// [3, 2, 2, 3, 3]

		arr = new int[] {5,3,9,4,1,8,6,2,7};
		result = new Solution().findSignatureCounts(arr);
		System.out.println(Arrays.toString(result));
		// [2, 6, 6, 1, 2, 6, 6 ,6 6]
	}
}

class Solution {

  int assingGroupAndGetSize(int[] groups, int i, int label, int[] arr) {
    if (groups[i] != -1) return 0;

    groups[i] = label;
    return 1 + assingGroupAndGetSize(groups, arr[i], label, arr);
  }

  int[] findSignatureCounts(int[] arr) {

    // transform to 0 index
    for(int i = 0; i < arr.length; i++) arr[i]--;

    int[] result = new int[arr.length];
    Arrays.fill(result, -1);

    List<Integer> groupSizes = new ArrayList<>();
    for(int i = 0; i < arr.length; i++) {
      if (result[i] == -1) {
        // assign group label
        int label = groupSizes.size();
        int groupSize = assingGroupAndGetSize(result, i, label, arr);
        groupSizes.add(groupSize);
      }
    }

    for(int i = 0; i < arr.length; i++) {
      result[i] = groupSizes.get(result[i]);
    }

    return result;
  }

}
