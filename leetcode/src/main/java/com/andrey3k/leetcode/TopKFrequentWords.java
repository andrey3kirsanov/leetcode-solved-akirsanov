package com.andrey3k.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class TopKFrequentWords {
	public List<String> topKFrequent(String[] words, int k) {
		LinkedHashMap<String, Integer> occurencesMap = new LinkedHashMap<>();

		List<Integer> maxCount = new ArrayList<>();

		for (String word : words) {
			if (occurencesMap.containsKey(word)) {
				maxCount.add(occurencesMap.get(word) + 1);
				occurencesMap.put(word, occurencesMap.get(word) + 1);
			} else {
				occurencesMap.put(word, 1);
			}
		}

		//System.out.println(occurencesMap);

		List<Map.Entry<String, Integer>> sortedEntries = new ArrayList<Map.Entry<String, Integer>>(occurencesMap.entrySet());

		Collections.sort(sortedEntries,
				new Comparator<Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
						if (e1.getValue() != e2.getValue()) {
							return e2.getValue().compareTo(e1.getValue());
						} else {
							return e1.getKey().compareTo(e2.getKey());
						}
					}
				}
		);

		//System.out.println(sortedEntries);

		List<String> resultList = new ArrayList<>();
		int i = 1;
		for (Map.Entry<String, Integer> entrySet : sortedEntries) {
			if (i <= k) {
				resultList.add(entrySet.getKey());
				i++;
			}
		}

		return resultList;
	}
}
