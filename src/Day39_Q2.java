
// https://leetcode.com/problems/factorial-trailing-zeroes/

// Given an integer n, return the number of trailing zeroes in n!.
//
//Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
//
//
//
//Example 1:
//
//Input: n = 3
//Output: 0
//Explanation: 3! = 6, no trailing zero.
//Example 2:
//
//Input: n = 5
//Output: 1
//Explanation: 5! = 120, one trailing zero.
//Example 3:
//
//Input: n = 0
//Output: 0
//
//
//Constraints:
//
//0 <= n <= 104
//
//
//Follow up: Could you write a solution that works in logarithmic time complexity?
public class Day39_Q2 {
    public static void main(String[] args) {

    }


// in this method we are calculating number of 2 and 5 occurring at each number(as factor) in the given range using the modified sieve
// then we are calculating the number of twos and fives in the given range
// and we return th min(twos, fives) as our answer as 5*2=10 count for one 0 at end and the min power of both will be our answer
//
// and two calculate the factors i.e. number of times 2 and five occures we are using modifid sieve
// we start an i=x and go to n
// for each num from(x to n and increment by i = i+x) which is divisible by x we increase count of x in that number
// after inner loop overs we go to outer loop and increment the outer loop by i=i*x
// because the next number where the factor x will occur will be x*i
// here x = 2, 5 as we are cooncern with the occurances of 2 and 5 in n!

    public void factors(int[][] arr) {
        for(int i=2;i<arr.length;i*=2) {
            for(int j=i;j<arr.length;j+=i) arr[j][0]++;
        }

        for(int i=5;i<arr.length;i*=5) {
            for(int j=i;j<arr.length;j+=i) arr[j][1]++;
        }
    }

    public int trailingZeroes(int n) {
//        if(n<=4) return 0;
//        if(n==5) return 1;
//
//        int[][] mat = new int[n+1][2];
//
//        factors(mat);
//        // for(int i=0;i<mat.length;i++) System.out.println(i+" "+Arrays.toString(mat[i]));
//
//        int twos = 0, fives = 0;
//        for(int i=0;i<=n;i++) {
//            twos+=mat[i][0];
//            fives+=mat[i][1];
//        }
//
//        return Math.min(twos, fives);



        // Method 2: using the mathematical formula
// here for given n we take the floor of n/5 and add the result to answer and continue to take floor
// until the result becomes 0 and the result becomes our answer


        int ans = 0;
        while(n!=0) {
            n=n/5;
            ans+=n;
        }

        return ans;
    }
}
