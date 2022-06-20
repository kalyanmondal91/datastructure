package com.github.linklist;

public class SortList {
    public Node sortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = findMiddle(head);
        Node right = sortList(mid.next);
        mid.next = null;
        Node left = sortList(head);

        return merge(left, right);
    }
    private Node findMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

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
