package com.github.dp;

/*
Given two sequences, find the length of longest subsequence present in both of them.
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.

LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.

 */
public class LongestCommonSubSequecne {

    public static void main(String args[]){
        String X = "AGGTAB";
        String Y = "GXTXAYB";
        System.out.println("Length of LCS is " + lcs(X, Y));

    }

    private static int lcs(String x, String y) {
        int m = x.length();
        int n = y.length();

        int L[][] = new int[m+1][n+1];

        for (int i=0; i<=m; i++) {
            for (int j=0; j<=n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (x.charAt(i-1) == y.charAt(j-1))
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        return L[m][n];
    }
}
