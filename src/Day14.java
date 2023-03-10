// 14-1-2023
// https://leetcode.com/problems/search-insert-position/description/
// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You must write an algorithm with O(log n) runtime complexity.
//
//
//
//Example 1:
//
//Input: nums = [1,3,5,6], target = 5
//Output: 2
//Example 2:
//
//Input: nums = [1,3,5,6], target = 2
//Output: 1
//Example 3:
//
//Input: nums = [1,3,5,6], target = 7
//Output: 4
//
//
//Constraints:
//
//1 <= nums.length <= 104
//-104 <= nums[i] <= 104
//nums contains distinct values sorted in ascending order.
//-104 <= target <= 104
public class Day14 {
    public static void main(String[] args) {

    }

    public int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length-1;
        while(s<=e) {
            int m = s+(e-s)/2;
            if(nums[m]==target) return m;
            else if(nums[m]<target) s = m+1;
            else e = m-1;
        }

        return s;
    }
}
