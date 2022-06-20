package com.github.linklist;

public class AddList {
    private static Node reverse(Node head) {
        if(head == null || head.next == null)
            return head;

        Node rest = reverse(head.next);
        head.next.next = head;

        head.next = null;
        return rest;
    }

    public Node addLists2(Node l1, Node l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);

        return reverse(addLists(l1, l2));
    }

    public Node addLists(Node l1, Node l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        Node head = new Node(0);
        Node pointer = head;

        int carry = 0;

        while (l1 != null && l2 != null) {

            int sum = l1.data + l2.data + carry;
            carry = sum / 10;

            pointer.next = new Node(sum % 10);
            pointer = pointer.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.data + carry;
            carry = sum / 10;
            pointer.next = new Node(sum % 10);
            pointer = pointer.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.data + carry;
            carry = sum / 10;
            pointer.next = new Node(sum = sum % 10);
            pointer = pointer.next;
            l2 = l2.next;
        }

        if (carry != 0) {
            pointer.next = new Node(carry);
        }

        return head.next;
    }
}
