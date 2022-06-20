package com.github.linklist;

public class MergeList {

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
}
