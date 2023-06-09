package com.andrey3k.leetcode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode pointer = head;
		ListNode result = head;
		ListNode root = new ListNode(head.val);
		while (pointer.next != null) {
			result = new ListNode(pointer.next.val, result == head ? root : result);
			pointer = pointer.next;
		}

		return result;
	}
}
