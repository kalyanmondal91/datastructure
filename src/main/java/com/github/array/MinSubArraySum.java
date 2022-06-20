package com.github.array;

public class MinSubArraySum {
    public int minSubArray(int[] nums) {
        int minSum = nums[0];
        int sum, prevMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.min(nums[i], nums[i] + prevMin);
            prevMin = sum;
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }
}
