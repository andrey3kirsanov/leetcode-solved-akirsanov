package com.andrey3k.leetcode;

import java.util.HashSet;

public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		if (head.next == null) {
			return false;
		}

		ListNode pointer = head;

		HashSet<ListNode> allNodes = new HashSet<ListNode>();
		allNodes.add(head);
		while (pointer.next != null && !allNodes.contains(pointer.next)) {
			allNodes.add(pointer.next);
			pointer = pointer.next;
		}

		return pointer.next != null;
	}
}
