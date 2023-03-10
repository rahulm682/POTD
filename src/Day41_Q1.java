// https://leetcode.com/problems/sqrtx/description/
// Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
//
//You must not use any built-in exponent function or operator.
//
//For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
//
//
//Example 1:
//
//Input: x = 4
//Output: 2
//Explanation: The square root of 4 is 2, so we return 2.
//Example 2:
//
//Input: x = 8
//Output: 2
//Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
//
//
//Constraints:
//
//0 <= x <= 231 - 1

public class Day41_Q1 {
    public static void main(String[] args) {

    }

    public int mySqrt(int x) {
        if(x==0 || x==1) return x;

        int s = 1, e = x;

        while(s<=e) {
            int m = s+(e-s)/2;

            if(m<=x/m && (m+1)>x/(m+1)) return m;
            else if(m>x/m) e = m-1;
            else s = m+1;
        }

        return -1;
    }
}
