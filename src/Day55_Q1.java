// https://leetcode.com/problems/group-anagrams/description/

// Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
//
//
//
//Example 1:
//
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//Example 2:
//
//Input: strs = [""]
//Output: [[""]]
//Example 3:
//
//Input: strs = ["a"]
//Output: [["a"]]
//
//
//Constraints:
//
//1 <= strs.length <= 104
//0 <= strs[i].length <= 100
//strs[i] consists of lowercase English letters.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Day55_Q1 {

    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> mp = new HashMap<>();

        for(String s:strs) {
            String freq = freq(s);
            if(!mp.containsKey(freq)) mp.put(freq, new ArrayList<>());

            mp.get(freq).add(s);
        }

        List<List<String>> ans = new ArrayList<>();

        for(String freq:mp.keySet()) {
            ans.add(mp.get(freq));
        }

        return ans;
    }

    private String freq(String s) {
        int[] freq = new int[26];
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }

        StringBuilder ans = new StringBuilder();
        for(int x:freq) {
            ans.append(x+",");
        }

        return ans.toString();
    }
}
