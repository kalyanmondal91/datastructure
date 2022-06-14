package com.github.dp;

/*

Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of
minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse
through that cell.
 */
public class MinCost {

    public static void main(String args[]) {
        int cost[][]= {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println(minCost(cost,cost.length - 1, cost[0].length - 1));
    }

    private static int minCost(int[][] cost, int m, int n) {

        int i, j;
        int tc[][]=new int[m+1][n+1];

        tc[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
        for (i = 1; i <= m; i++)
            tc[i][0] = tc[i-1][0] + cost[i][0];

        /* Initialize first row of tc array */
        for (j = 1; j <= n; j++)
            tc[0][j] = tc[0][j-1] + cost[0][j];

        /* Construct rest of the tc array */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                tc[i][j] = Math.min(tc[i-1][j-1], Math.min(tc[i-1][j], tc[i][j-1])) + cost[i][j];

        return tc[m][n];
    }
}
