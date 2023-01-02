//https://practice.geeksforgeeks.org/problems/remove-vowels-from-string1446/1
//Given a string, remove the vowels from the string.

public class Day2 {
    String removeVowels(String S) {
        StringBuilder ans = new StringBuilder();
        for(char ch:S.toCharArray()) {
            if(!(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')) ans.append(ch);
        }

        return ans.toString();
    }
}
