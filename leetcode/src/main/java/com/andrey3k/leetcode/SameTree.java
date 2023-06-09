package com.andrey3k.leetcode;

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null && q != null) {
			return false;
		}
		if (p != null && q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}
		if (p.left != null && q.left != null && p.right != null && q.right != null) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		if (p.left != null && q.left != null && p.right == null && q.right == null) {
			return isSameTree(p.left, q.left);
		}
		if (p.left == null && q.left == null && p.right != null && q.right != null) {
			return isSameTree(p.right, q.right);
		}
		if ((p.left != null && q.left == null) || (p.right == null && q.right != null)) {
			return false;
		}
		if ((p.left == null && q.left != null) || (p.right != null && q.right == null)) {
			return false;
		}
		return true;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
 		this.val = val;
		this.left = left;
		this.right = right;
	}
}