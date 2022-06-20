package com.github.array;

/*
Rank Of Element
Given a stream of integers, lookup the rank of a given integer x.
Rank of an integer in-stream is “Total number of elements less than or equal to x (not including x)”.
If an element is not found in the stream or is smallest in stream, return -1.
 */
class Node {
    int data;
    Node left, right;
    int leftSize;
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.leftSize = 0;
    }
}
public class RankElement {
    public static void main(String... args) {
        int arr[] = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };
        int x = 4;

        Node root = null;
        for(int i=0; i<arr.length; i++)
            root = insert(root, arr[i]);
    }

    private static Node insert(Node root, int data) {
        if(root == null)
            return new Node(data);
        if(data <= root.data) {
            root.left = insert(root.left, data);
            root.leftSize++;
        } else  {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
