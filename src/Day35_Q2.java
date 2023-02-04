
// You are given an m x n integer matrix grid.
//
//We define an hourglass as a part of the matrix with the following form:
//
//
//Return the maximum sum of the elements of an hourglass.
//
//Note that an hourglass cannot be rotated and must be entirely contained within the matrix.
//
//
//
//Example 1:
//
//
//Input: grid = [[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]
//Output: 30
//Explanation: The cells shown above represent the hourglass with the maximum sum: 6 + 2 + 1 + 2 + 9 + 2 + 8 = 30.
//Example 2:
//
//
//Input: grid = [[1,2,3],[4,5,6],[7,8,9]]
//Output: 35
//Explanation: There is only one hourglass in the matrix, with the sum: 1 + 2 + 3 + 5 + 7 + 8 + 9 = 35.
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//3 <= m, n <= 150
//0 <= grid[i][j] <= 106
public class Day35_Q2 {
    public static void main(String[] args) {

    }

    public int maxSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;

        int[][] prefix = new int[n+1][m+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                prefix[i][j] = prefix[i][j-1]+grid[i-1][j-1];
            }
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1;i<=n-2;i++) {
            for(int j=3;j<=m;j++) {
                int a = prefix[i][j] - prefix[i][j-3];
                int b = grid[i][j-2];
                int c = prefix[i+2][j] - prefix[i+2][j-3];

                ans = Math.max(ans, a+b+c);
            }
        }

        return ans;
    }

}
