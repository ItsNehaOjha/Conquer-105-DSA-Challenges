    //Two Sum 
//     Given an array of integers nums and an integer target, 
//return indices of the two numbers such that they add up to target.
// You may assume that each input would have exactly one solution,
// and you may not use the same element twice.
// You can return the answer in any order.

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]

public class q13TwoSum {
    public static void main(String[] args) {
        int[] arr={2,7,11,15};
        int target= 9;
        int[] ans =twoSum(arr, target);
        if (ans.length == 2) {
            System.out.println("Indices of two numbers that add up to " + target + ": [" + ans[0] + ", " + ans[1] + "]");
        } else {
            System.out.println("No valid indices found.");
        }
        
    }
    public static int[] twoSum(int[]arr,int target){
        
        int n=arr.length;
        int[] ans = new int[2];
        for(int i=0;i<n;i++){
            int n1= arr[i];
            for(int j=i+1;j<n;j++){
                int sum = n1+arr[j];
                if(sum == target){
                    ans[0]=i;
                    ans[1]= j;
                    return ans;
                }
            }
        }


        return new int[]{};

    }
}
