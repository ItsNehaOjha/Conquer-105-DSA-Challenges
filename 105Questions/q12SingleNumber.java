// Single Number
// Given a non-empty array of integers nums,
// every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity 
// and use only constant extra space.
// Input: nums = [2,2,1]
// Output: 1

public class q12SingleNumber{
    public static void main(String[] args) {
        int[] arr={2,2,1};
        int num=singleNumber(arr);
        System.out.println(num);

    }
    public static int singleNumber(int[ ] arr) {
        int ans=0;
        for(int num:arr){
            ans ^= num;
        }
        return ans;
//        Enhanced for Loop (for (int num : nums)):
//       Use this style when you only need to iterate over elements of an array without 
//      requiring explicit indices. It enhances readability and reduces potential errors related to index manipulation.

    }
}