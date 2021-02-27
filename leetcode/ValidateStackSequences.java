import java.util.*;
/*
	https://leetcode.com/problems/validate-stack-sequences/
*/
class ValidateStackSequences {
	public static void main(String[] args) {
		int[] pushed =  {1,2,3,4,5};
		int[] popped = {4,5,3,2,1};
		System.out.println(new Solution().validateStackSequences(pushed, popped)); // true

		pushed = new int[] {1,2,3,4,5};
		popped = new int[] {4,3,5,1,2};
		System.out.println(new Solution().validateStackSequences(pushed, popped)); // false

		pushed = new int[] {1,2};
		popped = new int[] {1,2};
		System.out.println(new Solution().validateStackSequences(pushed, popped)); // true
	}
}

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();

        while( i < pushed.length) {
            if(pushed[i] == popped[j]) {
                i++;
                j++;
            } else if (stack.size() > 0 && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                stack.push(pushed[i++]);
            }
        }

        while (stack.size() > 0 && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }

        return j == popped.length;
    }
}
