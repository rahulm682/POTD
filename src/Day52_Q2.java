// https://leetcode.com/problems/combination-sum-iii/description/
// Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//Only numbers 1 through 9 are used.
//Each number is used at most once.
//Return a list of all possible valid combinations. The list must not contain the same combination twice,
// and the combinations may be returned in any order.
//
//
//
//Example 1:
//
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations.
//Example 2:
//
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
//Example 3:
//
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1,
// there are no valid combination.
//
//
//Constraints:
//
//2 <= k <= 9
//1 <= n <= 60

import java.util.ArrayList;
import java.util.List;

public class Day52_Q2 {
    public static void main(String[] args) {

    }


//     TC: O(2^9) && SC: O(10)
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();

        find(k, n, new ArrayList<Integer>(), ans, 1);
        return ans;
    }

    private void find(int k, int n, List<Integer> curr, List<List<Integer>> ans, int num) {
        if(k==0 && n==0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(k<0 || n<0 || num>=10) return;

        curr.add(num);
        find(k-1, n-num, curr, ans, num+1);

        curr.remove(curr.size()-1);
        find(k, n, curr, ans, num+1);
    }
}
