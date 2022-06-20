package com.github.array;

public class BuySellStock {
    public static int maxProfitOnly1(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for(int i : prices) {
            if(i < min)
                min  = i;
            if((i-min) > profit)
                profit = i-min;
        }
        return profit;
    }

    public static int maxProfitAll(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int profit = 0;
        for(int i = 0; i < prices.length-1; i++) {
            int diff = prices[i + 1] - prices[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    public static void main(String... args) {
//        int[] arr = new int[] {7,1,5,3,6,4};
        int[] arr = new int[] {4,4,6,1,1,4,2,5};
        System.out.println("Max " + maxProfitAll(arr));
    }
}
