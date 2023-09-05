import java.util.*;

/*
    https://leetcode.com/problems/copy-list-with-random-pointer/
*/
class CopyListwithRandomPointer {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.random = head.next.next;
        head.next.random = head.next;
        head.next.next.random = head.next;

        Node newHead = (new Solution().copyRandomList(head));

        System.out.println(newHead.random.val); // 3
        System.out.println(newHead.next.random.val); // 2
        System.out.println(newHead.next.next.random.val); // 2
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Map<Node, Node> clonned = new HashMap<>();

        Node dummy = new Node(-1);

        Node curr = head;
        Node prev = dummy;

        while(curr != null) { // clonning list without setting random

            Node node = new Node(curr.val);
            prev.next = node;

            clonned.put(curr, node);

            prev = prev.next;
            curr = curr.next;

        }

        curr = head;
        while(curr != null) { // setting random pointer

            clonned.get(curr).random = clonned.get(curr.random);
            curr = curr.next;

        }

        return dummy.next;
    }
}

class SpaceOptimisedSolution {
    // solution using constant space!
    //
    public Node copyRandomList(Node head) {

        // step 1 - add clone in between nodes.

        Node curr = head;

        while(curr != null) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
            curr = clone.next;
        }

        // step 2 - random pointers for cloned nodes!
        curr = head;
        while(curr != null) {
            Node clone = curr.next;
            if (curr.random != null) {
                clone.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // step 3 - untangle clonned nodes and reset next pointer
        curr = head;
        Node dummy = new Node(0);
        Node clonned = dummy;
        while(curr != null) {
            clonned.next = curr.next;
            curr.next = curr.next.next;
            curr = curr.next;
            clonned = clonned.next;
        }

        return dummy.next;

    }
}

/*
     Definition for a Node.
*/
class Node {
    int val;
    Node next;
    Node random;
    public Node(int val) { this.val = val; }
}
