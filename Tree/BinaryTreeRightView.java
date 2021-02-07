import java.util.*;

/*
        https://leetcode.com/problems/binary-tree-right-side-view/
*/
class BinaryTreeRightView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(4);
        // res : [1, 3, 4]
        System.out.println("Right view: " + new Solution().rightSideView(root));

    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preorder(root, 0, result);

        return result;
    }

    private void preorder(TreeNode root, int level, List<Integer> list) {
        if(root == null) return;

        if(list.size() == level)
            list.add(root.val);
        else
            list.set(level, root.val);

        preorder(root.left, level + 1, list);
        preorder(root.right, level + 1, list);
    }
}

/**
 *  Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}
