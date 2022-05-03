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
        int[] sum = {0};
        reverseInorder(root, sum);
        return root;
    }

    void reverseInorder(TreeNode root, int[] sum) {
        if(root != null) {
            reverseInorder(root.right, sum);

            sum[0] += root.val;
            root.val = sum[0];

            reverseInorder(root.left, sum);
        }
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
