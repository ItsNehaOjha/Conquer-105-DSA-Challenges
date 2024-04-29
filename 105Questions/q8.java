import java.util.Arrays;

public class q8 {
    public static void main(String[] args) {
        //move zeroes
        // Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
        //Note that you must do this in-place without making a copy of the array.
        //Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
        int[] arr={0,1,0,3,12};
        int n=arr.length;
        moveZeroes(arr,n);
       
        System.out.print(Arrays.toString(arr));
        
    }
    public static void moveZeroes(int[]arr, int n){
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]!=0){
                arr[count]=arr[i];
                count++;
            }
        }
        while(count<arr.length){
            arr[count]=0;
            count++;
        }
    }
}
