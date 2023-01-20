// https://leetcode.com/problems/increasing-decreasing-string/description/

// You are given a string s. Reorder the string using the following algorithm:
//
//Pick the smallest character from s and append it to the result.
//Pick the smallest character from s which is greater than the last appended character to the result and append it.
//Repeat step 2 until you cannot pick more characters.
//Pick the largest character from s and append it to the result.
//Pick the largest character from s which is smaller than the last appended character to the result and append it.
//Repeat step 5 until you cannot pick more characters.
//Repeat the steps from 1 to 6 until you pick all characters from s.
//In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.
//
//Return the result string after sorting s with this algorithm.
//
//
//
//Example 1:
//
//Input: s = "aaaabbbbcccc"
//Output: "abccbaabccba"
//Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
//After steps 4, 5 and 6 of the first iteration, result = "abccba"
//First iteration is done. Now s = "aabbcc" and we go back to step 1
//After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
//After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
//Example 2:
//
//Input: s = "rat"
//Output: "art"
//Explanation: The word "rat" becomes "art" after re-ordering it with the mentioned algorithm.
//
//
//Constraints:
//
//1 <= s.length <= 500
//s consists of only lowercase English letters.

public class Day19_Q1 {
    public static void main(String[] args) {

    }

    public String sortString(String s) {
        int[] arr = new int[26];
        for(int i=0;i<s.length();i++) {
            arr[s.charAt(i)-'a']++;
        }

        StringBuilder ans = new StringBuilder();

        int i=0;
        while(ans.length()<s.length()) {
            for(i=0;i<26;i++) {
                if(arr[i]==0) continue;
                ans.append((char)(i+'a'));
                arr[i]--;
            }

            for(i=25;i>=0;i--) {
                if(arr[i]==0) continue;
                ans.append((char)(i+'a'));
                arr[i]--;
            }
        }

        return ans.toString();
    }
}
