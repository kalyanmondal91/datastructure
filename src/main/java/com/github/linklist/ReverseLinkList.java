package com.github.linklist;

/*
Given a linked list, write a function to reverse liinklist.

Input: Head of following linked list
1->2->3->4->NULL
Output: Linked list should be changed to,
4->3->2->1->NULL

Input: Head of following linked list
1->2->3->4->5->NULL
Output: Linked list should be changed to,
5->4->3->2->1->NULL

Input: NULL
Output: NULL


 */

public class ReverseLinkList {

    public static void main(String ...args){

        LinkList linkList = new LinkList();
        linkList.push(9);
        linkList.push(8);
        linkList.push(7);
        linkList.push(6);
        linkList.push(5);
        linkList.push(4);
        linkList.push(3);
        linkList.push(2);
        linkList.push(1);
        linkList.push(0);

        System.out.println("Printing LinkList");
        linkList.printList(linkList.head);

        linkList.head = reverse(linkList.head);

        System.out.println("Printing LinkList");
        linkList.printList(linkList.head);

    }

    private static Node reverse(Node head) {
        if(head == null || head.next == null)
            return head;

        Node rest = reverse(head.next);
        head.next.next = head;

        head.next = null;
        return rest;
    }

}
