package com.andrey3k.leetcode;

import java.util.Arrays;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		char[] sCharArray = s.toCharArray();
		char[] tCharArray = t.toCharArray();

		Arrays.sort(sCharArray);
		Arrays.sort(tCharArray);

		return new String(sCharArray).equals(new String(tCharArray));
	}
}
