package com.github.tree;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        if(root.left != null && root.left.val > root.val)
            return false;
        if(root.right != null && root.right.val < root.val)
            return false;
        if(!isValidBST(root.left) || !isValidBST(root.right))
            return false;
        return true;
    }
}
