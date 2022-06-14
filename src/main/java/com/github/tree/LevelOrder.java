package com.github.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrderRec(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        levelOrderHelper(root, 0, result);
        return result;
    }
    void levelOrderHelper(TreeNode root, int depth, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(new ArrayList<Integer>());
        }
        result.get(depth).add(root.val);
        levelOrderHelper(root.left, depth + 1, result);
        levelOrderHelper(root.right, depth + 1, result);

    }

    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if(root == null)
            return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
