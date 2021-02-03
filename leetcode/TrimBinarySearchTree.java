/*
    https://leetcode.com/problems/trim-a-binary-search-tree/
*/
class TrimBinarySearchTree {
    public static void main(String... args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);

        TreeNode newRoot = new Solution().trimBST(root, 2,4);
        System.out.println(newRoot);
    }
}

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return root;

        int curr = root.val;

        if(curr < low) {
            return trimBST(root.right, low, high);
        } else if(curr > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
/**
     Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }

    public String toString() {
        return "Node("+val+", l: "+left+", r: "+right+")";
    }
}
