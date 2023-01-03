// https://leetcode.com/problems/sort-colors/description/
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
// with the colors in the order red, white, and blue.
//
//        We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
//        You must solve this problem without using the library's sort function
public class Day3_Q2 {
    public void sortColors(int[] nums) {
        int start=0, mid = 0, end = nums.length-1;
        while(mid<=end) {
            if(nums[mid]==2) {
                int temp = nums[mid];
                nums[mid] = nums[end];
                nums[end] = temp;
                end--;
            } else if(nums[mid]==1) {
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[start];
                nums[start] = temp;
                start++;
                mid++;
            }
        }
    }
}
