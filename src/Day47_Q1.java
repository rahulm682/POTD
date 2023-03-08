// https://leetcode.com/problems/power-of-three/description/


// Given an integer n, return true if it is a power of three. Otherwise, return false.
//
//An integer n is a power of three, if there exists an integer x such that n == 3x.
//
//
//
//Example 1:
//
//Input: n = 27
//Output: true
//Explanation: 27 = 33
//Example 2:
//
//Input: n = 0
//Output: false
//Explanation: There is no x where 3x = 0.
//Example 3:
//
//Input: n = -1
//Output: false
//Explanation: There is no x where 3x = (-1).
//
//
//Constraints:
//
//-231 <= n <= 231 - 1
//
//
//Follow up: Could you solve it without loops/recursion?

public class Day47_Q1 {
    public static void main(String[] args) {

    }

    public boolean isPowerOfThree(int n) {
        // return (Math.log10(n)/Math.log10(3))%1==0;

        if(n<=0) return false;
        return (1162261467%n)==0;
    }
}
