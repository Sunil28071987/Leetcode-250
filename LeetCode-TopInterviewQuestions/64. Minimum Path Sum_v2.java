//This solution is not created by me.
//I took reference from folloing web source.
//http://buttercola.blogspot.com/2014/09/leetcode-minimum-path-sum.html


public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
         
        int[][] dp = new int[m][n];
         
        dp[0][0] = grid[0][0];;
         
        // update the first row
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
         
        // update the first column
        for (int j = 1; j < m; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }
         
        //use the previously calculated values
        //select the minimum cost to reach a perticular path.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
         
        return dp[m - 1][n - 1];
    }
}