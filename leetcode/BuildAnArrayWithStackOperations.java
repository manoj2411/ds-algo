import java.util.*;

/*
	https://leetcode.com/problems/build-an-array-with-stack-operations/
*/
class BuildAnArrayWithStackOperations {
	public static void main(String... args) {
		int[] input1 = {1,3};

		System.out.println(new Solution().buildArray(input1, 3)); // ["Push","Push","Pop","Push"]
	}
}

class Solution {

    public List<String> buildArray(int[] target, int n) {
        List<String> operations = new ArrayList<>();

        for(int i = 1, j = 0; i <= n && j < target.length; i++) {
            operations.add("Push");
            if(i == target[j]) {
                j++;
            } else {
                operations.add("Pop");
            }
        }
        return operations;
    }
}
