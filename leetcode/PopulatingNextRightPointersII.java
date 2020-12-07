/*
    https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
*/
class PopulatingNextRightPointersII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // [-9,-3,2,null,4,4,0,-6,null,-5]
        // [1,2,3,4,5,null,7]
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.right = new Node(40);
        root.right.left = new Node(50);
        sol.connect(root);
    }
}

class Solution {
    public Node connect(Node root) {
        if(root == null) return root;

        Node curr = root;

        while(curr != null) {

            Node nextLevelStart = new Node();
            Node prev = nextLevelStart;

            while(curr != null) {
                if(curr.left != null) {
                    prev.next = curr.left;
                    prev = prev.next;
                }
                if(curr.right != null) {
                    prev.next = curr.right;
                    prev = prev.next;
                }
                curr = curr.next;
            }
            curr = nextLevelStart.next;

        }

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
};

