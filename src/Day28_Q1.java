// https://leetcode.com/problems/find-the-k-beauty-of-a-number/

// The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:
//
//It has a length of k.
//It is a divisor of num.
//Given integers num and k, return the k-beauty of num.
//
//Note:
//
//Leading zeros are allowed.
//0 is not a divisor of any value.
//A substring is a contiguous sequence of characters in a string.
//
//
//
//Example 1:
//
//Input: num = 240, k = 2
//Output: 2
//Explanation: The following are the substrings of num of length k:
//- "24" from "240": 24 is a divisor of 240.
//- "40" from "240": 40 is a divisor of 240.
//Therefore, the k-beauty is 2.
//Example 2:
//
//Input: num = 430043, k = 2
//Output: 2
//Explanation: The following are the substrings of num of length k:
//- "43" from "430043": 43 is a divisor of 430043.
//- "30" from "430043": 30 is not a divisor of 430043.
//- "00" from "430043": 0 is not a divisor of 430043.
//- "04" from "430043": 4 is not a divisor of 430043.
//- "43" from "430043": 43 is a divisor of 430043.
//Therefore, the k-beauty is 2.
//
//
//Constraints:
//
//1 <= num <= 109
//1 <= k <= num.length (taking num as a string)

public class Day28_Q1 {
    public static void main(String[] args) {

    }


    public int divisorSubstrings(int num, int k) {
        int x = num, mul = 1, t = k, ans = 0;
        String s = x+"";

        while(t-->1) {
            mul = mul*10;
        }

        int n = 0;
        for(int i=0;i<k;i++) {
            n=n*10+(s.charAt(i)-'0');
        }

        if(n!=0 && num%n==0) ans++;

        for(int i=k;i<s.length();i++) {
            int d = s.charAt(i-k)-'0';
            n = n-(mul*d);
            n = n*10 + s.charAt(i)-'0';

            if(n!=0 && num%n==0) ans++;
        }

        return ans;
    }
}
