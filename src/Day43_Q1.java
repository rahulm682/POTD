// https://leetcode.com/problems/power-of-four/description/

public class Day43_Q1 {

    public boolean isPowerOfFour(int n) {

//        METHOD 1:

//        if(n==1) return true;
//        if(n%2!=0 || n==0) return false;
//
//        long x = 1;
//        while(x<Integer.MAX_VALUE) {
//            if((x&n)==n) return true;
//            x = x<<2;
//        }
//
//        return false;

//        METHOD 2:
        if(n<=0) return false;

//         for power of 4 number the bit one is located at only the odd place
//         4 => 100 16 => 10000 so we need such number that has 1 on odd place so that & operation
//         evaluates to 0 and that number is 0x55555555 in hexadecimal form and in binary form it is
//         01010101010101010101010101010101 all one only at odd place
        return ((n & (n-1))==0 && (n & 0x55555555)==n);


//        METHOD 3:
//        if(n<=0) return false;
//        return ((n&(n-1))==0)&&(n&0xAAAAAAAA)==0;
    }
}
