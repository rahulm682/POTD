public class Day36_Q1 {
    public static void main(String[] args) {

    }

    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(m<n) {
            return kthElement(arr2, arr1, m, n, k);
        }

// this indicates that we need to take minimum of elements from arr1 and not more than k form arr1
// suppose there are 6 elements in arr2 and 4 in arr1 and k=7 then there will be compulsion of picking some
// elements from arr1 so as to make a total of 7 and that min element is indicated by
// s = Math,max(0, k-m)

// and for if arr1 = 4 and arr2 = 6, and k = 3 and therefore from arr1 we cannot pick more than 3 elements
// or we will be having so many elements and therefore e = Math.min(n, k)

        int s = Math.max(0, k-m), e = Math.min(n, k);

        while(s<=e) {
            int cut1 = s+(e-s)/2;
            int cut2 = k-cut1;

            int l1 = cut1==0?Integer.MIN_VALUE:arr1[cut1-1];
            int l2 = cut2==0?Integer.MIN_VALUE:arr2[cut2-1];

            int r1 = cut1==n?Integer.MAX_VALUE:arr1[cut1];
            int r2 = cut2==m?Integer.MAX_VALUE:arr2[cut2];

            if(l1<=r2 && l2<=r1) return Math.max(l1, l2);
            else if(l1>r2) {
                e = cut1-1;
            } else {
                s = cut1+1;
            }
        }

        return 1;
    }
}
