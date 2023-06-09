package com.andrey3k.leetcode;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return false;
		}
		if (root.left == null && root.right == null) {
			return true;
		}
		if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
			return false;
		}

		return checkSymmetricOrNot(root.left, root.right);
	}

	private boolean checkSymmetricOrNot(TreeNode left, TreeNode right) {
		//System.out.println(left.val + " " + right.val);
		if (left.val != right.val) {
//            System.out.println("1");
			return false;
		}
		if ((left.left == null && right.right != null) || (left.left != null && right.right == null)
				|| (left.right != null && right.left == null) || (left.right == null && right.left != null)) {
//            System.out.println("2");
			return false;
		}
		if ((left.left != null && right.right != null && left.left.val != right.right.val) ||
				(left.right != null && right.left != null && left.right.val != right.left.val)) {
//            System.out.println("3");
			return false;
		}
		if ((left.left != null && right.right != null && left.left.val == right.right.val) &&
				(left.right != null && right.left != null && left.right.val == right.left.val)) {
//            System.out.println("4");
			return checkSymmetricOrNot(left.left, right.right) && checkSymmetricOrNot(left.right, right.left);
		}
		if (left.left != null && right.right != null && left.left.val == right.right.val) {
//            System.out.println("5");
//            System.out.println(left.left.val + " " + right.right.val);
			return checkSymmetricOrNot(left.left, right.right);
		}
		if (left.right != null && right.left != null && left.right.val == right.left.val) {
//            System.out.println("6");
//            System.out.println(left.right.val + " " + right.left.val);
			return checkSymmetricOrNot(left.right, right.left);
		}
		return true;
	}
}
