// https://www.codechef.com/problems/GCDQ

// Problem
//Read problems statements in Mandarin Chinese and Russian.
//You are given an array A of integers of size N. You will be given Q queries where each query is represented by two integers L, R. You have to find the gcd(Greatest Common Divisor) of the array after excluding the part from range L to R inclusive (1 Based indexing). You are guaranteed that after excluding the part of the array remaining array is non empty.
//
//Input
//First line of input contains an integer T denoting number of test cases.
//For each test case, first line will contain two space separated integers N, Q.
//Next line contains N space separated integers denoting array A.
//For next Q lines, each line will contain a query denoted by two space separated integers L, R.
//Output
//For each query, print a single integer representing the answer of that query.
//Constraints
//Subtask #1: 40 points
//
//2 ≤ T, N ≤ 100, 1 ≤ Q ≤ N, 1 ≤ A[i] ≤ 105
//1 ≤ L, R ≤ N and L ≤ R
//Subtask #2: 60 points
//
//2 ≤ T, N ≤ 105, 1 ≤ Q ≤ N, 1 ≤ A[i] ≤ 105
//1 ≤ L, R ≤ N and L ≤ R
//Sum of N over all the test cases will be less than or equal to 106.
//Warning : Large IO(input output), please use faster method for IO.
//
//Sample 1:
//Input
//Output
//1
//3 3
//2 6 9
//1 1
//2 2
//2 3
//3
//1
//2
//Explanation:
//Test case
//1
//1: The given array is
//[
//2
//,
//6
//,
//9
//]
//[2,6,9].
//
//Query
//1
//1: On excluding the range
//[
//1
//,
//1
//]
//[1,1], the remaining elements are
//[
//6
//,
//9
//]
//[6,9]. The gcd of
//6
//6 and
//9
//9 is
//3
//3.
//Query
//2
//2: On excluding the range
//[
//2
//,
//2
//]
//[2,2], the remaining elements are
//[
//2
//,
//9
//]
//[2,9]. The gcd of
//2
//2 and
//9
//9 is
//1
//1.
//Query
//3
//3: On excluding the range
//[
//2
//,
//3
//]
//[2,3], the remaining elements are
//[
//2
//]
//[2]. The gcd of
//2
//2 is
//2
//2.


import java.lang.*;
import java.io.*;

class Day20_Q2 {
    public static void main (String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]), q = Integer.parseInt(s[1]);

            s = br.readLine().split(" ");
            int[] arr = new int[n+10];
            for(int i=1;i<=n;i++) {
                arr[i] = Integer.parseInt(s[i-1]);
            }

            int[] left = new int[n+10], right = new int[n+10];

            left[1] = arr[1];
            for(int i=2;i<=n;i++) {
                left[i] = gcd(left[i-1], arr[i]);
            }

            right[n] = arr[n];
            for(int i=n-1;i>=1;i--) {
                right[i] = gcd(right[i+1], arr[i]);
            }
            // System.out.println(Arrays.toString(left));
            // System.out.println(Arrays.toString(right));

            while(q-->0) {
                s = br.readLine().split(" ");
                int l = Integer.parseInt(s[0]), r = Integer.parseInt(s[1]);

                System.out.println(gcd(left[l-1], right[r+1]));
            }
        }
    }

    static int gcd(int a, int b) {
        if(a==0) return b;
        return gcd(b%a, a);
    }
}
