package com.github.tree;

public class MaxPathSum {

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        int leftPath = maxPathSum(root.left);
        int rightPath = maxPathSum(root.right);
        maxSum =  Math.max(maxSum, root.val + leftPath + rightPath);
        return root.val + Math.max(leftPath, rightPath);
    }

}
