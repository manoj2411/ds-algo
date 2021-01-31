/*
    https://www.geeksforgeeks.org/find-maximum-path-sum-two-leaves-binary-tree/
*/
class MaxPathSumBwLeafNode {
    public static void main(String[] args) {
        Node root = new Node(-15);
        root.left = new Node(5);
        root.right = new Node(6);
        root.left.left = new Node(-8);
        root.left.right = new Node(1);
        root.right.left = new Node(3);
        root.right.right = new Node(9);
        root.right.right.right = new Node(-1);

        System.out.println(new Solution().maxPathSum(root)); // 17

        root.right.right.right.left = new Node(4);
        root.right.right.right.right = new Node(-1);
        root.right.right.right.right.left = new Node(10);
        System.out.println(new Solution().maxPathSum(root)); // 26
    }
}

class Solution {
    int res = Integer.MIN_VALUE;

    int maxPathSum(Node root) {
        helper(root);
        return res;
    }

    private int helper(Node root) {
        if(root == null) return 0;

        if(root.left == null) {
            return helper(root.right) + root.data;
        } else if (root.right == null) {
            return helper(root.left) + root.data;
        } else {
            int lsum = helper(root.left);
            int rsum = helper(root.right);
            res = Math.max(res, lsum + rsum + root.data);

            return Math.max(lsum, rsum) + root.data;
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;
    Node(int n) { data = n; }
}
