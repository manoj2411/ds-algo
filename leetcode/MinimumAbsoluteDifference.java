import java.util.*;

/*
	https://leetcode.com/problems/minimum-absolute-difference/
*/
class MinimumAbsoluteDifference {
	public static void main(String[] args) {

		int[] arr = {4,2,1,3};

		System.out.println(new Solution().minimumAbsDifference(arr)); // [[1,2],[2,3],[3,4]]
	}
}

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);

        int minDiff = arr[arr.length - 1];

        for(int i = 1; i < arr.length; i++) {

            int diff = arr[i] - arr[i-1];

            if(diff == minDiff ) {
                result.add(List.of(arr[i-1], arr[i]));
            } else if (diff < minDiff) {
                minDiff = diff;
                result = new ArrayList<>();
                result.add(List.of(arr[i-1], arr[i]));
            }
        }

        return result;
    }
}
