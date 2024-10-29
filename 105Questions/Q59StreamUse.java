import java.util.Arrays;

// 2134. Minimum Swaps to Group All 1's Together II
// A swap is defined as taking two distinct positions in an array and swapping the values in them.
// A circular array is defined as an array where we consider the first element and the last element to be adjacent. 
// Given a binary circular array nums, return the minimum number of swaps required to group all 1's present 
// in the array together at any location.
// Example 1:
// Input: nums = [0,1,0,1,1,0,0]
// Output: 1
// Explanation: Here are a few of the ways to group all the 1's together:
// [0,0,1,1,1,0,0] using 1 swap.
// [0,1,1,1,0,0,0] using 1 swap.
// [1,1,0,0,0,0,1] using 2 swaps (using the circular property of the array).
// There is no way to group all 1's together with 0 swaps.
// Thus, the minimum number of swaps required is 1.

public class Q59StreamUse {  // Class name updated for consistency
    public static void main(String[] args) {
        Q59StreamUse solution = new Q59StreamUse();  // Class name updated
        int[] nums = {1, 0, 1, 0, 1, 0, 0, 1};
        int result = solution.minSwaps(nums);
        System.out.println("Minimum swaps required: " + result);
    }

    public int minSwaps(int[] nums) {
        int k = Arrays.stream(nums).sum();  // Count of 1's in the array
        int n = nums.length;
        int cnt = 0;

        // Count 1's in the initial window of size k
        for (int i = 0; i < k; ++i) {
            cnt += nums[i];
        }
        
        int mx = cnt;  // Store the maximum count of 1's found in any window
        for (int i = k; i < n + k; ++i) {
            // Sliding window: add new element and remove the leftmost element
            cnt += nums[i % n] - nums[(i - k + n) % n];
            mx = Math.max(mx, cnt);  // Update the maximum count of 1's
        }
        
        return k - mx;  // Minimum swaps required to group all 1's together
    }
}
