package com.github.linklist;

public class LinkList {

    Node head;

    public void push(int new_data) {

        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
