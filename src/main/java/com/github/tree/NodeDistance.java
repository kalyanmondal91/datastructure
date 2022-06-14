package com.github.tree;

public class NodeDistance {
    public int findDistance(TreeNode root, int a, int b) {
        TreeNode lca = lowestCommonAncestor(root, a, b);
        int d1 = findLevel(lca,a);
        int d2 = findLevel(lca,b);
        return d1+d2;
    }

    public int findLevel(TreeNode root, int val) {
        if (root == null)
            return -1;
        if (root.val == val)
            return 0;
        if(root.val > val) {
            int left = findLevel(root.left, val);
            if(left < 0)
                return -1;
            return left + 1;
        } else {
            int right = findLevel(root.right, val);
            if(right < 0)
                return -1;
            return right + 1;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, int p, int q) {
        if(root == null)
            return null;
        if(root.val == p || root.val == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null)
            return root;
        return left != null ? left : right;
    }
}
