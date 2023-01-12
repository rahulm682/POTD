// 12-1-2023
// https://leetcode.com/problems/count-prefixes-of-a-given-string/description/

// You are given a string array words and a string s, where words[i] and s comprise only of lowercase English letters.
//
//Return the number of strings in words that are a prefix of s.
//
//A prefix of a string is a substring that occurs at the beginning of the string. A substring is a contiguous sequence of characters within a string.
//
//
//
//Example 1:
//
//Input: words = ["a","b","c","ab","bc","abc"], s = "abc"
//Output: 3
//Explanation:
//The strings in words which are a prefix of s = "abc" are:
//"a", "ab", and "abc".
//Thus the number of strings in words which are a prefix of s is 3.

public class Day12_Q1 {
    public static void main(String[] args) {

    }

    public int countPrefixes(String[] words, String s) {
        int ans = 0;
        for(int i=0;i<words.length;i++) {
            if(s.indexOf(words[i])==0) ans++;
        }

        return ans;
    }
}
