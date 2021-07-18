import java.util.*;

class ReverseOperations {
	public static void main(String[] args) {

    	Node head = new Node(1);
    	head.next = new Node(2);
    	head.next.next = new Node(8);
    	head.next.next.next = new Node(9);
    	head.next.next.next.next = new Node(12);
    	head.next.next.next.next.next = new Node(16);

    	var result = new Main().reverse(head);
    	System.out.println(toList(result));
    	//[ 1, 8, 2, 9, 16, 12 ]
	}

	static List<Integer> toList(Node node) {
		List<Integer> res = new ArrayList<>();

		while(node != null) {
			res.add(node.data);
			node = node.next;
		}
		return res;
	}
}

class Main {


  Node reverseEvens(Node node) {
    if (node == null || node.next == null) return node;

    Node newHead = reverseEvens(node.next);

    node.next.next = node;
    node.next = null;
    return newHead;

  }

  Node reverse(Node head) {
    // Write your code here
    Node dummy = new Node(-1);
    Node prev = dummy;

    Node curr = head;

    while(curr != null) {

      // traverse all odds until find even or end of list
      while(curr!= null && curr.data % 2 == 1) {
        prev.next = curr;
        prev = prev.next;
        curr = curr.next;
      }

      // reach to end of list
      if (curr == null) break;

      Node firstEvenNode = curr;

      // move until next is null or odd
      while(curr.next != null && curr.next.data % 2 == 0) {
        curr = curr.next;
      }

      // remove next link from list so that it can be reversed
      Node next = curr.next;
      curr.next = null;

      // prev has possible odd node
      prev.next = reverseEvens(firstEvenNode);

      // firstEvenNode will be the last node after reverse, so link the list to the next node
      firstEvenNode.next = next;
      prev = firstEvenNode;
      curr = next;

    }

    return dummy.next;
  }

}

class Node {
    int data;
    Node next;
    Node(int x) {
      data = x;
      next = null;
    }
}
