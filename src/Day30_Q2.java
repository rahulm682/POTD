
// https://leetcode.com/problems/prime-arrangements/description/
// Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)
//
//(Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)
//
//Since the answer may be large, return the answer modulo 10^9 + 7.
//
//
//
//Example 1:
//
//Input: n = 5
//Output: 12
//Explanation: For example [1,2,5,4,3] is a valid permutation, but [5,2,3,4,1] is not because the prime number 5 is at index 1.
//Example 2:
//
//Input: n = 100
//Output: 682289015
//
//
//Constraints:
//
//1 <= n <= 100

public class Day30_Q2 {
    public static void main(String[] args) {

    }

    public int numPrimeArrangements(int n) {
        boolean[] sieve = new boolean[n+1];
        sieve[0] = true;
        sieve[1] = true;
        for(int i=2;i*i<=n;i++) {
            if(!sieve[i]) {
                for(int j=i*i;j<=n;j+=i) {
                    sieve[j] = true;
                }
            }
        }

        int primes = 0;
        for(int i=2;i<=n;i++) if(!sieve[i]) primes++;
        long f1 = fact(primes), f2 = fact(n-primes);

        return multiplyLargeNumbers(f1, f2);
    }

    int multiplyLargeNumbers(long f1, long f2) {
        int mod = 1000000007;
        long ans = 0;
        while(f2>0) {
            if(f2%2==1) ans = (ans+f1)%mod;

            f1 = (2*f1)%mod;
            f2 = f2/2;
        }

        return (int)ans%mod;
    }

    int fact(int n) {
        long ans = 1;
        int mod = 1000000007;
        while(n>0) {
            ans = (ans*n)%mod;
            n--;
        }
        return ((int)ans)%mod;
    }
}
