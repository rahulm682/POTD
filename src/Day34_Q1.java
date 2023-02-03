// https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

// Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
//
//
//
//Example 1:
//
//Input :
//N = 5
//A[] = {-8, 2, 3, -6, 10}
//K = 2
//Output :
//-8 0 -6 -6
//Explanation :
//First negative integer for each window of size k
//{-8, 2} = -8
//{2, 3} = 0 (does not contain a negative integer)
//{3, -6} = -6
//{-6, 10} = -6
//
//Example 2:
//Input :
//N = 8
//A[] = {12, -1, -7, 8, -15, 30, 16, 28}
//K = 3
//Output :
//-1 -1 -7 -15 -15 0
//
//
//Your Task:
//You don't need to read input or print anything. Your task is to complete the function printFirstNegativeInteger() which takes the array A[], its size N and an integer K as inputs and returns the first negative number in every window of size K starting from the first till the end. If a window does not contain a negative integer , then return 0 for that window.
//
//
//Expected Time Complexity: O(N)
//Expected Auxiliary Space: O(K)
//
//Constraints:
//1 <= N <= 105
//-105 <= A[i] <= 105
//1 <= K <= N

import java.util.LinkedList;
import java.util.Queue;

public class Day34_Q1 {
    public static void main(String[] args) {

    }
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Long> queue = new LinkedList<>();

        for(int i=0;i<K;i++) {
            if(A[i]<0) queue.add(A[i]);
        }

        int n = N-K+1;
        long[] ans = new long[n];
        int k = 0;

        if(queue.size()>0) {
            ans[k++] = queue.peek();
        } else {
            ans[k] = 0;
            k++;
        }

        for(int i=K;i<N;i++) {
            // add new element and remove old element if present
            if(A[i]<0) queue.add(A[i]);
            if(queue.size()>0 && A[i-K]<0) queue.poll();

            if(queue.size()>0) {
                ans[k] = queue.peek();
            } else {
                ans[k] = 0;
            }

            k++;
        }

        return ans;
    }
}
