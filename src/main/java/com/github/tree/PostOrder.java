package com.github.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PostOrder {
    public List<Integer> postorderTraversalRec(TreeNode root) {
    List<Integer> result = new ArrayList<Integer>();
    recursivePreorderTraversal(root, result);
    return result;
}
    void recursivePreorderTraversal(TreeNode root, List<Integer> result) {
        if (root != null) {
            recursivePreorderTraversal(root.left, result);
            recursivePreorderTraversal(root.right, result);
            result.add(root.val);
        }
    }

    public List<Integer> postorderTraversalItr(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }
}
