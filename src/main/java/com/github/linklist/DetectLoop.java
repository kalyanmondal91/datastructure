package com.github.linklist;

public class DetectLoop {
    private static boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
