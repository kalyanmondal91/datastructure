package com.github.binarysearch;

public class PeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1< right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // descending
                right = mid;
            } else {
                // ascending
                left = mid;
            }
        }
        if (nums[left] >= nums[right]) {
            return left;
        }
        return right;
    }
}
