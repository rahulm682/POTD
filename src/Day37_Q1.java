/*
 https://leetcode.com/problems/contains-duplicate-ii/description/
 Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
*/

import java.util.HashSet;
import java.util.Set;

public class Day37_Q1 {
    public static void main(String[] args) {

    }

    public boolean containsNearbyDuplicate(int[] arr, int k) {

        // Using sliding window and set to store elements present in current window
        Set<Integer> st = new HashSet<>();
        int i=0, n=arr.length;
        while(i<n && i<=k) {
            if(st.contains(arr[i])) return true;

            else st.add(arr[i]);
            i++;
        }

        while(i<n) {
            st.remove(arr[i-k-1]);
            if(st.contains(arr[i])) return true;

            st.add(arr[i]);
            i++;
        }

        return false;


        // HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        // for(int i=0;i<arr.length;i++) {
        //     if(!hm.containsKey(arr[i])) {
        //         ArrayList<Integer> al = new ArrayList<>();
        //         al.add(i);
        //         hm.put(arr[i], al);
        //     } else {
        //         ArrayList<Integer> al = hm.get(arr[i]);
        //         for(int j=0;j<al.size();j++) {
        //             int ind = al.get(j);
        //             if(Math.abs(ind-i)<=k) return true;
        //         }
        //         al.add(i);
        //         hm.replace(arr[i], al);
        //     }
        // }
        // return false;



// Concept is that we will check the presence of the current number in the map
// if the number is present then we will check for the index difference is less than or equal to k or not
// now if satisfied return true else it can be understood that the previous index has now gone out of
// bound and thus we need to replace that index with current or if num is not already present then add it
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for(int i=0;i<arr.length;i++) {
        //     int num = arr[i];
        //     if(hm.containsKey(num) && i-hm.get(num)<=k) return true;
        //     hm.put(num, i);
        // }
        // return false;





        // Solution using sliding window
// Here we are already maintaining the window size of K and if any elements found repeatedly in this window then we return true
// else if window size >k then we remove an element from the start position of the set

        // Set<Integer> st = new HashSet<>();
        // int i=0, j=0, n=arr.length;

        // while(j<n) {
        //     // check window size here and if > then shrink it
        //     if(j-i>k) st.remove(arr[i++]);
        //     if(st.contains(arr[j])) return true;

        //     st.add(arr[j]);
        //     j++;
        // }
        // return false;
    }
}
