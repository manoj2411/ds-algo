import java.util.*;

/*
	https://leetcode.com/problems/next-greater-element-i/
*/
class NextGreaterElementI {
	public static void main(String[] args) {
		int[] arr1 = {4,1,2};
		int[] arr2 = {1,3,4,2};
		System.out.println(Arrays.toString(
			new Solution().nextGreaterElement(arr1, arr2))); // [-1,3,-1]

	}
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);

        Map<Integer, Integer> mapping = new HashMap<>();

        for(int i = 1; i < nums2.length; i++) {

            while(stack.size() > 0 && stack.peek() < nums2[i]) {
                mapping.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()) {
            mapping.put(stack.pop(), -1);
        }

        int[] result = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            result[i] = mapping.get(nums1[i]);
        }

        return result;
    }
}
