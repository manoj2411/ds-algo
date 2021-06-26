import java.util.*;

/*
	https://leetcode.com/problems/reverse-linked-list-ii/
*/
class ReverseLinkedListII {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println("Original list: " + toList(head));
		head = new Solution().reverseBetween(head, 2, 4);
		System.out.println("Reversed list: " + toList(head)); // [1,4,3,2,5]
	}

	static List<Integer> toList(ListNode node) {
		List<Integer> list = new ArrayList<>();
		while(node != null) {
			list.add(node.val);
			node = node.next;
		}
		return list;
	}
}

/*		One pass solution	 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        // parts : a, b, c

        ListNode prev = null;
        ListNode curr = head;
        for(int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode lasta = prev;
        ListNode lastb = curr;

        // do reverse list from left to right
        prev = null;
        for(int i = left; i <= right; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // link reversed list
        lastb.next = curr;

        if (left > 1) {
            lasta.next = prev;
            return head;
        }

        return prev;
    }
}

/**		Definition for singly-linked list.		*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}
