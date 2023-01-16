// https://practice.geeksforgeeks.org/problems/find-the-highest-number2259/1


import java.util.List;

// Given an array in such a way that the elements stored in array are in increasing order initially and then after reaching to a peak element, the elements stored are in decreasing order. Find the highest element.
//Note: A[i] != A[i+1]
//
//
//Example 1:
//
//Input:
//11
//1 2 3 4 5 6 5 4 3 2 1
//Output: 6
//Explanation: Highest element is 6.
//Example 2:
//
//Input:
//5
//1 2 3 4 5
//Output: 5
//Explanation: Highest element is 5.
//
//
//
//Your Task:
//You don't need to read or print anything. Your task is to complete the function findPeakElement() which takes the array as the input parameter and returns the highest element.
//
//
//Expected Time Complexity: O(log(n))
//Expected Space Complexity: O(1)
//
//
//Constraints:
//2 <= Size of array <= 200
//1 <= Elements of the array <= 100000
public class Day17_Q2 {
    public static void main(String[] args) {

    }

    public int findPeakElement(List<Integer> a) {
        // Code here
        int s = 0, e = a.size()-1;
        // if(arr[s]<arr[e]) return arr[e];
        while(s<e) {
            int m = s+(e-s)/2;

            if(a.get(m)>a.get(m+1) && a.get(m)>a.get(m-1)) return a.get(m);
            if(a.get(m)>a.get(m+1)) {
                e = m-1;
            } else {
                s = m+1;
            }
        }

        return a.get(e);
    }
}
