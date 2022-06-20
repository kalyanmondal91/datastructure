package com.github.binarysearch;

public class SearchRange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int leftIdx = leftIndexSearch(nums, target);
        int rightIdx = rightIndexSearch(nums, target);
        result[0] = leftIdx;
        result[1] = rightIdx;
        return result;
    }

    private int leftIndexSearch(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    private int rightIndexSearch(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (target >= nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
