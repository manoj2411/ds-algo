/*
    https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
*/
class BinaryTreeToDoublyLinkedList {
    public static void main(String[] args) {

    }
}

class Solution
{
    Node prev;

    Node bToDLL(Node root) {
        if(root == null) return root;

        Node dummy = new Node(-1);
        prev = dummy;

        inorder(root);

        dummy.right.left = null;
        return dummy.right;
    }

    private void inorder(Node root) {
        if(root == null) return;

        inorder(root.left);

        prev.right = root;
        root.left = prev;
        prev = prev.right;

        inorder(root.right);
    }
}

class Node {
    int val;
    Node left;
    Node right;
    Node(int v) { val = v;}
}
