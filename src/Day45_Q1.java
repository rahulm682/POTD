import java.util.HashMap;

// https://leetcode.com/problems/subarray-sum-equals-k/description/

// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//
//
//Example 1:
//
//Input: nums = [1,1,1], k = 2
//Output: 2
//Example 2:
//
//Input: nums = [1,2,3], k = 3
//Output: 2
//
//
//Constraints:
//
//1 <= nums.length <= 2 * 104
//-1000 <= nums[i] <= 1000
//-107 <= k <= 107

public class Day45_Q1 {
    public static void main(String[] args) {

    }

    public int subarraySum(int[] nums, int k) {
        int n = nums.length, ans = 0;

        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        int sum = 0;
        for(int x:nums) {
            sum+=x;

            if(mp.containsKey(sum-k)) ans+=mp.get(sum-k);

            mp.put(sum, mp.getOrDefault(sum, 0)+1);
        }

        return ans;


        // O(N^2) Solution
        // int n = nums.length, ans = 0;

        // for(int i=0;i<n;i++) {
        //     int sum = 0;
        //     for(int j=i;j<n;j++) {
        //         sum+=nums[j];

        //         if(sum==k) ans++;
        //     }
        // }

        // return ans;
    }
}
