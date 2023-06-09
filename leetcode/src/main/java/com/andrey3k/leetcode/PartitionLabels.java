package com.andrey3k.leetcode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels {
	public List<Integer> partitionLabels(String s) {
		LinkedHashMap<Character, int[]> map = new LinkedHashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int[] range = map.getOrDefault(c, new int[]{-1, -1});
			if (range[0] == -1) {
				range[0] = i;
				range[1] = i;
			} else {
				range[1] = i;
			}
			map.put(c, range);
		}

		int[] temp = null;
		List<Integer> result = new ArrayList<>();
		for (Map.Entry<Character, int[]> entry : map.entrySet()) {
			int[] curr = entry.getValue();
			if (temp == null) {
				temp = curr;
			} else {
				if (curr[0] < temp[1]) {
					temp = new int[]{temp[0], Math.max(curr[1], temp[1])};
				} else {
					result.add(temp[1] - temp[0] + 1);
					temp = curr;
				}
			}
		}

		result.add(temp[1] - temp[0] + 1);

		return result;
	}
}
