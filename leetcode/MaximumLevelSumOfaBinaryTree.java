import java.util.*;

/*
	https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
*/
class MaximumLevelSumOfaBinaryTree {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(-8);

		System.out.println(new Solution().maxLevelSum(root)); // 2
	}
}


class Solution {

    public int maxLevelSum(TreeNode root) {
        List<Integer> store = new ArrayList<>();

        preorder(root, 0, store);

        int max = Integer.MIN_VALUE;
        int level = -1;
        for(int i = 0; i < store.size(); i++) {
            if (store.get(i) > max) {
                max = store.get(i);
                level = i;
            }
        }
        return level + 1;
    }

    private void preorder(TreeNode node, int level, List<Integer> store) {
        if (node == null) return;

        if (store.size() == level) {
            store.add(node.val);
        } else {
            store.set(level, store.get(level) + node.val);
        }

        preorder(node.left, level + 1, store);
        preorder(node.right, level + 1, store);
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
