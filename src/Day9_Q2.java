// 9-1-2023
// https://practice.geeksforgeeks.org/problems/sum-of-primes0042/1
// Your task is to calculate sum  of primes present as digits of given number N.
//
//Example 1:
//
//Input: 333
//Output: 9
//Explaination: 3 is a prime number. It
//is present 3 times. So 3+3+3 = 9.
//Example 2:
//
//Input: 686
//Output: 0
//Explaination: Neither 6 nor 8 is a
//prime number.
//Your Task:
//You do not need to read input or print anything. Your task is to complete the function primeSum() which takes N
// as input parameter and returns the sum of all the prime digits present in the number N.
//
//Expected Time Complexity: O(logN)
//Expected Auxiliary Space: O(1)
//
//Constraints:
//1 ≤ N ≤ 5*104
public class Day9_Q2 {
    public static void main(String[] args) {

    }

    static int primeSum(int n){
        boolean[] prime = new boolean[10];
        prime[2] = true;
        prime[3] = true;
        prime[5] = true;
        prime[7] = true;

        int ans = 0;
        while(n>0) {
            int d = n%10;
            if(prime[d]) ans+=d;
            n = n/10;
        }

        return ans;
    }
}
