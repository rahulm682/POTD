// https://practice.geeksforgeeks.org/problems/who-will-win-1587115621/1
// Given an array arr[] sorted in ascending order of size N and an integer K. Check if K is present in the array or not.

public class Day7_Q1 {
    public static void main(String[] args) {

    }

//    Using the binary search algorithm as the array is sorted
    static int searchInSorted(int arr[], int N, int K) {
        int s = 0, e = N-1;
        while(s<=e) {
            int m = s+(e-s)/2;
            if(arr[m]==K) return 1;
            else if(arr[m]>K) e = m-1;
            else s = m+1;
        }

        return -1;
    }
}
