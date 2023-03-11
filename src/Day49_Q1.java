// https://leetcode.com/problems/binary-watch/description/

// A binary watch has 4 LEDs on the top to represent the hours (0-11), and 6 LEDs on the bottom to represent the minutes (0-59). Each LED represents a zero or one, with the least significant bit on the right.
//
//For example, the below binary watch reads "4:51".
//
//
//Given an integer turnedOn which represents the number of LEDs that are currently on (ignoring the PM), return all possible times the watch could represent. You may return the answer in any order.
//
//The hour must not contain a leading zero.
//
//For example, "01:00" is not valid. It should be "1:00".
//The minute must be consist of two digits and may contain a leading zero.
//
//For example, "10:2" is not valid. It should be "10:02".
//
//
//Example 1:
//
//Input: turnedOn = 1
//Output: ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
//Example 2:
//
//Input: turnedOn = 9
//Output: []
//
//
//Constraints:
//
//0 <= turnedOn <= 10


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Day49_Q1 {
    public static void main(String[] args) {

    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        char[] arr = {'0','0','0','0','0','0','0','0','0','0','0'};
        readFromBinary(turnedOn, arr, 10, ans);
        return ans;

        // Time Consuming:
        // TC: O(n^6)
        // int[] hr = {1,2,4,8};
        // int[] min = {1,2,4,8,16,32};
        // int[][] dp = new int[12][60];
        // for(int i=0;i<12;i++) for(int j=0;j<60;j++) dp[i][j] = -1;

        // Set<String> ans = new HashSet<>();

        // read(hr, min, 0, 0, 0, 0, turnedOn, ans, dp);
        // return new ArrayList<>(ans);
    }

// Method1: using arr and set
// take array for hour and minutes also using dp array
// use each index for hour and minute calculation and also using the total lighs turned on
// at each index we first check if current index can be included into ans or not

    void read(int[] hr, int[] min, int h, int m, int i1, int i2, int lights, Set<String> al, int[][] dp) {
        if(lights==0) {
            String ans = (h==0?"0":h)+":"+(m==0?"00":(m<10?("0"+m):m));

            al.add(ans);
        }
        if(i1>4 || i2>6) return;
        if(dp[h][m]!=-1) return;
        dp[h][m] = 0;

        for(int i=i2;i<6;i++) {
            if(m+min[i2]<=59 && lights>0) {
                read(hr, min, h, m+min[i], i1, i+1, lights-1, al, dp);
            }
        }
        read(hr, min, h, m, i1, i2+1, lights, al, dp);

        for(int i=i1;i<4;i++) {
            if(h+hr[i1]<=11 && lights>0) {
                read(hr, min, h+hr[i], m, i+1, i2, lights-1, al, dp);
            }
        }
        read(hr, min, h, m, i1+1, i2, lights, al, dp);
    }



// method 2: using binary string of 10 characters
// maximum hr: 11 and maximum minute: 59
// can be represented using binary string of length 10
// first 4 for hr and next 6 for minutes

// using the subset method we will set the value at each index to either 1 or 0 and the resultant
// binary string will have total 1 turnedOn times
// and while on reaching index 0 we can calculate time using first 4 bits as hour
// and next 6 bits as minutes

// but one thing to keep in mind is that on reaching last index i.e. ind==0
// we need to calculate the ans by setting that bit to '1' as well as to '0' and then calculate ans

// here i have taken 1 extra index and made arr of length 11 and the last index 0, will be for answer calculateion
// ans 1-4 bits for hour calculation and 5-10 bits for minute calculation
// NOTE: also after conversion from binary into hr and min we need to check for its validity

    // TC: O(2^10)
    void readFromBinary(int lights, char[] arr, int ind, List<String> ans) {
        // if(ind<0) return;
        if(ind==0) {
            if(lights==0) {
                String s = new String(arr);
                int h = Integer.parseInt(s.substring(1,5), 2);
                int m = Integer.parseInt(s.substring(5), 2);

                if(h>=12 || m>=60) return;

                String res = (h==0?"0":h)+":"+(m==0?"00":(m<10?("0"+m):m));
                ans.add(res);
            }

            return;
        }

        if(lights>0) {
            arr[ind] = '1';
            readFromBinary(lights-1, arr, ind-1, ans);
        }

        arr[ind] = '0';
        readFromBinary(lights, arr, ind-1, ans);
    }
}
