package com.andrey3k.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentElements {
	public int[] topKFrequent(int[] nums, int k) {
		if (nums == null) {
			return new int[]{};
		}

		HashMap<Integer, Integer> countsMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (countsMap.containsKey(nums[i])) {
				countsMap.put(nums[i], countsMap.get(nums[i]) + 1);
			} else {
				countsMap.put(nums[i], 1);
			}
		}

		List<Entry<Integer, Integer>> sortedEntries = new ArrayList<Entry<Integer, Integer>>(countsMap.entrySet());

		Collections.sort(sortedEntries,
				new Comparator<Entry<Integer, Integer>>() {
					@Override
					public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
						return e2.getValue().compareTo(e1.getValue());
					}
				}
		);

		int[] result = new int[k];

		int i = 0;
		for (Map.Entry<Integer, Integer> entry : sortedEntries) {
			if (i < k) {
				result[i] = entry.getKey();
			}
			i++;
		}

		return result;
	}
}
