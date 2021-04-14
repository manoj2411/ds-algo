import java.util.*;

/*
		https://leetcode.com/problems/partition-list/
*/
class PartitionList {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		head = new Solution().partition(head, 3);
		System.out.println(toList(head));
		// [1,2,2,4,3,5]
	}

	static List<Integer> toList(ListNode head) {
		List<Integer> list = new LinkedList<>();

		while (head != null) {
			list.add(head.val);
			head = head.next;
		}

		return list;
	}
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode();
        ListNode currLess = less;
        ListNode gteq = new ListNode();
        ListNode currGteq = gteq;
        ListNode curr = head;

        while(curr != null) {

            if (curr.val < x) {
                currLess.next = curr;
                currLess = currLess.next;
            } else {
                currGteq.next = curr;
                currGteq = currGteq.next;
            }

            curr = curr.next;
        }
        currGteq.next = null;
        currLess.next = gteq.next;

        return less.next;

    }
}

/**
 * Definition for singly-linked list.
*/
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
}

