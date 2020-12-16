import java.util.*;
/*
	https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
*/
class NextLargerElement {

    public static long[] nextLargerElement(long[] arr, int n) {
        long[] result = new long[n];

        Stack<Long> stack = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {

        	while(stack.size() > 0 && stack.peek() < arr[i])
        		stack.pop();

        	result[i] = stack.isEmpty() ? -1 : stack.peek();
        	stack.push(arr[i]);
        }
        return result;
    }

    public static void main(String[] args) {
    	long[][] input = {
    		{1,3,2,4},
    		{6,8,0,1,3},
    	};

    	for(long[] arr : input) {
    		long[] res = nextLargerElement(arr, arr.length);
    		System.out.println("arr: " + Arrays.toString(arr));
    		System.out.println("next larger elements: " + Arrays.toString(res));
    		System.out.println();
    	}

    }
}