import java.util.*;
/*
	https://leetcode.com/problems/count-of-smaller-numbers-after-self/
*/
class CountOfSmallerNumsAfterSelf {
	public static void main(String[] args) {
		int[] nums = {5,2,6,1};

		System.out.println(new Solution().countSmaller(nums)); // [2,1,1,0]
	}
}

class Solution {

    public List<Integer> countSmaller(int[] nums) {
        int len = nums.length;

        List<Integer> res = new ArrayList<>();

        if (isIncreasing(nums)) {
            for (int i = 0; i < len; i++)
                res.add(0);
            return res;
        }

        if (isDecreasing(nums)) {
            // System.out.println("desc");
            res.add(0);

            for(int i = len - 2; i >= 0; i--) {
                int last = res.get(res.size() - 1);
                if (nums[i] == nums[i+1]) res.add(last);
                else res.add(res.size());
            }
            Collections.reverse(res);
            return res;
        }

        Node root = new Node(nums[len-1]);
        res.add(0);

        for(int i = nums.length - 2; i >= 0; i--)
            res.add(addToBST(root, nums[i]));

        Collections.reverse(res);
        return res;
    }

    boolean isDecreasing(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) return false;
        }

        return true;
    }

    boolean isIncreasing(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]) return false;
        }
        return true;
    }

    int addToBST(Node root, int num) {

        int currCount = 0;

        while(true) {

            if (num > root.val) { // go right

                currCount += root.count + root.leftCount;
                if(root.right == null) {
                    root.right = new Node(num);
                    break;
                }
                root = root.right;

            } else if (num < root.val){ // go left

                root.leftCount++;

                if(root.left == null) {
                    root.left = new Node(num);
                    break;
                }
                root = root.left;

            } else {
                root.count++;
                currCount += root.leftCount;
                break;
            }
        }


        return currCount;
    }

}

class Node {

    Node left;
    Node right;

    int count;
    int leftCount;
    int val;

    Node(int num) {
        val = num;
        count = 1;
        leftCount = 0;
    }
}
