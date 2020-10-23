import java.util.*;

/*
        https://leetcode.com/problems/minimum-depth-of-binary-tree/
*/

class MinDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution sol = new Solution();

        System.out.println("Min depth: " + sol.minDepth(root));
    }
}


class Solution {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        // else if(root.left == null && root.right == null) return 1;
        // else if(root.left == null) return 1 + minDepth(root.right);
        // else if(root.right == null) return 1 + minDepth(root.left);
        // else return 1 + Math.min(minDepth(root.left), minDepth(root.right));

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int currLevel = 0;
        while(!que.isEmpty()) {
            int size = que.size();
            currLevel++;
            for(int i = 0; i < size; i++) {
                TreeNode node = que.remove();
                if(node.left == null && node.right == null) return currLevel;
                if(node.left != null) que.add(node.left);
                if(node.right != null) que.add(node.right);
            }
        }
        return currLevel;
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
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
