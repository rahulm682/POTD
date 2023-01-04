// https://leetcode.com/problems/rotate-image/description/
// You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//        You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
//        DO NOT allocate another 2D matrix and do the rotation.
//

public class Day4_Q2 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n-i;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = temp;
            }
        }

        for(int j=0;j<n;j++) {
            for(int i=0;i<n/2;i++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
    }
}
