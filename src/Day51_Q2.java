// https://leetcode.com/problems/combination-sum-ii/description/

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note: The solution set must not contain duplicate combinations.
//
//
//
//Example 1:
//
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//Example 2:
//
//Input: candidates = [2,5,2,1,2], target = 5
//Output:
//[
//[1,2,2],
//[5]
//]
//
//
//Constraints:
//
//1 <= candidates.length <= 100
//1 <= candidates[i] <= 50
//1 <= target <= 30

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day51_Q2 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

        for(int i=ind;i<candidates.length;i++) {
            if(i>ind && candidates[i]==candidates[i-1]) continue;

            if(target-candidates[i]>=0) {
                curr.add(candidates[i]);
                find(candidates, target-candidates[i], i+1, curr, ans);
                curr.remove(curr.size()-1);
            } else return;
        }
        // if(target-candidates[ind]>=0) {
        //     curr.add(candidates[ind]);
        //     find(candidates, target-candidates[ind], ind, curr, ans);
        //     curr.remove(curr.size()-1);
        // } else return;

        // find(candidates, target, ind+1, curr, ans);
    }
}
