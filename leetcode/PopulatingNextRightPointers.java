/*
    https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
*/
class PopulatingNextRightPointers {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        Solution sol = new Solution();
        sol.connect(root);
        System.out.println("root -> next: " + root.next);
        System.out.println("root.left -> next: " + root.left.next);
        System.out.println("root.right -> next: " + root.right.next);
    }
}

class Solution {
    public Node connect(Node root) {
        if(root == null || root.left == null || root.right == null) {
            return root;
        }
        root.left.next = root.right;
        if(root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

/*
     Definition for a Node.
*/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }
    public String toString() {
        return "Node(" + val +")";
    }
};

