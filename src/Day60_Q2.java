import java.util.Arrays;

// https://leetcode.com/problems/minimum-time-to-repair-cars/

// You are given an integer array ranks representing the ranks of some mechanics. ranksi is the rank of the ith mechanic. A mechanic with a rank r can repair n cars in r * n2 minutes.
//
//You are also given an integer cars representing the total number of cars waiting in the garage to be repaired.
//
//Return the minimum time taken to repair all the cars.
//
//Note: All the mechanics can repair the cars simultaneously.
//
//
//
//Example 1:
//
//Input: ranks = [4,2,3,1], cars = 10
//Output: 16
//Explanation:
//- The first mechanic will repair two cars. The time required is 4 * 2 * 2 = 16 minutes.
//- The second mechanic will repair two cars. The time required is 2 * 2 * 2 = 8 minutes.
//- The third mechanic will repair two cars. The time required is 3 * 2 * 2 = 12 minutes.
//- The fourth mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
//It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
//Example 2:
//
//Input: ranks = [5,1,8], cars = 6
//Output: 16
//Explanation:
//- The first mechanic will repair one car. The time required is 5 * 1 * 1 = 5 minutes.
//- The second mechanic will repair four cars. The time required is 1 * 4 * 4 = 16 minutes.
//- The third mechanic will repair one car. The time required is 8 * 1 * 1 = 8 minutes.
//It can be proved that the cars cannot be repaired in less than 16 minutes.​​​​​
//
//
//Constraints:
//
//1 <= ranks.length <= 105
//1 <= ranks[i] <= 100
//1 <= cars <= 106

public class Day60_Q2 {
    public static void main(String[] args) {

    }

    public long repairCars(int[] ranks, int cars) {
        long ans = 1;
        Arrays.sort(ranks);

        long min = 1, max = Long.MAX_VALUE;

        while(min<=max) {
            long mid = min+(max-min)/2;

            if(isPossible(ranks, mid, cars)) {
                ans = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }

        return ans;
    }

    private boolean isPossible(int[] ranks, long min, int cars) {
        int i=0;

        while(i<ranks.length && cars>0) {
            long curr = 0;
            int j=1;
            // checking for each mechanic how much cars can be repaired in given time
            for(j=1;j<=cars;j++) {
                if(ranks[i]*j*1l*j<=min) {
                    curr = ranks[i]*1l*j*j;
                } else {
                    // decrease cars and then break to go to next mechanic
                    cars-=(j-1);
                    curr=0;
                    break;
                }
            }

            if(curr!=0) cars-=(j-1);
            i++;
        }

        return cars<=0;
    }
}
