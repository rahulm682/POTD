import java.util.Arrays;
// https://leetcode.com/problems/check-if-it-is-a-straight-line/description/


// You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.
//
//
//
//
//
//Example 1:
//
//
//
//Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
//Output: true
//Example 2:
//
//
//
//Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
//Output: false
//
//
//Constraints:
//
//2 <= coordinates.length <= 1000
//coordinates[i].length == 2
//-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
//coordinates contains no duplicate point.

public class Day57_Q1 {
    public static void main(String[] args) {

    }

    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, (a, b)->a[0]-b[0]);
        double x = coordinates[0][0], y = coordinates[0][1];
        double xdiff = x-coordinates[1][0], ydiff = y-coordinates[1][1];
        double slope = Double.MAX_VALUE;
        boolean isInfinity = false;
        if(xdiff==0) isInfinity = true;
        else slope = ydiff/xdiff;

        for(int i=2;i<coordinates.length;i++) {
            xdiff = x-coordinates[i][0];
            ydiff = y-coordinates[i][1];
            if(xdiff==0) {
                if(!isInfinity) return false;
            } else {
                double s = ydiff/xdiff;
                if(s!=slope) return false;
            }
        }

        return true;
    }
}
