
// https://leetcode.com/problems/reverse-words-in-a-string-iii/description/
// Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
//
//
//
//Example 1:
//
//Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"
//Example 2:
//
//Input: s = "God Ding"
//Output: "doG gniD"
//
//
//Constraints:
//
//1 <= s.length <= 5 * 104
//s contains printable ASCII characters.
//s does not contain any leading or trailing spaces.
//There is at least one word in s.
//All the words in s are separated by a single space.

public class Day29_Q1 {

    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        int i=0, j=0;
        while(i<arr.length && j<arr.length) {
            while(j<arr.length && arr[j]!=' ') j++;
            j--;
            int k = i, l = j;
            while(k<l) {
                char ch = arr[k];
                arr[k] = arr[l];
                arr[l] = ch;
                k++;
                l--;
            }

            i=j+2;
            j=j+2;
        }
        return new String(arr);
    }
}
