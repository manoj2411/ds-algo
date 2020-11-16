/*
        https://leetcode.com/problems/range-sum-of-bst/
*/
class RangeSumOfBST {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        Solution sol = new Solution();

        System.out.println(sol.rangeSumBST(root, 7, 15)); //32
        System.out.println(sol.rangeSumBST(root, 6, 16)); //32
    }
}


class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if( root == null) {
            return 0;
        } else if(root.val >= low && root.val <= high) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if(root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else if(root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else {
            return 0;
        }
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
