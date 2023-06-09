package com.andrey3k.leetcode;

import java.util.HashMap;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		HashMap<Integer, Integer> toFindDuplicates = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (toFindDuplicates.containsKey(nums[i])) {
				toFindDuplicates.remove(nums[i]);
			} else {
				toFindDuplicates.put(nums[i], nums[i]);
			}
		}

		return toFindDuplicates.keySet().iterator().next();
	}
}
