package com.github.tree;

public class Diameter {
    public int diameter(TreeNode root) {
        if (root == null)
            return 0;
        int lheight = height(root.left);
        int rheight = height(root.right);

        int ldiameter = diameter(root.left);
        int rdiameter = diameter(root.right);

        return Math.max(lheight + rheight + 1,
                Math.max(ldiameter, rdiameter));
    }

    public int height(TreeNode node) {
        /* base case tree is empty */
        if (node == null)
            return 0;

        /* If tree is not empty then height = 1 + max of left
        height and right heights */
        return (1 + Math.max(height(node.left), height(node.right)));
    }
}
