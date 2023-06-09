package com.andrey3k.leetcode;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int st = 0, las = height.length-1, max = 0;

		while (st < las) {
			if (height[st] < height[las]) {
				max = Math.max((las - st) * height[st], max);
				st++;
			} else {
				max = Math.max((las - st) * height[las], max);
				las--;
			}
		}
		return max;
	}
}
