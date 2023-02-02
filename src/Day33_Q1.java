// https://leetcode.com/problems/my-calendar-i/description/

// You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
//
//A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
//
//The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.
//
//Implement the MyCalendar class:
//
//MyCalendar() Initializes the calendar object.
//boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
//
//
//Example 1:
//
//Input
//["MyCalendar", "book", "book", "book"]
//[[], [10, 20], [15, 25], [20, 30]]
//Output
//[null, true, false, true]
//
//Explanation
//MyCalendar myCalendar = new MyCalendar();
//myCalendar.book(10, 20); // return True
//myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
//myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20.
//
//
//Constraints:
//
//0 <= start < end <= 109
//At most 1000 calls will be made to book.


import java.util.Arrays;

class MyCalendar {
    int[][] events;
    int i=0;

    public MyCalendar() {
        events = new int[1000][2];
        for(int i=0;i<1000;i++) events[i][0] = Integer.MAX_VALUE;
    }

    public boolean book(int start, int end) {
        if(i==0) {
            events[i][0] = start;
            events[i][1] = end;
            i++;
            return true;
        } else {
            if(start>events[i-1][0]) {
                if(start>=events[i-1][1]) {
                    events[i][0] = start;
                    events[i][1] = end;
                    i++;
                    return true;
                } else return false;
            }

            int s = 0, e = i-1;
            while(s<=e) {
                int m = s+(e-s)/2;

                if(events[m][0]==start) return false;
                else if(events[m][0]>start) e = m-1;
                else s = m+1;
            }

            if(e==-1) {
                if(end<=events[0][0]) {
                    events[i][0] = start;
                    events[i][1] = end;
                    i++;
                    Arrays.sort(events, (a, b)->a[0]-b[0]);
                    return true;
                } else return false;
            } else {
                if(start>=events[e][1] && end<=events[e+1][0]) {
                    events[i][0] = start;
                    events[i][1] = end;
                    i++;
                    Arrays.sort(events, (a, b)->a[0]-b[0]);
                    return true;
                } else return false;
            }
        }
    }
}
public class Day33_Q1 {
    public static void main(String[] args) {

    }


}
