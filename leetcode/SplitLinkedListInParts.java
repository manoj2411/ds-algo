import java.util.*;

/*
	https://leetcode.com/problems/split-linked-list-in-parts/
*/
class SplitLinkedListInParts {
	public static void main(String[] args) {
		var head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		var result = new Solution().splitListToParts(head, 5);
		for(ListNode lhead : result) {
			System.out.print(toList(lhead));
		}
		System.out.println();
	}

	static List<Integer> toList(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}
		return list;
	}
}


class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];
        int len = findLen(head);
        // System.out.println(len);

        int rem = len % k ;
        ListNode curr = head;
        int ri = 0;

        while(curr != null) {
            var emptyHead = new ListNode();
            var prev = emptyHead;

            for(int i = 0; curr != null && i < (len / k); i++) {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
            }

            if (rem > 0 && curr != null) {
                prev.next = curr;
                prev = curr;
                curr = curr.next;
                rem--;
            }

            prev.next = null;
            result[ri++] = emptyHead.next;
        }

        return result;
    }
    private int findLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
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

    public String toString() { return "" + val; }
}
