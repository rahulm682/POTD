import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/merge-intervals/description/

// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
//
//
//
//Example 1:
//
//Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
//Example 2:
//
//Input: intervals = [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping.
//
//
//Constraints:
//
//1 <= intervals.length <= 104
//intervals[i].length == 2
//0 <= starti <= endi <= 104

public class Day56_Q1 {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);

        ArrayList<int[]> al = new ArrayList<>();
        int n = intervals.length;

        int s = intervals[0][0], e = intervals[0][1];

        for(int i=1;i<n;i++) {
            int a = intervals[i][0], b = intervals[i][1];

            if(e>=a) {
                e = Math.max(e, b);
            } else {
                al.add(new int[]{s, e});
                s = a;
                e = b;
            }
        }

        al.add(new int[]{s, e});

        n = al.size();
        int[][] ans = new int[n][2];

        for(int i=0;i<n;i++) ans[i] = al.get(i);

        return ans;
    }
}
