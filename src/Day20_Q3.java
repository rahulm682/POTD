import java.util.*;
import java.lang.*;
import java.io.*;

public class Day20_Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]), k = Integer.parseInt(s[1]);


        boolean[] arr = new boolean[n+1];
        arr[0] = true;
        arr[1] = true;

        for(int i=2;i*i<=n;i++) {
            if(!arr[i]) {
                for(int j=i*i;j<=n;j+=i) {
                    arr[j] = true;
                }
            }
        }

        int ans = 0, i = 2, j = 3;
        while(j<=n) {
            if(i+j+1 <= n && !arr[i+j+1]) ans++;
            if(i+j+1>n) break;
            i = j;
            j++;
            while(j<=n && arr[j]==true) j++;
        }
//        System.out.println(n+" "+k);
        if(ans>=k) System.out.println("YES");
        else System.out.println("NO");
    }
}