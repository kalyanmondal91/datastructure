package com.github.array;

import java.util.Stack;

public class NextGreaterElement {
    int[] printNextGreaterElement(int arr[], int n) {
        Stack<Integer> stack = new Stack<>();
        int nge[] = new int[n];
        for (int i = 1; i < n; i++) {
            if(!stack.isEmpty()) {
                while (!stack.empty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            nge[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nge;
    }
}
