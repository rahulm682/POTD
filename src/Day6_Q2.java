// 6-1-2023
// https://practice.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1
// Union of two arrays can be defined as the common and distinct elements in the two arrays.
// Given two sorted arrays of size n and m respectively, find their union.

import java.util.*;
public class Day6_Q2 {
    public static void main(String[] args) {

    }

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        ArrayList<Integer> al = new ArrayList<>();
        int i=0, j=0;

        if(arr1[i]<arr2[j]) {
            al.add(arr1[i]);
            i++;
        } else {
            al.add(arr2[j]);
            j++;
        }

        while(i<n && j<m) {
            if(arr1[i]<arr2[j]) {
                if(al.get(al.size()-1)!=arr1[i]) al.add(arr1[i]);
                i++;
            } else if(arr1[i]>arr2[j]) {
                if(al.get(al.size()-1)!=arr2[j]) al.add(arr2[j]);
                j++;
            } else {
                if(al.get(al.size()-1)!=arr1[i]) al.add(arr1[i]);
                i++;
                j++;
            }
        }

        while(i<n) {
            if(al.get(al.size()-1)!=arr1[i]) al.add(arr1[i]);
            i++;
        }

        while(j<m) {
            if(al.get(al.size()-1)!=arr2[j]) al.add(arr2[j]);
            j++;
        }

        return al;
    }

}
