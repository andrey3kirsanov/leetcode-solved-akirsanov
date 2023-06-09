package com.andrey3k.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return Collections.emptyList();
		}

		List<Integer> numbersFromPath = new ArrayList<>();
		List<List<Integer>> allPaths = new ArrayList<>();

		recursivePathFromRootToLeaf(root, numbersFromPath, allPaths, targetSum);

		return allPaths == null ? Collections.emptyList() : allPaths;
	}

	public void recursivePathFromRootToLeaf(TreeNode root, List<Integer> numbersFromPath2, List<List<Integer>> allPaths, int targetSum) {
		if (root == null) {
			return;
		}

		List<Integer> numbersFromPath = new ArrayList<>(numbersFromPath2);

		if (root.left == null && root.right == null) {
			numbersFromPath.add(root.val);

			int counter = 0;
			for (Integer value : numbersFromPath) {
				counter = counter + value;
			}

			if (counter == targetSum) {
				allPaths.add(numbersFromPath);
			}

			numbersFromPath = new ArrayList<>();
		} else {
			numbersFromPath.add(root.val);
			recursivePathFromRootToLeaf(root.left, numbersFromPath, allPaths, targetSum);
			recursivePathFromRootToLeaf(root.right, numbersFromPath, allPaths, targetSum);
		}
	}
}
