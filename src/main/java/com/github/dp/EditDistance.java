package com.github.dp;

/*
Given two strings str1 and str2 and below operations that can be performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.


 */
public class EditDistance {
    public static void main(String args[]) {
        String str1 = "sunday";
        String str2 = "saturday";
        
        System.out.println(editDist(str1, str2, str1.length(), str2.length()));
    }

    private static int editDist(String str1, String str2, int m, int n) {
        int dp[][] = new int[m + 1][n + 1];

        // Fill d[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j; // Min. operations = j

                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                else if (str1.charAt(i - 1) == str2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                else
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
            }
        }

        return dp[m][n];
    }
}
