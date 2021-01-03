/*
	https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
*/

class FindNodeInClonedBinaryTree {
	public static void main(String[] args) {

	}
}

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null || original == target)
            return cloned;

        TreeNode left = getTargetCopy(original.left, cloned.left, target);

        return left == null ? getTargetCopy(original.right, cloned.right, target) : left;

    }

}

/**
* 	Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

