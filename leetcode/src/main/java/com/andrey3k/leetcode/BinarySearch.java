package com.andrey3k.leetcode;

public class BinarySearch {
	public int search(int[] nums, int target) {
		int first = 0;
		int last = nums.length - 1;
		int mid = (first + last) / 2;
		int result = 0;

		while(first <= last) {
			if (nums[mid] < target) {
				first = mid + 1;
			} else if (nums[mid] == target) {
				result = mid;
				break;
			} else {
				last = mid - 1;
			}
			mid = (first + last) / 2;
		}

		if (first > last) {
			return -1;
		}

		return result;
	}
}
