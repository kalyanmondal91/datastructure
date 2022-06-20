package com.github.linklist;

import java.util.List;

public class MergeKList {
    
    private Node merge(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node pointer = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                pointer.next = head1;
                head1 = head1.next;
            } else {
                pointer.next = head2;
                head2 = head2.next;
            }
            pointer = pointer.next;
        }

        if (head1 != null) {
            pointer.next = head1;
        } else {
            pointer.next = head2;
        }

        return dummy.next;
    }

    private Node mergeHelper(List<Node> lists, int start, int end) {
        if(start == end)
            return lists.get(start);
        int mid = start + (end - start) / 2;
        Node left = mergeHelper(lists, start, mid);
        Node right = mergeHelper(lists, mid + 1, end);
        return merge(left, right);
    }

    public Node mergeKLists(List<Node> lists) {
        if (lists.size() == 0) {
            return null;
        }
        if (lists.size() == 1) {
            return lists.get(0);
        }
        if (lists.size() == 2) {
            return merge(lists.get(0), lists.get(1));
        }
        return mergeHelper(lists, 0, lists.size()-1);
    }


}
