package com.github.tree;

import java.util.ArrayList;
import java.util.List;

public class VerticalOrder {

    public List<List<Integer>> verticalOrderRec(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        verticalOrderHelper(root, 0, result);
        return result;
    }
    void verticalOrderHelper(TreeNode root, int horizontalDist, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (horizontalDist == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(horizontalDist).add(root.val);
        verticalOrderHelper(root.left, horizontalDist - 1, result);
        verticalOrderHelper(root.right, horizontalDist + 1, result);

    }

}
