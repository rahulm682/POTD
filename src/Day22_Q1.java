// https://leetcode.com/problems/isomorphic-strings/description/

import java.util.HashMap;
import java.util.Map;

// Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
//
//
//
//Example 1:
//
//Input: s = "egg", t = "add"
//Output: true
//Example 2:
//
//Input: s = "foo", t = "bar"
//Output: false
//Example 3:
//
//Input: s = "paper", t = "title"
//Output: true
//
//
//Constraints:
//
//1 <= s.length <= 5 * 104
//t.length == s.length
//s and t consist of any valid ascii character.

public class Day22_Q1 {
    public static void main(String[] args) {

    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> ans = new HashMap<>();

        int n = s.length();
        for(int i=0;i<n;i++) {
            if(ans.containsKey(s.charAt(i))) {
                if(t.charAt(i)!=ans.get(s.charAt(i))) return false;
            }

            if(ans.containsValue(t.charAt(i)) && !ans.containsKey(s.charAt(i))) return false;

            ans.put(s.charAt(i), t.charAt(i));
        }

        return true;
    }
}
