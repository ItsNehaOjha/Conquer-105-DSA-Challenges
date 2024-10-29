public class q36niceArray {
    
    // 1248. Count Number of Nice Subarrays
    // Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
    // Return the number of nice sub-arrays.
    // Input: nums = [1,1,2,1,1], k = 3
    // Output: 2
    // Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1}; // Corrected the array declaration
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k)); // Changed System.err to System.out
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1]; // Corrected the array declaration
        int t = 0, ans = 0;
        
        for (int v : nums) {
            t += v & 1; // Count odd numbers
            if ((t - k) >= 0) {
                ans += cnt[t - k]; // Increment answer by count of previous occurrences
            }
            cnt[t]++; // Increment the count for the current number of odds
        }
        
        return ans; // Return the total count of nice subarrays
    }
}
