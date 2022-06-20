package com.github.tree;

public class Heap {
    private int[] arr;
    private int size;
    private int capacity;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    public void insert(int x)  {
        if(isFull())
            throw new ArrayIndexOutOfBoundsException("Heap Full");
        arr[size++] = x;
        heapifyUp();
    }
    private void heapifyUp() {
        int index = size - 1;
        while(hasParent(index) && arr[getParentIndex(index)] < arr[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
    private void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
    private boolean isFull() {
        return size == capacity;
    }
    private int getLeftChildIndex(int index) {
        return 2*index + 1;
    }
    private int getRightChildIndex(int index) {
        return 2*index + 1;
    }
    private int getParentIndex(int index) {
        return (index-1)/2;
    }
    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }
    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }
    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }
    public static void main(String... args) {

    }
}
