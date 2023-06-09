package com.andrey3k.leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> rst = new ArrayList<>();
		if (s == null || s.length() == 0 || s.length() < p.length()) {
			return rst;
		}

		int[] map_p = new int[26];
		for (int i = 0; i < p.length(); i++) {
			map_p[p.charAt(i) - 'a']++;
		}

		for (int i = 0; i <= s.length() - p.length(); i++) {
			int[] map_s = new int[26];
			for (int j = 0; j < p.length(); j++) {
				map_s[s.charAt(i+j) - 'a']++;
			}
			if (isMatch(map_p, map_s)) {
				rst.add(i);
			}
		}
		return rst;
	}

	public boolean isMatch(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
}
