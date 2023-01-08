// 8-1-2023
// https://practice.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1

// Given an array arr[] of N positive integers. Push all the zeros of the given array to the right end of the array while maitaining the order of non-zero elements.
//
//
//Example 1:
//
//Input:
//N = 5
//Arr[] = {3, 5, 0, 0, 4}
//Output: 3 5 4 0 0
//Explanation: The non-zero elements
//preserve their order while the 0
//elements are moved to the right.

public class Day8_Q1 {

    public static void main(String[] args) {

    }

    void pushZerosToEnd(int[] arr, int n) {
        for(int i=0;i<n;i++) {
            if(arr[i]==0) {
                arr[i] = -1;
            }
        }

        int i=0, j=0;
        while(i<n && arr[i]!=-1) i++;
        j = i+1;
        while(j<n && arr[j]==-1) j++;

        while(j<n) {
            if(arr[j]==-1) j++;
            else {
                arr[i] = arr[j];
                arr[j] = -1;
                i++;
                j++;
            }
        }

        while(i<n) {
            arr[i++] = 0;
        }
    }
}
