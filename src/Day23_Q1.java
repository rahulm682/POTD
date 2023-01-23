import java.util.HashMap;
// https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

// Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
//
//Example 1:
//
//Input:
//N = 8
//A[] = {15,-2,2,-8,1,7,10,23}
//Output: 5
//Explanation: The largest subarray with
//sum 0 will be -2 2 -8 1 7.
//Your Task:
//You just have to complete the function maxLen() which takes two arguments an array A and n, where n is the size of the array A and returns the length of the largest subarray with 0 sum.
//
//Expected Time Complexity: O(N).
//Expected Auxiliary Space: O(N).
//
//Constraints:
//1 <= N <= 105
//-1000 <= A[i] <= 1000, for each valid i

public class Day23_Q1 {
    public static void main(String[] args) {

    }

    // initially the sum is 0 at -1 index
    // and as we move in array we calculate and store the sum along with its index if it has not occured
    // and when the sum occurs again we calculate the max len from it


    int maxLen(int arr[], int n) {
        // Your code here
        int sum = 0, len = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);
        for(int i=0;i<n;i++) {
            sum+=arr[i];
            if(!mp.containsKey(sum)) mp.put(sum, i);

            len = Math.max(len, i-mp.get(sum));
        }

        return len;
    }
}
