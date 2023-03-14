import java.util.HashMap;

// https://leetcode.com/problems/substring-xor-queries/description/

// You are given a binary string s, and a 2D integer array queries where queries[i] = [firsti, secondi].
//
//For the ith query, find the shortest substring of s whose decimal value, val, yields secondi when bitwise XORed with firsti. In other words, val ^ firsti == secondi.
//
//The answer to the ith query is the endpoints (0-indexed) of the substring [lefti, righti] or [-1, -1] if no such substring exists. If there are multiple answers, choose the one with the minimum lefti.
//
//Return an array ans where ans[i] = [lefti, righti] is the answer to the ith query.
//
//A substring is a contiguous non-empty sequence of characters within a string.
//
//
//
//Example 1:
//
//Input: s = "101101", queries = [[0,5],[1,2]]
//Output: [[0,2],[2,3]]
//Explanation: For the first query the substring in range [0,2] is "101" which has a decimal value of 5, and 5 ^ 0 = 5, hence the answer to the first query is [0,2]. In the second query, the substring in range [2,3] is "11", and has a decimal value of 3, and 3 ^ 1 = 2. So, [2,3] is returned for the second query.
//
//Example 2:
//
//Input: s = "0101", queries = [[12,8]]
//Output: [[-1,-1]]
//Explanation: In this example there is no substring that answers the query, hence [-1,-1] is returned.
//Example 3:
//
//Input: s = "1", queries = [[4,5]]
//Output: [[0,0]]
//Explanation: For this example, the substring in range [0,0] has a decimal value of 1, and 1 ^ 4 = 5. So, the answer is [0,0].
//
//
//Constraints:
//
//1 <= s.length <= 104
//s[i] is either '0' or '1'.
//1 <= queries.length <= 105
//0 <= firsti, secondi <= 109

public class Day53_Q1 {
    public static void main(String[] args) {

    }

    public int[][] substringXorQueries(String s, int[][] queries) {
        int n = queries.length, m = s.length();
        int[][] ans = new int[n][2];

        HashMap<String, Integer> mp = new HashMap<>();

        for(int i=0;i<m;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=i;j<i+32;j++) {
                if(j==m) break;

                sb.append(s.charAt(j));
                if(!mp.containsKey(sb.toString())) mp.put(sb.toString(), i);
            }
        }


        for(int i=0;i<n;i++) {
            int xor = queries[i][0]^queries[i][1];

            String k = Integer.toBinaryString(xor);
            if(mp.containsKey(k)) {
                int start = mp.get(k);
                ans[i] = new int[]{start, start+k.length()-1};
            } else ans[i] = new int[]{-1, -1};
        }

        return ans;
    }
}
