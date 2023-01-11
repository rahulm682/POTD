// https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1
// Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place).
//In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
//
//If there are multiple solutions, find the lexicographically smallest one.
//
//Example 1:
//
//Input:
//n = 5
//arr[] = {1,2,3,4,5}
//Output: 2 1 4 3 5
//Explanation: Array elements after
//sorting it in wave form are
//2 1 4 3 5.

public class Day10_Q1 {
    public static void main(String[] args) {

    }

    public static void convertToWave(int n, int[] a) {
        for(int i=0;i+1<n;i+=2) {
            int temp = a[i];
            a[i] = a[i+1];
            a[i+1] = temp;
        }
    }
}
