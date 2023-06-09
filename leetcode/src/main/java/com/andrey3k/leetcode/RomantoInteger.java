package com.andrey3k.leetcode;

import java.util.Map;

public class RomantoInteger {
	private static final Map<String, Integer> mainCases = Map.of("I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000);

	private static final Map<String, Integer> edgeCases = Map.of("IV", 4, "IX", 9, "XL", 40, "XC", 90, "CD", 400, "CM", 900);

	public int romanToInt(String s) {

		char firstChar;
		char secondChar;
		Integer finalResult = 0;

		for (Map.Entry<String, Integer> entry : edgeCases.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();

			int numberOfMatches = 0;
			while (s.contains(key)) {
				s = s.replaceFirst(key, "");
				numberOfMatches++;
			}

			finalResult = finalResult + (numberOfMatches * value);
		}

		for (Map.Entry<String, Integer> entry : mainCases.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();

			int numberOfMatches = 0;
			while (s.contains(key)) {
				s = s.replaceFirst(key, "");
				numberOfMatches++;
			}

			finalResult = finalResult + (numberOfMatches * value);
		}

		return finalResult;
	}
}
