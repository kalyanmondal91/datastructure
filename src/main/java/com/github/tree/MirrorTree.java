package com.github.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorTree {

    public boolean isSymmetricRec(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        return isMirror(node1.left, node2.right) && isMirror(node1.right, node2.left);
    }

    public boolean isSymmetricItr(TreeNode root) {
        if (root == null)
            return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);
        while (!q.isEmpty()) {
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
            if (n1 == null && n2 == null)
                continue;
            if (n1 == null && n2 != null)
                return false;
            if (n1 != null && n2 == null)
                return false;
            if (n1.val != n2.val)
                return false;
            q.offer(n1.left);
            q.offer(n2.right);
            q.offer(n1.right);
            q.offer(n2.left);
        }
        return true;
    }
}
