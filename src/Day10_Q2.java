// https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
// Given a String S, reverse the string without reversing its individual words. Words are separated by dots.
//
//Example 1:
//
//Input:
//S = i.like.this.program.very.much
//Output: much.very.program.this.like.i
//Explanation: After reversing the whole
//string(not individual words), the input
//string becomes
//much.very.program.this.like.i

public class Day10_Q2 {
    public static void main(String[] args) {

    }

    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        String[] a = S.split("[.]");
        // System.out.println(Arrays.toString(a));
        int n = a.length;
        for(int i=0;i<n/2;i++) {
            String s = a[i];

            a[i] = a[n-1-i];
            a[n-1-i] = s;
        }
        // System.out.println(Arrays.toString(a));
        String ans = String.join(".", a);
        return ans;
    }
}
