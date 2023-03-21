// https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/description/
// You are given a 0-indexed array nums of distinct integers. You want to rearrange the elements in the array such that every element in the rearranged array is not equal to the average of its neighbors.
//
//More formally, the rearranged array should have the property such that for every i in the range 1 <= i < nums.length - 1, (nums[i-1] + nums[i+1]) / 2 is not equal to nums[i].
//
//Return any rearrangement of nums that meets the requirements.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4,5]
//Output: [1,2,4,5,3]
//Explanation:
//When i=1, nums[i] = 2, and the average of its neighbors is (1+4) / 2 = 2.5.
//When i=2, nums[i] = 4, and the average of its neighbors is (2+5) / 2 = 3.5.
//When i=3, nums[i] = 5, and the average of its neighbors is (4+3) / 2 = 3.5.
//Example 2:
//
//Input: nums = [6,2,0,9,7]
//Output: [9,7,6,2,0]
//Explanation:
//When i=1, nums[i] = 7, and the average of its neighbors is (9+6) / 2 = 7.5.
//When i=2, nums[i] = 6, and the average of its neighbors is (7+2) / 2 = 4.5.
//When i=3, nums[i] = 2, and the average of its neighbors is (6+0) / 2 = 3.
//
//
//Constraints:
//
//3 <= nums.length <= 105
//0 <= nums[i] <= 105

import java.util.Arrays;

public class Day59_Q2 {
    public static void main(String[] args) {

    }

    // sort the array and start filling the value from i=0 and j=n/2 alternatively
    // avg = nums[i] only possible when one of left or right is smaller and other is larger
    // we will make arrangement as either both the neighbour  are smaller or larger
    // thus no ave equal to nums[i] is possible

    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Arrays.sort(nums);

        int i=0, j=n/2;
        for(int ind=0;ind<n;ind++) {
            if(ind%2==0) {
                ans[ind] = nums[j];
                j++;
            } else {
                ans[ind] = nums[i];
                i++;
            }
        }

        return ans;
    }
}
