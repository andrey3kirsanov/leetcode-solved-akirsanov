package com.andrey3k.leetcode;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		for (int row = 0; row < matrix.length; row++) {
			Set<Integer> set = Arrays.stream(matrix[row]).boxed().collect(Collectors.toSet());

			if (set.contains(target)) {
				return true;
			}
		}
		return false;
	}
}
