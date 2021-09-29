import java.util.*;

/*
    https://leetcode.com/problems/next-greater-element-ii/
*/
class NextGreaterElementII {
    public static void main(String[] args) {
      int[] arr1 = {1,2,1};

      System.out.println(Arrays.toString(
			new Solution().nextGreaterElements(arr1))); // [2,-1,2]

      int[] arr2 = {1,2,3,4,3};
      System.out.println(Arrays.toString(
            new Solution().nextGreaterElements(arr2))); // [2,3,4,-1,4]

  }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {


        int[] result = new int[nums.length];
        Arrays.fill(result, -1);

        Stack<Pair> stack = new Stack<>(); // unsolved elements in desc order
        stack.add(new Pair(nums[0], 0));

        for(int i = 1; i< nums.length; i++) {

            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                Pair pair = stack.pop();
                result[pair.index] = nums[i];
            }
            stack.push(new Pair(nums[i], i));
        }

        for(int i = 0; i < nums.length; i++) {
            while(stack.peek().val < nums[i]) {
                Pair pair = stack.pop();
                result[pair.index] = nums[i];
            }

        }

        return result;
    }

    class Pair {
        int val;
        int index;
        Pair(int v, int i) {
            val = v;
            index = i;
        }
    }
}
