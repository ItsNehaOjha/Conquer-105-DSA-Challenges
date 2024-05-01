//DUTCH NATIONAL FLAG ALGORITHM
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects
//  of the same color are adjacent, with the colors in the order red, white, and blue.
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
// You must solve this problem without using the library's sort function.
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
public class q14SortColor{

    public static void main(String[] args) {
        int[] arr={2,0,2,1,1,0};
        int n=arr.length;
        // sort(arr,n);
        // for(int i=0;i<n;i++){
        //     System.out.print(arr[i]);
        // }
        System.out.println("By DUTCH NATIONAL FLAG ALGORITHM: ");
        dutchNationalFlagAlgo(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i] + " ");
        }
        
    }

    //naive and brute force approach
    // public static void sort(int[] arr,int n){
    //     int count0=0;
    //     int count1=0;
    //     int count2=0;


    //     for(int i=0;i<n;i++){
    //         if(arr[i]==0){
    //             count0++;
    //         }else if(arr[i]==1){
    //             count1++;
    //         }else{
    //             count2++;
    //         }
    //     }
    //     for(int i=0;i<count0;i++){
    //         arr[i]= 0;
    //     }
    //      for(int i=count0;i<count0+count1;i++){
    //         arr[i]= 1;
    //     }
    //      for(int i=count0+count1;i<n;i++){
    //         arr[i]= 2;
    //     }
        
    // }
    //DUTCH NATIONAL FLAG ALGORITHM
    public static void dutchNationalFlagAlgo(int[]arr, int n){
        int low=0;
        int mid =0;
        int high =n-1;
        while(mid<=high){
            if(arr[mid]==0){
                swap(arr,low,mid);
                mid++;
                low++;
            }
            else if(arr[mid]==1){
                mid++;
            }else{
                swap(arr,mid,high);
                high--;

            }
        }
    }
    public static void swap(int[]arr,int start, int end){
        int temp = arr[start];
        arr[start]= arr[end];
        arr[end]= temp;

    }
}