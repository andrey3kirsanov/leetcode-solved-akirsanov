package com.andrey3k.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || nums.length < k || k <= 0)
			return new int[0];

		int left = 0, right = 0, n = nums.length;

		int[] rst = new int[n - k + 1];
		Deque<Integer> deque = new ArrayDeque<>();

		while (right < k - 1)
			inQueue(deque, nums[right++]);

		while(right < n) {
			inQueue(deque, nums[right++]);

			rst[left] = deque.peekFirst();

			outQueue(deque, nums[left++]);
		}
		return rst;
	}

	private void inQueue(Deque<Integer> deque, int num) {
		while (!deque.isEmpty() && deque.peekLast() < num) {
			deque.pollLast();
		}

		deque.offerLast(num);
	}

	private void outQueue(Deque<Integer> deque, int num) {
		if (deque.peekFirst() == num)
			deque.pollFirst();
	}
}
