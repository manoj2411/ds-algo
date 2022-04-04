import java.util.*;

/*
	https://leetcode.com/problems/daily-temperatures/
*/

class DailyTemperatures {
	public static void main(String[] args) {
		int[] temperatures = { 73,74,75,71,69,72,76,73};

		System.out.println(Arrays.toString(
			new Solution().dailyTemperatures(temperatures))); // [1,1,4,2,1,1,0,0]
	}
}

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int lastIndex = stack.pop();
                answer[lastIndex] = i - lastIndex;
            }

            stack.push(i);
        }

        return answer;
    }
}
