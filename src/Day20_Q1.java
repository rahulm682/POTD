// https://leetcode.com/problems/count-primes/description/

// Given an integer n, return the number of prime numbers that are strictly less than n.
//
//
//
//Example 1:
//
//Input: n = 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
//Example 2:
//
//Input: n = 0
//Output: 0
//Example 3:
//
//Input: n = 1
//Output: 0
//
//
//Constraints:
//
//0 <= n <= 5 * 106

public class Day20_Q1 {
    public static void main(String[] args) {

    }

    public int countPrimes(int n) {
        if(n<2) return 0;
        boolean[] arr = new boolean[n];

        int ans = 0;
        arr[0] = true;
        arr[1] = true;
        for(int i=2;i*i<=n;i++) {
            if(!arr[i]) {
                for(int j=i*i;j<n;j+=i) arr[j] = true;
            }
        }

        for(int i=2;i<n;i++) if(!arr[i]) ans++;

        return ans;
    }
}
