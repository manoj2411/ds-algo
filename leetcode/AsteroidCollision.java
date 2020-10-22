import java.util.*;

/*
    https://leetcode.com/problems/asteroid-collision/
*/
class AsteroidCollision {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] inputs = {
            {5,10,-5}, // [5,10]
            {8, -8}, // []
            {10,2,-5}, // [10]
            {-2,-1,1,2},//  [-2,-1,1,2]
            {-2,-2,1,-2},//  [-2,-2,-2]
        };

        for(int i = 0; i < inputs.length; i++) {
            int[] asteroids = inputs[i];
            int[] result = sol.asteroidCollision(asteroids);
            System.out.println("Input: " + Arrays.toString(asteroids));
            System.out.println("res: " + Arrays.toString(result));
            System.out.println();
        }
    }
}

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < asteroids.length; i++) {
            int curr = asteroids[i];
            int currVal = Math.abs(curr);

            if(curr > 0 || stack.isEmpty() || stack.peek() < 0) {
                stack.add(curr);
            } else if(currVal == stack.peek()){
                stack.pop();
            } else if(currVal > stack.peek()){
                // curr is negative & greater value than stack peek
                stack.pop();
                i--; // retry for same curr again.
            }


            // // curr is neg, stack has peek which is > 0
            // while(stack.size() > 0 && stack.peek() > 0 && stack.peek() < currVal)
            //     stack.pop();
            // if(stack.isEmpty() || stack.peek() < 0) {
            //     stack.add(curr);
            // } else if(stack.peek() == currVal) {
            //     stack.pop();
            // }

        }

        int[] res = new int[stack.size()];
        for(int i = res.length - 1; i >= 0; i--)
            res[i] = stack.pop();
        return res;
    }
}

/*      test cases:

[-2,-2,1,-2]
[5,10,-5]
[8,-8]
[10,2,-5]
[-2,-1,1,2]
[-2,-2,1,-2]
[-1,-1,2,-1]
[5,10,-5,-10]
[5,10,-10,-5]
[5,10,-11,-5]
[5,10,-1,-15]

*/
