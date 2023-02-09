// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//Example 1:
//
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
//Example 2:
//
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
//
//
//Constraints:
//
//1 <= s.length, p.length <= 3 * 104
//s and p consist of lowercase English letters.

import java.util.ArrayList;
import java.util.List;

public class Day40_Q2 {
    public static void main(String[] args) {

    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> al = new ArrayList<>();

        if(p.length()>s.length()) return al;

        int[] arr1 = new int[26], arr2 = new int[26];

        for(char ch:p.toCharArray()) {
            arr1[ch-'a']++;
        }

        int i=0, j=0;
        while(j<p.length()) {
            arr2[s.charAt(j)-'a']++;
            j++;
        }

        if(check(arr1, arr2)) al.add(i);

        while(j<s.length()) {
            arr2[s.charAt(j-p.length())-'a']--;
            arr2[s.charAt(j)-'a']++;
            i++;j++;

            if(check(arr1, arr2)) al.add(i);
        }

        return al;
    }

    boolean check(int[] arr1, int[] arr2) {
        for(int i=0;i<26;i++) {
            if(arr1[i]!=arr2[i]) return false;
        }

        return true;
    }
}
