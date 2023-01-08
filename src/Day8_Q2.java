// 8-1-2023
// https://practice.geeksforgeeks.org/problems/element-appearing-once2552/0?company[]=Qualcomm&company[]=Qualcomm&difficulty[]=1&page=1&query=company[]Qualcommdifficulty[]1page1company[]Qualcomm&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=element-appearing-once

// Given a sorted array A[] of N positive integers having all the numbers occurring exactly twice, except for one number which will occur only once. Find the number occurring only once.
//
//Example 1:
//
//Input:
//N = 5
//A = {1, 1, 2, 5, 5}
//Output: 2
//Explanation:
//Since 2 occurs once, while
//other numbers occur twice,
//2 is the answer.

public class Day8_Q2 {
    public static void main(String[] args) {

    }

    public static int search(int A[], int N)
    {
        // O(N)
        // int xor = 0;
        // for(int x:A) xor = xor^x;

        // return xor;

        // O(logN) ==> binary Search
        // Try on paper first
        if(N==1) return A[0];
        int s = 0, e = N-1;
        while(s<=e) {
            int m = s+(e-s)/2;
            if(m==0 || m==N-1) return A[m];
            if(A[m]!=A[m-1] && A[m]!=A[m+1]) return A[m];

            if(m%2==0) {
                if(A[m]==A[m+1]) s = m+1;
                else e = m-1;
            } else {
                if(A[m]==A[m-1]) {
                    s = m+1;
                } else {
                    e = m-1;
                }
            }
        }
        return A[s];
    }
}
