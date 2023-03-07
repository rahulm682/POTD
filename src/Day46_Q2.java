// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//
//
//Example 1:
//
//Input: haystack = "sadbutsad", needle = "sad"
//Output: 0
//Explanation: "sad" occurs at index 0 and 6.
//The first occurrence is at index 0, so we return 0.
//Example 2:
//
//Input: haystack = "leetcode", needle = "leeto"
//Output: -1
//Explanation: "leeto" did not occur in "leetcode", so we return -1.
//
//
//Constraints:
//
//1 <= haystack.length, needle.length <= 104
//haystack and needle consist of only lowercase English characters.


public class Day46_Q2 {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
// Method 1: TC: O(N^2) ans SC: O(1)
        // int n = haystack.length(), m = needle.length(), i, j;
        // if(m>n) return -1;

        // for(i=0;i<=n-m;i++) {
        //     j=0;
        //     for(j=0;j<m;j++) {
        //         if(haystack.charAt(i+j)!=needle.charAt(j)) {
        //             break;
        //         }
        //     }

        //     if(j==m) return i;
        // }

        // return -1;


// Method 2: using string matching algorithm (KMP Algorithm)
// In this algorithm we make us of previously traversed string haystack and by calculating the Longest Prefix Suffix array

// TC: O(N) and SC: O(1)

        int n = haystack.length(), m = needle.length();
        int i=0, j=0;

        int[] lps = calculateLPS(needle);

        while(i<n) {
            if(haystack.charAt(i)==needle.charAt(j)) {
                i++;
                j++;
                if(j==m) {
                    return i-j;
                }
            } else {
                if(j==0) i++;
                else j=lps[j-1];
            }
        }

        return -1;
    }


    //    calculate LPS of a string (Very Important Algorithm: REMEMBER IT)
    private int[] calculateLPS(String s) {
        int n = s.length();
        int[] lps = new int[n];

        // always lps[0] = 0 only
        lps[0] = 0;
        // len indicates that upto which index we have checked in the string
        int len = 0, i=1;
        while(i<n) {
            if(s.charAt(i)==s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else if(len==0) {
                lps[i] = 0;
                i++;
            } else {
                len = lps[len-1];
            }
        }

        return lps;
    }
}
