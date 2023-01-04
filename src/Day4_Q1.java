//Write a program to create inverted hollow triangle star pattern of size n
/*
    * * * * *
     *     *
      *   *
        *
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Day4_Q1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        print(n);
    }

    public static void print(int n) {
        for(int i=0;i<n;i++) {
            for(int j=0;j<2*n-1;j++) {
                if(i==0) {
                    System.out.print("* ");
                } else {
                    if(i-j==0 || i+j==2*n-2) System.out.print("* ");
                    else System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
