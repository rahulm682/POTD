// https://leetcode.com/problems/intersection-of-two-arrays/description/
// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
//
//
//
//Example 1:
//
//Input: nums1 = [1,2,2,1], nums2 = [2,2]
//Output: [2]
//Example 2:
//
//Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//Output: [9,4]
//Explanation: [4,9] is also accepted.

import java.util.*;

public class Day11_Q2 {
    public static void main(String[] args) {

    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(), intersection = new HashSet<>();
        for(int i=0;i<nums1.length;i++) set.add(nums1[i]);

        for(int i=0;i<nums2.length;i++) if(set.contains(nums2[i])) intersection.add(nums2[i]);

        int n = intersection.size(), i=0;
        int[] ans = new int[n];
        for(int x:intersection) {
            ans[i++] = x;
        }

        return ans;
    }
}
