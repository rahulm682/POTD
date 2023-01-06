// 6-1-2023
// https://practice.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1
// Given an array arr[] of size N, check if it is sorted in non-decreasing order or not.

public class Day6_Q1 {
    public static void main(String[] args) {

    }

    boolean arraySortedOrNot(int[] arr, int n) {
        for(int i=1;i<n;i++) {
            if(arr[i]<arr[i-1]) return false;
        }
        return true;
    }
}
