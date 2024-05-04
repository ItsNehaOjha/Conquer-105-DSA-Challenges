//-------------------kadane's algorithm-------------

//Maximum Subarray Sum

//Given an integer array nums, find the subarray with the largest sum, and return its sum.
// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.

public class q16MaxiSubArrayaSum {

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int maxSubArraySum = bruteApproach(arr, n);
        System.out.println("Maximum Subarray Sum: " + maxSubArraySum);

        int maxSubArraySum2 = betterApproach(arr, n);
        System.out.println("Maximum Subarray Sum 2: " + maxSubArraySum2);

        int kadanesAlgorithmSum = kadanesAlgorithm(arr, n);
        System.out.println("Kadane's Algorithm Sum: " + kadanesAlgorithmSum);
    }

    // Brute-force approach to find the maximum subarray sum
    public static int bruteApproach(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; 
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
           
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi; 
    }

    public static int betterApproach(int[] arr, int n) {
        int maxi = Integer.MIN_VALUE; 
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                maxi = Math.max(maxi, sum);
            }
        }
        return maxi; 
    }

    //-------------------kadane's algorithm-------------
    public static int kadanesAlgorithm(int[]arr,int n){
        int sum =0;
        int maxi=arr[0];
        for(int i=0;i<n;i++){
            sum += arr[i];
            maxi= Math.max(maxi,sum);
            if(sum<0){
                sum=0;
            }
        }
        return maxi;
    }
}
