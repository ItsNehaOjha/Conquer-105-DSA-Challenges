public class q36niceArray {
    
    // 1248. Count Number of Nice Subarrays
    // Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
    // Return the number of nice sub-arrays.
    // Input: nums = [1,1,2,1,1], k = 3
    // Output: 2
    // Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

    public static void main(String[] args) {
        int[] nums = [1,1,2,1,1];
        int k = 3;
        System.err.println(numberOfSubarrays(nums, k));
    }
    public static int numberOfSubarrays(int[] nums, int k){
        int n= nums.length;
        int cnt = new int[n+1];
        int t=0, ans=0;
        for(int v:nums){
            t+= v&1;
            if((t-k)>=0){
                ans+= cnt[t-k];
            }
            cnt[t]++;
        }
        return ans;
    }
}
