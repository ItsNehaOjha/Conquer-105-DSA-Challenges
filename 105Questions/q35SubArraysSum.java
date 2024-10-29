import java.util.HashSet;
import java.util.Set;

public class q35SubArraysSum {

    // 2395. Find Subarrays With Equal Sum
    // Given a 0-indexed integer array nums, determine whether there exist two subarrays of length 2 with equal sum.
    // Note that the two subarrays must begin at different indices. Return true if these subarrays exist, and false otherwise.
    // Input: nums = [4,2,4]
    // Output: true
    // Explanation: The subarrays with elements [4,2] and [2,4] have the same sum of 6.
    // Input: nums = [1,2,3,4,5]
    // Output: false
    // Explanation: No two subarrays of size 2 have the same sum.

    public static void main(String[] args) {
        int[] nums = {4, 2, 4}; // Corrected the array declaration
        System.out.println(findSubarrays(nums));
    }

    public static boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (!set.add(sum)) return true;
            // if(!set.add(sum)) return true;: The set.add(sum) method attempts to add the calculated sum to the set. 
            // If the sum is already in the set, the add method returns false. This indicates that a duplicate sum has been found, 
            // so the method immediately returns true.
        }
        return false;
    }
}
