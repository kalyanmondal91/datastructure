package com.github.array;

public class MaxSubArraySum {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(sum > 0)
                sum = nums[i] + sum;
            else
                sum = nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
