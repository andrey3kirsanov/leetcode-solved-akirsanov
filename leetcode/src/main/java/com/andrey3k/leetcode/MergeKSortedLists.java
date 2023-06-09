package com.andrey3k.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		List<Integer> valuesList = new ArrayList<Integer>();

		for (ListNode currentNode : lists) {
			if (currentNode == null) {
				continue;
			}

			ListNode pointer = currentNode;

			while (pointer.next != null) {
				valuesList.add(pointer.val);
				pointer = pointer.next;
			}

			if (pointer.next == null) {
				valuesList.add(pointer.val);
			}
		}

		Collections.sort(valuesList);

		ListNode result = null;
		ListNode next = null;
		ListNode pointer = null;

		for (Integer value : valuesList) {
			if (result == null) {
				result = new ListNode(value);
				pointer = result;
			} else {
				next = new ListNode(value);
				pointer.next = next;
				pointer = pointer.next;
			}
		}

		return result;
	}
}
