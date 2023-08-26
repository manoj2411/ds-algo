import java.util.*;

/*
	https://leetcode.com/problems/maximum-length-of-pair-chain/description/
*/

class MaximumLengthOfPairChain {
	public static void main(String... args) {
		int[][] input1 = { {1,2}, {2,3}, {3,4}};
		System.out.println(new Solution().findLongestChain(input1)); // 2

		int[][] input2 = { {1,2}, {6,8}, {4,5}};
		System.out.println(new Solution().findLongestChain(input2)); // 3
	}
}

class SolutionUsingStack {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) {
                Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        Stack<int[]> stack = new Stack<>();
        stack.push(pairs[0]);

        for(int i = 1; i < pairs.length; i++) {
            int[] last = stack.peek();
            int[] curr = pairs[i];

            if (last[1] < curr[0]) {
                stack.push(curr);
            } else if (last[1] > curr[1]) {
                stack.pop();
                stack.push(curr);
            }
        }

        return stack.size();
    }
}

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> {
            if (a[0] == b[0]) {
                Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        int last = pairs[0][1];
        int count = 1;

        for(int i = 1; i < pairs.length; i++) {
            int[] curr = pairs[i];

            if (last < curr[0]) {
                last = curr[1];
                count++;
            } else if (last > curr[1]) {
                last = curr[1];
            }
        }
        return count;
    }
}
