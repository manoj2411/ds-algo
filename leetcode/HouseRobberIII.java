/*
        https://leetcode.com/problems/house-robber-iii/
*/
class HouseRobberIII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println("max amount: " + sol.rob(root)); // 7
    }
}

class Solution {
    public int rob(TreeNode root) {
        Result result = helper(root);
        return result.prev1;
    }

    Result helper(TreeNode root) {
        if(root == null) {
            return new Result(0, 0);
        }

        Result left = helper(root.left);
        Result right = helper(root.right);
        int max = Math.max(root.val + left.prev2 + right.prev2, left.prev1 + right.prev1);
        return new Result(max, left.prev1 + right.prev1);
    }
}

class Result {
    int prev1;
    int prev2;
    Result(int p1, int p2) {
        prev1 = p1;
        prev2 = p2;
    }
}

/**
 * Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

