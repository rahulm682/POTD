// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

// A string is good if there are no repeated characters.
//
//Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.
//
//Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
//
//A substring is a contiguous sequence of characters in a string.
//
//
//
//Example 1:
//
//Input: s = "xyzzaz"
//Output: 1
//Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
//The only good substring of length 3 is "xyz".
//Example 2:
//
//Input: s = "aababcabc"
//Output: 4
//Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
//The good substrings are "abc", "bca", "cab", and "abc".
//
//
//Constraints:
//
//1 <= s.length <= 100
//s​​​​​​ consists of lowercase English letters.
public class Day26_Q2 {
    public static void main(String[] args) {

    }

    public int countGoodSubstrings(String s) {
        int[] arr = new int[26];
        char[] carr = s.toCharArray();

        for(int i=0;i<3;i++) arr[carr[i]-'a']++;
        int ans = 0, n=carr.length;
        if(check(arr)) ans++;

        for(int i=3;i<n;i++) {
            arr[carr[i-3]-'a']--;
            arr[carr[i]-'a']++;
            if(check(arr)) ans++;
        }

        return ans;
    }

    boolean check(int[] arr) {
        for(int i=0;i<26;i++) if(arr[i]>1) return false;
        return true;
    }

}
