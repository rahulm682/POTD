//5-1-2023
//https://practice.geeksforgeeks.org/problems/replace-all-0s-with-5/1
//You are given an integer N. You need to convert all zeroes of N to 5.
public class Day5 {
    int convertfive(int num) {
        char[] arr = (num+"").toCharArray();
        for(int i=0;i<arr.length;i++) if(arr[i]=='0') arr[i] = '5';

        return Integer.parseInt(String.valueOf(arr));
    }
}
