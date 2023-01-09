// 9-1-2023
// https://practice.geeksforgeeks.org/problems/power-of-2-1587115620/1
// Given a non-negative integer N. The task is to check if N is a power of 2.
// More formally, check if N can be expressed as 2x for some x.
//
//Example 1:
//
//Input: N = 1
//Output: YES
//Explanation:1 is equal to 2
//raised to 0 (20 = 1).
//Example 2:
//
//Input: N = 98
//Output: NO
//Explanation: 98 cannot be obtained

//by any power of 2.
//
//Your Task:Your task is to complete the function isPowerofTwo() which takes n as a parameter and returns true or false
// by checking if the given number can be represented as a power of two or not.
//
//Expected Time Complexity:O(log N).
//Expected Auxiliary Space:O(1).
//
//Constraints:
//0 ≤N ≤1018
public class Day9_Q1 {
    public static void main(String[] args) {

    }

    // Function to check if given number n is a power of two.
//    if any number is power of 2 the (n&(n-1))==0 will be true else false
    public static boolean isPowerofTwo(long n){
        if(n==0) return false;
        return (n&(n-1))==0;

    }
}
