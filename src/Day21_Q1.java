// https://leetcode.com/problems/counting-bits/description/

// Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
//
//
//
//Example 1:
//
//Input: n = 2
//Output: [0,1,1]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//Example 2:
//
//Input: n = 5
//Output: [0,1,1,2,1,2]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
//
//
//Constraints:
//
//0 <= n <= 105
//
//
//Follow up:
//
//It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
//Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?

public class Day21_Q1 {
    public static void main(String[] args) {

    }

    // for every odd number the number of set bits will always be +1 the previous bit
// as previous is even and adding 1 to it makes it odd and therefore setbits = prev + 1


// but for even number # of set bits will be equal to set bit in n/2
// i.e. 9 = 1001 and 18 = 10010 ==> 9->2 and 18->2
// 14 = 1110 and 28 = 11100 because we know that left shift multiply n by 2 and bits represent shifht left by 1 and
// add a 0 at LSB   ===> # of set bits is same only
// therefore we can conclude that if i is even then i and i/2 will have same # of setbits

    public int[] countBits(int n) {
        if(n==0) return new int[]{0};
        if(n==1) return new int[]{0,1};

        int arr[] = new int[n+1];
        arr[0] = 0;arr[1] = 1;
        for(int i=2;i<=n;i++) {
            if(i%2==0) arr[i] = arr[i/2];
            else arr[i] = 1 + arr[i-1];
        }
        return arr;
    }
}
