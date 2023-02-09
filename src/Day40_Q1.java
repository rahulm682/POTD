// https://practice.geeksforgeeks.org/problems/90a81c305b1fe939b9230a67824749ceaa493eab/1

// Suppose you have a Matrix size n*n, and given an integer k and a set of coordinates arr of size k*2. Initially, the matrix contains only 0. You are given k tasks and for each task, you are given two coordinates (r = arr[i][0],c = arr[i][1]) [1 based index r and c]. Where coordinates (r,c) denotes rth row and cth column of the given matrix.
//
//You have to perform each task sequentially in the given order. For each task, You have to put 1 in all rth row cells and all cth columns cells.
//
//After each task, You have to calculate the number of 0 present in the matrix and return it.
//
//Example 1:
//
//Input:
//n = 3, k= 3
//arr =
//{{2, 2},
// {2, 3},
// {3, 2}}
//Output: 4 2 1
//Explanation:
//After 1st Operation, all the 2nd row
//and all the 2nd column will be filled by
//1. So remaning cell with value 0 will be 4
//After 2nd Operation, all the 2nd row and all
//the 3rd column will be filled by 1. So
//remaning cell with value 0 will be 2.
//After 3rd Operation cells having value 0 will
//be 1.
//Example 2:
//
//Input:
//n = 2, k = 2
//arr =
//{{1, 2},
// {1, 1}}
//Output: 1 0
//Explanation:
//After 1st Operation, all the 1st row and
//all the 2nd column will be filled by 1.
//So remaning cell with value 0 will be 1.
//After 2nd Operation, all the 1st row and
//all the 1st column will be filled by 1.
//So remaning cell with value 0 will be 0.
//Your Task:
//The task is to complete the function countZero(), which takes parameter n, size of
//the matrix, k no of operation and array arr[][], which denotes the position of the cells.
//You have to return an array that contains all the results.
//
//Expected Time Complexity: O( k ).
//Expected Auxiliary Space: O( n+n+k ).
//
//Constraints:
//1 <= n, k <= 105
//1 <= r, c <= n

import java.util.HashSet;
import java.util.Set;

public class Day40_Q1 {
    public static void main(String[] args) {

    }

    long[] countZero(int n, int k, int[][] arr){
        // code here

        // Brute force
        // int[][] mat = new int[n][n];
        // long[] ans = new long[k];

        // for(int i=0;i<k;i++) {
        //     change(mat, arr[i][0], arr[i][1]);
        //     ans[i] = count(mat);
        // }

        // return ans;



        // Optimised Method
        int rows = 0, cols = 0;
        Set<Integer> r = new HashSet<>(), c = new HashSet<>();
        long[] ans = new long[k];
        long total = n*n, rem = total;;

        for(int i=0;i<k;i++) {
            int row = arr[i][0]-1, col = arr[i][1]-1;
            if(i==0) {
                ans[i] = total-(2*n-1);
                rem = ans[i];
                r.add(row);
                c.add(col);
                rows++;
                cols++;
            } else {
                if(!r.contains(row) && !c.contains(col)) {
                    ans[i] = rem-(n-rows + n-cols - 1);
                    rem = ans[i];
                    r.add(row);
                    c.add(col);
                    rows++;
                    cols++;
                } else if(!r.contains(row)) {
                    ans[i] = rem-(n-cols);
                    rem = ans[i];
                    rows++;
                    r.add(row);
                } else if(!c.contains(col)) {
                    ans[i] = rem-(n-rows);
                    rem = ans[i];
                    cols++;
                    c.add(col);
                } else ans[i] = rem;
            }
        }
        return ans;

    }

    long count(int[][] arr) {
        long ans = 0;

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr.length;j++) {
                if(arr[i][j]==0) ans++;
            }
        }

        return ans;
    }

    void change(int[][] arr, int row, int col) {
        for(int i=0;i<arr.length;i++) {
            arr[i][col-1] = 1;
            arr[row-1][i] = 1;
        }
    }
}
