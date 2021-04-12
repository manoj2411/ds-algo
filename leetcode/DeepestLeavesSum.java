import java.util.*;
/*
	https://leetcode.com/problems/deepest-leaves-sum/
*/
class DeepestLeavesSum {
	public static void main(String[] args) {
		var root = new TreeNode(10);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(4);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(3);
		System.out.println(new Solution().deepestLeavesSum(root)); // 7
	}
}

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        /*
            do level order and keep a sum for every level. on last level it'll have the result
        */

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int sum = 0;

        while (que.size() > 0 ) {
            int levelLen = que.size();
            sum = 0;
            for(int i = 0; i < levelLen; i++) {
                var node = que.poll();
                sum += node.val;

                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
            }

        }

        return sum;
    }
}
/**
 * Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

