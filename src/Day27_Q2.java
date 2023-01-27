// https://leetcode.com/problems/reverse-vowels-of-a-string/description/
// Given a string s, reverse only all the vowels in the string and return it.
//
//The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
//
//
//
//Example 1:
//
//Input: s = "hello"
//Output: "holle"
//Example 2:
//
//Input: s = "leetcode"
//Output: "leotcede"
//
//
//Constraints:
//
//1 <= s.length <= 3 * 105
//s consist of printable ASCII characters.

public class Day27_Q2 {
    public static void main(String[] args) {

    }


    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int start = 0, end = arr.length-1;

        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<arr.length;i++) if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'||arr[i]=='A'||arr[i]=='E'||arr[i]=='I'||arr[i]=='O'||arr[i]=='U') sb.append(arr[i]);


        int j = sb.length()-1;
        for(int i=0;i<arr.length;i++) if(arr[i]=='a'||arr[i]=='e'||arr[i]=='i'||arr[i]=='o'||arr[i]=='u'||arr[i]=='A'||arr[i]=='E'||arr[i]=='I'||arr[i]=='O'||arr[i]=='U') arr[i] = sb.charAt(j--);

        return new String(arr);
    }
}
