// https://practice.geeksforgeeks.org/problems/missing-number4257/1
// Vaibhav likes to play with numbers and he has N numbers. One day he was placing the numbers on the playing board just to count
// that how many numbers he has. He was placing the numbers in increasing order i.e. from 1 to N. But when he was putting the
// numbers back into his bag, some numbers fell down onto the floor. He picked up all the numbers but one number, he couldn't find.
// Now he has to go somewhere urgently, so he asks you to find the missing number.
// NOTE: Don't use Sorting

public class Day7_Q2 {

    public static void main(String[] args) {

    }

// As values from 1 to N we will store the values into its correct index i.e. arr[i]-1 will be its correct index
// while traversing if value encountered is N and as array size is N-1 we cannot put N to any index, therefore we will skip it,
// and we will continue swapping until we encounter N or the correct value at that index is placed
//    after this operation we will start iterating into the array and if arr[i]!=i+1 then return i+1
    public static int missingNumber(int arr[], int N) {
        int i=0;
        while(i<N-1) {
            int correct = arr[i]-1;
            if(arr[i]==N) i++;
            else if(arr[i]!=arr[correct]) {
                int temp = arr[i];
                arr[i] = arr[correct];
                arr[correct] = temp;
            } else {
                i++;
            }
        }

        for(i=0;i<N-1;i++) {
            if(arr[i]!=i+1) return i+1;
        }

        return N;
    }
}
