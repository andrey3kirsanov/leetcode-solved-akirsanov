package com.andrey3k.leetcode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		int lh; /* for height of left subtree */

		int rh; /* for height of right subtree */

		/* If tree is empty then return true */
		if (root == null)
			return true;

		/* Get the height of left and right sub trees */
		lh = height(root.left);
		rh = height(root.right);

		//System.out.println(lh);
		//System.out.println(rh);

		if (Math.abs(lh - rh) <= 1 && isBalanced(root.left)
				&& isBalanced(root.right))
			return true;

		/* If we reach here then tree is not height-balanced
		 */
		return false;
	}

	private int height(TreeNode node) {
		/* base case tree is empty */
		if (node == null)
			return 0;

        /* If tree is not empty then height = 1 + max of
         left height and right heights */
		return 1
				+ Math.max(height(node.left),
				height(node.right));
	}
}
