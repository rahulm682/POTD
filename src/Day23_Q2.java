// https://leetcode.com/problems/spiral-matrix/description/
// Given an m x n matrix, return all elements of the matrix in spiral order.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [1,2,3,6,9,8,7,4,5]
//Example 2:
//
//
//Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 10
//-100 <= matrix[i][j] <= 100

import java.util.ArrayList;
import java.util.List;

public class Day23_Q2 {
    public static void main(String[] args) {

    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, right = n-1, bottom = m-1, left = 0;

        while(true) {
            for(int i=left;i<=right;i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            if(top>bottom) break;

            for(int i=top;i<=bottom;i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if(left>right) break;

            for(int i=right;i>=left;i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            if(top>bottom) break;

            for(int i=bottom;i>=top;i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            if(left>right) break;

        }
        return ans;
    }
}
