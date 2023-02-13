// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

// Given a string s and an integer k, return the length of the longest substring of s such that the frequency of each character in this substring is greater than or equal to k.
//
//
//
//Example 1:
//
//Input: s = "aaabb", k = 3
//Output: 3
//Explanation: The longest substring is "aaa", as 'a' is repeated 3 times.
//Example 2:
//
//Input: s = "ababbc", k = 2
//Output: 5
//Explanation: The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
//
//
//Constraints:
//
//1 <= s.length <= 104
//s consists of only lowercase English letters.
//1 <= k <= 105

public class Day44_Q2 {
    public static void main(String[] args) {

    }

    public int longestSubstring(String s, int k) {
        int[] freq;

        int n = s.length(), max = 0;
        for(int i=0;i<n;i++) {
            freq = new int[26];
            for(int j=i;j<n;j++) {
                freq[s.charAt(j)-'a']++;
                if(check(freq, k)) max = Math.max(max, j-i+1);
            }
        }

        return max;
    }

    private boolean check(int[] freq, int k) {
        for(int i=0;i<26;i++) {
            if(freq[i]==0) continue;

            if(freq[i]<k) return false;
        }

        return true;
    }
}
