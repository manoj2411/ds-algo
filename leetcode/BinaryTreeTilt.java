/*
        https://leetcode.com/problems/binary-tree-tilt/
*/
class BinaryTreeTilt {

    public static void main(String[] args) {
        /*
                 1
               /   \
              2     3
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution sol = new Solution();
        // res : 1
        System.out.println(sol.findTilt(root));
    }
}


class Solution {

    public int findTilt(TreeNode root) {
        int[] res = {0};
        subtreeSum(root, res);
        return res[0];
    }

    private int subtreeSum(TreeNode root, int[] res) {
        if(root == null)
            return 0;
        int leftSum = subtreeSum(root.left, res);
        int rightSum = subtreeSum(root.right, res);
        res[0] += Math.abs(leftSum - rightSum);

        return root.val + leftSum + rightSum;
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
