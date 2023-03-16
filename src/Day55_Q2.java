// https://leetcode.com/problems/corporate-flight-bookings/description/

// There are n flights that are labeled from 1 to n.
//
//You are given an array of flight bookings bookings, where bookings[i] = [firsti, lasti, seatsi] represents a booking for flights firsti through lasti (inclusive) with seatsi seats reserved for each flight in the range.
//
//Return an array answer of length n, where answer[i] is the total number of seats reserved for flight i.
//
//
//
//Example 1:
//
//Input: bookings = [[1,2,10],[2,3,20],[2,5,25]], n = 5
//Output: [10,55,45,25,25]
//Explanation:
//Flight labels:        1   2   3   4   5
//Booking 1 reserved:  10  10
//Booking 2 reserved:      20  20
//Booking 3 reserved:      25  25  25  25
//Total seats:         10  55  45  25  25
//Hence, answer = [10,55,45,25,25]
//Example 2:
//
//Input: bookings = [[1,2,10],[2,2,15]], n = 2
//Output: [10,25]
//Explanation:
//Flight labels:        1   2
//Booking 1 reserved:  10  10
//Booking 2 reserved:      15
//Total seats:         10  25
//Hence, answer = [10,25]
//
//
//
//Constraints:
//
//1 <= n <= 2 * 104
//1 <= bookings.length <= 2 * 104
//bookings[i].length == 3
//1 <= firsti <= lasti <= n
//1 <= seatsi <= 104

public class Day55_Q2 {
    public static void main(String[] args) {

    }


// in this type of question we take an extra array of size n+1 (here n+2, as the booking's data starts from 1)
// the we store the value as +ve in start index and at end+1 index we store -ve value (booking[i][2])
// we accumulate these values into the extra array that we have created

// now when getting the answer, we take sum=0 and at each index of extra array we add that value in sum
// store the sum in ans array
// at last we return the answer

// here we are asked to accumulate the total flights booked at each n
// the details are given in form of interval and we need to sum all the flights booked at ith time
// i.e. for each i we find if i belong to interval, if yes then add to flights and after all intervals are over
// we need to store the flights in the ans

// 1. brute force:
// for each i scan and get total flights and store the
// TC: O(N^2) and SC: O(1)

// 2. optimal
// do as stated above
// TC: O(N) and SC: O(N)


    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] ans = new int[n], arr = new int[n+2];

        for(int i=0;i<bookings.length;i++) {
            arr[bookings[i][0]] += bookings[i][2];
            arr[bookings[i][1]+1] += -bookings[i][2];
        }

        int sum = 0;
        for(int i=0;i<n;i++) {
            sum+=arr[i+1];
            ans[i] = sum;
        }

        return ans;
    }
}
