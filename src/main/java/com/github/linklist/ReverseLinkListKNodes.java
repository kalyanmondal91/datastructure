package com.github.linklist;

/*
Given a linked list, write a function to reverse every k nodes (where k is an input to the function).

Input: 1->2->3->4->5->6->7->8->NULL, K = 3
Output: 3->2->1->6->5->4->8->7->NULL
Input: 1->2->3->4->5->6->7->8->NULL, K = 5
Output: 5->4->3->2->1->8->7->6->NULL

 */

public class ReverseLinkListKNodes {

    public static void main(String ...args){

        LinkList linkList = new LinkList();
        linkList.push(10);
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

        linkList.head = reverse(linkList.head, 3);

        System.out.println("Printing LinkList");
        linkList.printList(linkList.head);
    }

    private static Node reverse(Node head, int k) {
        if(head == null)
            return null;
        Node current = head;
        Node next = null;
        Node prev = null;
        int count  = 0;
        while(count < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if(next != null) {
            head.next = reverse(next, k);
        }
        return prev;
    }

}
