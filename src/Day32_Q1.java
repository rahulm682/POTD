

// https://leetcode.com/problems/find-the-duplicate-number/description/

// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
//There is only one repeated number in nums, return this repeated number.
//
//You must solve the problem without modifying the array nums and uses only constant extra space.
//
//
//
//Example 1:
//
//Input: nums = [1,3,4,2,2]
//Output: 2
//Example 2:
//
//Input: nums = [3,1,3,4,2]
//Output: 3
//
//
//Constraints:
//
//1 <= n <= 105
//nums.length == n + 1
//1 <= nums[i] <= n
//All the integers in nums appear only once except for precisely one integer which appears two or more times.
//
//
//Follow up:
//
//How can we prove that at least one duplicate number must exist in nums?
//Can you solve the problem in linear runtime complexity?

public class Day32_Q1 {
    public static void main(String[] args) {

    }

    public int findDuplicate(int[] nums) {
        // method 2: using linked list cycle method
        // here as the values are from 1-n and total n indexes, therefore we are able to use slow and fast pointers

        int slow = nums[0], fast = nums[0];

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);

        int entry = nums[0];
        while(entry!=slow) {
            entry = nums[entry];
            slow = nums[slow];
        }

        return slow;


        // Method 1: Using the property given i.e. all numbers are from 1-n
        // therefore we will check and keep the numbers at index nums[i]-1
        // so after one iteration, all the number would have been on index=num-1
        //  and only the number that is duplicate will be found on some other index and therefore num-1 == index property not matches
        // therefore return that num


        // int n = nums.length;
        // for(int i=0;i<n;i++) {
        //     int ind = nums[i]-1;
        //     if(nums[ind]==nums[i]) continue;
        //     else {
        //         int temp = nums[ind];
        //         nums[ind] = nums[i];
        //         nums[i] = temp;
        //         i--;
        //     }
        // }

        // for(int i=0;i<n;i++) {
        //     if(nums[i]!=i+1) return nums[i];
        // }

        // return -1;
    }
}
