/*
	https://leetcode.com/problems/intersection-of-two-linked-lists/
*/
class IntersectionOfTwoLinkedLists {

	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		headA.next = new ListNode(9);
		headA.next.next = new ListNode(3);
		headA.next.next.next = new ListNode(3);
		headA.next.next.next.next = new ListNode(2);
		headA.next.next.next.next.next = new ListNode(4);

		ListNode headB = new ListNode(3);
		headB.next = headA.next.next.next.next; // node with value 2

		ListNode intersection = new Solution().getIntersectionNode(headA, headB);

		String msg;
		if (intersection == null)
			msg = "No intersection node";
		else
			msg = "Reference of the node with value: " + intersection.val;

		System.out.println(msg); // 2
	}
}


class Solution {
	/*	complexity of solution:

			time: 	O(n)
			space: 	O(1)

	*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = findLength(headA);
        int lenB = findLength(headB);

        if(lenA >= lenB)
            return helper(headA, lenA, headB, lenB);

        return helper(headB, lenB, headA, lenA);
    }


    private ListNode helper(ListNode headA, int lenA, ListNode headB, int lenB) {
        ListNode currA = headA;
        ListNode currB = headB;

        for(int i = 0; i < lenA - lenB; i++)
            currA = currA.next;

        while (currA != null && currB != null) {
            if (currA == currB) return currA;

            currA = currA.next;
            currB = currB.next;
        }

        return null;
    }

    private int findLength(ListNode head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }
}

/**
 * Definition for singly-linked list.
*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
