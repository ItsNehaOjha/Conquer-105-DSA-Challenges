// 2149. Rearrange Array Elements by Sign
// You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.

// You should return the array of nums such that the the array follows the given conditions:

// Every consecutive pair of integers have opposite signs.
// For all integers with the same sign, the order in which they were present in nums is preserved.
// The rearranged array begins with a positive integer.
// Return the modified array after rearranging the elements to satisfy the aforementioned conditions.

import java.util.ArrayList;
import java.util.Arrays;

public class q19RearrangeNums {
    public static int[] rearrangeArray(int[] nums) {
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>0){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }
        for(int i=0;i<n/2;i++){
            nums[2*i]=pos.get(i);
            nums[2*i+1]= neg.get(i);
        }
        return nums;
    }
    public static int[] betterSol(int[]arr){

        //according to the available place
        int n= arr.length;
        int[] ans = new int[n];
        int posIndex= 0, negIndex = 1;
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                ans[posIndex]= arr[i];
                posIndex+=2;
            }else{
                ans[negIndex] = arr[i];
                negIndex+=2;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, -3, 5, -7, 9, -2};

         int[] rearrangedArray = rearrangeArray(nums);
         int[] nextSol = betterSol(nums);

        System.out.println("Rearranged Array: " + Arrays.toString(rearrangedArray));
        System.out.println("Rearranged Array: " + Arrays.toString(nextSol));
    }
}
