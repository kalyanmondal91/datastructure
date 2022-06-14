package com.github.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PreOrder {
    public List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        recursivePreorderTraversal(root, result);
        return result;
    }
    void recursivePreorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            recursivePreorderTraversal(root.left, result);
            recursivePreorderTraversal(root.right, result);
        }
    }

    public List<Integer> preorderTraversalItr(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}
