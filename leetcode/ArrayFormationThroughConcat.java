import java.util.*;
/*
	https://leetcode.com/problems/check-array-formation-through-concatenation/
*/
class ArrayFormationThroughConcat {
	public static void main(String[] args) {

		int[] arr = {91,4,64,78};
		int[][] pieces = {{78}, {4,64}, {91}};
		// true
		System.out.println(new Solution().canFormArray(arr, pieces));

		arr = new int[]{49,18,16};
		pieces = new int[][]{{16,18,49}};
		// false
		System.out.println(new Solution().canFormArray(arr, pieces));

	}
}

class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> indices = buildIndices(arr);

        for(int[] piece : pieces) {

            int j = indices.getOrDefault(piece[0], -1);
            if(j == -1) return false;

            for(int i = 1; i < piece.length; i++) {
                if(i + j >= arr.length || arr[i+j] != piece[i])
                    return false;
            }
        }

        return true;

    }

    Map<Integer, Integer> buildIndices(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++)
            map.put(arr[i], i);
        return map;
    }
}