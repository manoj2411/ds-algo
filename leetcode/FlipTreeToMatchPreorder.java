import java.util.*;

/*
    https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/
*/
class FlipTreeToMatchPreorder {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int[] voyage = {1,3,2};

        System.out.println(new Solution().flipMatchVoyage(root, voyage));

    }

}

class Solution {
    int i;
    List<Integer> flips;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        i = 0;
        flips = new LinkedList<>();

        return tryMatch(root, voyage) ? flips : List.of(-1);
    }

    boolean tryMatch(TreeNode root, int[] voyage) {
        if (root == null) return true;

        if (voyage[i++] != root.val) return false;

        // Now we have matching root;

        if (root.left != null && root.left.val != voyage[i]) {
            flips.add(root.val);
            return tryMatch(root.right, voyage) && tryMatch(root.left, voyage);
        }

        return tryMatch(root.left, voyage) && tryMatch(root.right, voyage);
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
