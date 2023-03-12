// https://leetcode.com/problems/combination-sum/description/
// Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
//frequency
// of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
//
//
//
//Example 1:
//
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
//Example 2:
//
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
//Example 3:
//
//Input: candidates = [2], target = 1
//Output: []
//
//
//Constraints:
//
//1 <= candidates.length <= 30
//2 <= candidates[i] <= 40
//All elements of candidates are distinct.
//1 <= target <= 40

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day51_Q1 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        find(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void find(int[] candidates, int target, int ind, List<Integer> curr, List<List<Integer>> ans) {
        if(target==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(ind>=candidates.length) return;

// pick the element and stay at same index and in next call check if current can be picked or not
// if current cannot be picked then the next also will not be able to pick because the array is sorted
// therefore return from the else part
        if(target-candidates[ind]>=0) {
            curr.add(candidates[ind]);
            find(candidates, target-candidates[ind], ind, curr, ans);
            curr.remove(curr.size()-1);
        } else return;
        find(candidates, target, ind+1, curr, ans);
    }
}
