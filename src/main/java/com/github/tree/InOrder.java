package com.github.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrder {

    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        recursiveInorderTraversal(root, result);
        return result;
    }
    void recursiveInorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            if (root.left != null) {
                recursiveInorderTraversal(root.left, result);
            }
            result.add(root.val);
            if (root.right != null) {
                recursiveInorderTraversal(root.right, result);
            }
        }
    }

    public List < Integer > inorderTraversalItr(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}
