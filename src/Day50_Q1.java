// https://leetcode.com/problems/kth-missing-positive-number/description/


// Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.
//
//Return the kth positive integer that is missing from this array.
//
//
//
//Example 1:
//
//Input: arr = [2,3,4,7,11], k = 5
//Output: 9
//Explanation: The missing positive integers are [1,5,6,8,9,10,12,13,...]. The 5th missing positive integer is 9.
//Example 2:
//
//Input: arr = [1,2,3,4], k = 2
//Output: 6
//Explanation: The missing positive integers are [5,6,7,...]. The 2nd missing positive integer is 6.
//
//
//Constraints:
//
//1 <= arr.length <= 1000
//1 <= arr[i] <= 1000
//1 <= k <= 1000
//arr[i] < arr[j] for 1 <= i < j <= arr.length
//
//
//Follow up:
//
//Could you solve this problem in less than O(n) complexity?

public class Day50_Q1 {

    public static void main(String[] args) {

    }

    public int findKthPositive(int[] arr, int k) {
        int n = arr.length, s = 0, e = n-1;

        while(s<=e) {
            int m = s+(e-s)/2;

            int missing = arr[m]-(m+1);

            if(k>missing) {
                s = m+1;
            } else {
                e = m-1;
            }
        }

        if(e==-1) {
            return k;
        }

        if(s==n) {
            return k+n;
        }

        return arr[e]+k-(arr[e]-(e+1));
    }
}
