// https://leetcode.com/problems/valid-palindrome/description/
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//
//Given a string s, return true if it is a palindrome, or false otherwise.
//
//
//
//Example 1:
//
//Input: s = "A man, a plan, a canal: Panama"
//Output: true
//Explanation: "amanaplanacanalpanama" is a palindrome.
//Example 2:
//
//Input: s = "race a car"
//Output: false
//Explanation: "raceacar" is not a palindrome.
//Example 3:
//
//Input: s = " "
//Output: true
//Explanation: s is an empty string "" after removing non-alphanumeric characters.
//Since an empty string reads the same forward and backward, it is a palindrome.
//
//
//Constraints:
//
//1 <= s.length <= 2 * 105
//s consists only of printable ASCII characters.
public class Day21_Q2 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char ch:s.toCharArray()) {
            if(ch>='A' && ch<='Z') {
                sb.append((char)(ch-'A'+'a'));
            } else if((ch>='a' && ch<='z') || (ch>='0' && ch<='9')) {
                sb.append(ch);
            }
        }

        int n = sb.length();
        for(int i=0;i<n/2;i++) {
            if(sb.charAt(i)!=sb.charAt(n-1-i)) return false;
        }

        return true;
    }
}
