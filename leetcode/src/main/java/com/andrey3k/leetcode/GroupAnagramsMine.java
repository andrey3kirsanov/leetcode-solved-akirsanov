package com.andrey3k.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class GroupAnagramsMine {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<String> inputArray = new ArrayList(Arrays.asList(strs));

		if (inputArray.size() == 0) {
			return Collections.emptyList();
		}

		if (inputArray.size() == 1) {
			return Arrays.asList(Arrays.asList(inputArray.get(0)));
		}

		List<List<String>> resultArray = new ArrayList<>();

		ListIterator<String> iterator = inputArray.listIterator();

		while(iterator.hasNext()) {
			String nextString = iterator.next();
			if (resultArray.isEmpty()) {
				List<String> smallList = new ArrayList<>();
				smallList.add(nextString);
				resultArray.add(smallList);
				iterator.remove();
			} else {
				insertIntoArray(resultArray, nextString);
				iterator.remove();
			}
		}

		return resultArray;
	}

	private void insertIntoArray(List<List<String>> resultArray, String inputArrayString) {
		//System.out.println("resultArray " + resultArray);
		//System.out.println("inputArrayString " + inputArrayString);

		for (List<String> list : resultArray) {
			if (list.contains(inputArrayString)) {
				list.add(inputArrayString);
				return;
			}
			if (!list.contains(inputArrayString) && isAnagram(list.get(0), inputArrayString)) {
				list.add(inputArrayString);
				return;
			}
		}

		List<String> smallList = new ArrayList<>();
		smallList.add(inputArrayString);
		resultArray.add(smallList);
	}

	private boolean isAnagram(String string1, String string2) {
		//System.out.println("s1 " + s1);
		//System.out.println("s2 " + s2);

		if (string1.equals("") && string2.equals("")) {
			return true;
		}

		char[] a1 = string1.toCharArray();
		char[] a2 = string2.toCharArray();

		Arrays.sort(a1);
		Arrays.sort(a2);

		return Arrays.equals(a1, a2);
	}
}
