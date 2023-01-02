//https://practice.geeksforgeeks.org/problems/find-the-smallest-and-second-smallest-element-in-an-array3226/1
//Given an array of integers, your task is to find the smallest and second smallest element in the array.
//If smallest and second smallest do not exist, print -1.
public class Day1 {
    public long[] minAnd2ndMin(long a[], long n)
    {
        if(n==1 || n==0) return new long[]{-1, -1};
        long min1 = Long.MAX_VALUE, min2 = min1;
        for(int i=0;i<n;i++) {
            if(a[i]==min1) continue;
            if(a[i]<min1) {
                min2 = min1;
                min1 = a[i];
            } else if(a[i]<min2) {
                min2 = a[i];
            }
        }

        if(min2==Long.MAX_VALUE) return new long[]{-1, -1};

        return new long[]{min1, min2};
    }
}
