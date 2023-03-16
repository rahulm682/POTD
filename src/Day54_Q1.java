import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations-ii/

// Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//
//
//
//Example 1:
//
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//Example 2:
//
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//Constraints:
//
//1 <= nums.length <= 8
//-10 <= nums[i] <= 10

public class Day54_Q1 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permuteUnique(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        boolean[] freq = new boolean[arr.length];
        permutation(arr, ans, new ArrayList<>(), freq);
        // permutation(arr, ans, new ArrayList<>(), 0);
        return ans;
    }


    void permutation(int[] arr, List<List<Integer>> ans, List<Integer> curr, boolean[] freq) {
        if(curr.size()==arr.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for(int i=0;i<arr.length;i++) {
            if(freq[i]) continue;
            if(i > 0 && arr[i]==arr[i-1] && !freq[i-1]) continue;

            curr.add(arr[i]);
            freq[i] = true;

            permutation(arr, ans, curr, freq);

            freq[i] = false;
            curr.remove(curr.size()-1);
        }
    }


//    fails for last case
    // public List<List<Integer>> permuteUnique(int[] nums) {
    //        Arrays.sort(nums);
    //        List<List<Integer>> ans = new ArrayList<>();
    //
    //        find(nums, 0, new ArrayList<Integer>(), ans);
    //        return ans;
    //    }
    //
    //    private void find(int[] nums, int ind, List<Integer> curr, List<List<Integer>> ans) {
    //        if(ind==nums.length) {
    //            ans.add(new ArrayList<Integer>(curr));
    //            return;
    //        }
    //
    //        for(int i=ind;i<nums.length;i++) {
    //            if(i>ind && (nums[i]==nums[ind] || nums[i]==nums[i-1])) continue;
    //            swap(nums, i, ind);
    //            curr.add(nums[ind]);
    //            find(nums, ind+1, curr, ans);
    //
    //            curr.remove(curr.size()-1);
    //            swap(nums, i, ind);
    //        }
    //    }
    //
    //    private void swap(int[] nums, int i, int j) {
    //        int temp = nums[i];
    //        nums[i] = nums[j];
    //        nums[j] = temp;
    //    }
}
