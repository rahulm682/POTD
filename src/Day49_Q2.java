
// https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/description/


// You are given a string num, representing a large integer, and an integer k.
//
//We call some integer wonderful if it is a permutation of the digits in num and is greater in value than num. There can be many wonderful integers. However, we only care about the smallest-valued ones.
//
//For example, when num = "5489355142":
//The 1st smallest wonderful integer is "5489355214".
//The 2nd smallest wonderful integer is "5489355241".
//The 3rd smallest wonderful integer is "5489355412".
//The 4th smallest wonderful integer is "5489355421".
//Return the minimum number of adjacent digit swaps that needs to be applied to num to reach the kth smallest wonderful integer.
//
//The tests are generated in such a way that kth smallest wonderful integer exists.
//
//
//
//Example 1:
//
//Input: num = "5489355142", k = 4
//Output: 2
//Explanation: The 4th smallest wonderful number is "5489355421". To get this number:
//- Swap index 7 with index 8: "5489355142" -> "5489355412"
//- Swap index 8 with index 9: "5489355412" -> "5489355421"
//Example 2:
//
//Input: num = "11112", k = 4
//Output: 4
//Explanation: The 4th smallest wonderful number is "21111". To get this number:
//- Swap index 3 with index 4: "11112" -> "11121"
//- Swap index 2 with index 3: "11121" -> "11211"
//- Swap index 1 with index 2: "11211" -> "12111"
//- Swap index 0 with index 1: "12111" -> "21111"
//Example 3:
//
//Input: num = "00123", k = 1
//Output: 1
//Explanation: The 1st smallest wonderful number is "00132". To get this number:
//- Swap index 3 with index 4: "00123" -> "00132"
//
//
//Constraints:
//
//2 <= num.length <= 1000
//1 <= k <= 1000
//num only consists of digits.

public class Day49_Q2 {
    public static void main(String[] args) {

    }

    // first of all find the kth next permutation of the given string
// then take the src and des string compare index by index
// if src[i]!=des[i] find the des[i] in src string and then swap the character with adjacent character
// until we get src[i]==des[i] and also count the swaps that we will be doing
// continue there process until we make src and des equal
// the total swaps required int these steps will be our answer

    public int getMinSwaps(String num, int k) {
        String des = new String(num);
        for(int i=0;i<k;i++) {
            des = nextPermutation(des.toCharArray());
        }

        System.out.println(des);
        char[] arr1 = num.toCharArray(), arr2 = des.toCharArray();

        int i = 0, swaps = 0;

        while(i<arr1.length) {
            if(arr1[i]!=arr2[i]) {
                int j = i+1;
                while(arr1[j]!=arr2[i]) j++;

                while(j>i) {
                    swap(arr1, j-1, j);
                    j--;
                    swaps++;
                }
            }

            i++;
        }

        return swaps;
    }

    private String nextPermutation(char[] arr) {
        int n = arr.length;
        char[] res = new char[n];
        for(int i=0;i<n;i++) {
            res[i] = arr[i];
        }

        int j = n-2;
        while(j>=0 && res[j]>=res[j+1]) j--;

        int i=n-1;
        while(i>j && res[i]<=res[j]) i--;

        swap(res, i, j);
        reverse(res, j+1, n-1);

        return new String(res);
    }

    private void swap(char[] res, int i, int j) {
        char ch = res[i];
        res[i] = res[j];
        res[j] = ch;
    }

    private void reverse(char[] res, int i, int j) {
        while(i<j) {
            swap(res, i, j);
            i++;
            j--;
        }
    }
}
