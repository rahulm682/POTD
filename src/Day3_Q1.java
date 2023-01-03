//https://leetcode.com/problems/pascals-triangle/
//Given an integer numRows, return the first numRows of Pascal's triangle.

import java.util.*;

public class Day3_Q1 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        al.add(1);
        ans.add(al);

        for(int i=1;i<numRows;i++) {
            al = new ArrayList<>();
            al.add(1);
            for(int j=1;j<ans.get(i-1).size();j++) {
                List<Integer> temp = ans.get(i-1);
                int num = temp.get(j-1)+temp.get(j);
                al.add(num);
            }
            al.add(1);
            ans.add(al);
        }

        return ans;
    }
}
