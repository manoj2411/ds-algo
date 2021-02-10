/*
    https://leetcode.com/problems/convert-bst-to-greater-tree/
*/
class ConvertBSTtoGreaterTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(1);

        System.out.print("Inorder bst: ");
        printinorder(root);
        System.out.println();

        root = new Solution().convertBST(root);

        System.out.print("Converted greater tree: ");
        printinorder(root);
        System.out.println();
    }

    static void printinorder(TreeNode root)  {
        if(root == null) return;

        printinorder(root.left);

        System.out.print(root.val + " ");

        printinorder(root.right);

    }
}

class Solution {
    public TreeNode convertBST(TreeNode root) {
        int[] prev = {0};
        helper(root, prev);
        return root;
    }

    void helper(TreeNode root, int[] prev) {
        if(root == null) return;


        helper(root.right, prev);

        // System.out.println("prev: " + prev[0]);

        root.val += prev[0];
        prev[0] = root.val;
        helper(root.left, prev);
    }
}

/**
*   Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
