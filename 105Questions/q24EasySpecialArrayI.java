public class q24EasySpecialArrayI{

    //3151. Special Array I
    
// Input: nums = [4,3,1,6]
// Output: false
// Explanation:
// nums[1] and nums[2] are both odd. So the answer is false.

// An array is considered special if every pair of its adjacent elements contains two numbers with different parity.

// You are given an array of integers nums. Return true if nums is a special array, otherwise, return false.

    public static void main(String[] args) {
        int[] arr={2,1,4};
        int n= arr.length;
        boolean ans = ans(arr,n);
        System.out.println(ans);
        
    }
    public static boolean ans(int[]arr, int n){
        for(int i=0;i<n-1;i++){
            if((arr[i]&1)== (arr[i+1]&1)){
                return false;
            }
        }
        return true;
    }
}