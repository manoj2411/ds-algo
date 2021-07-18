import java.util.*;

/*
	https://leetcode.com/problems/reverse-nodes-in-k-group/
*/
class ReverseNodesInKGroup {
	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		var result = new Solution().reverseKGroup(head, 3);

		System.out.println(toList(result)); // [ 3,2,1,4,5 ]

	}

	static List<Integer> toList(ListNode node) {
		List<Integer> res = new ArrayList<>();

		while(node != null) {
			res.add(node.val);
			node = node.next;
		}
		return res;
	}
}

class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        ListNode curr = head;
        for(int i = 1; i < k && curr != null; i++) {
            curr = curr.next;
        }

        // list doesn't K elements, so no need to sort
        if (curr == null) return head;

        ListNode next = curr.next;
        curr.next = null;
        ListNode newHead = reverse(head);

        head.next = reverseKGroup(next, k);

        return newHead;
    }

    ListNode reverse(ListNode head) {
        if ( head == null || head.next == null) return head;

        ListNode newHead = reverse(head.next);

        head.next.next = head;
        head.next = null;
        return newHead;
    }
}

/**		Definition for singly-linked list.	*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}
