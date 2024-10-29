// 2191. Sort the Jumbled Numbers

// You are given a 0-indexed integer array mapping which represents the mapping rule of a shuffled decimal system. 
// mapping[i] = j means digit i should be mapped to digit j in this system. 
// The mapped value of an integer is the new integer obtained by replacing each occurrence of digit i in the integer with mapping[i] for all 0 <= i <= 9. 
// You are also given another integer array nums. Return the array nums sorted in non-decreasing order based on the mapped values of its elements. 
// Notes: Elements with the same mapped values should appear in the same relative order as in the input. 
// The elements of nums should only be sorted based on their mapped values and not be replaced by them.

// Example 1:
// Input: mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]
// Output: [338,38,991]
// Explanation: 
// Map the number 991 as follows:
// 1. mapping[9] = 6, so all occurrences of the digit 9 will become 6.
// 2. mapping[1] = 9, so all occurrences of the digit 1 will become 9.
// Therefore, the mapped value of 991 is 669.
// 338 maps to 007, or 7 after removing the leading zeros.
// 38 maps to 07, which is also 7 after removing leading zeros.
// Since 338 and 38 share the same mapped value, they should remain in the same relative order, so 338 comes before 38.
// Thus, the sorted array is [338,38,991].

import java.util.*;

public class Q55StreamUse {

    public int[] sortJumbled(int[] mapping, int[] nums) {
        Map<Integer, Integer> numberMapping = new HashMap<>();

        for (int num : nums) {
            // Map each number to its corresponding mapped value if not already mapped
            numberMapping.put(num, translateInteger(num, mapping));
        }

        // Create a boxed array for sorting
        Integer[] numsBoxed = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsBoxed, (a, b) -> Integer.compare(numberMapping.get(a), numberMapping.get(b)));

        // Reassign sorted numbers back to the original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsBoxed[i];
        }

        return nums;
    }

    private int translateInteger(int num, int[] mapping) {
        char[] digits = Integer.toString(num).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            digits[i] = (char) ('0' + mapping[digits[i] - '0']);
        }
        // Return the mapped integer while removing leading zeros
        return Integer.parseInt(new String(digits).replaceFirst("^0+", ""));
    }

    public static void main(String[] args) {
        Q55StreamUse q55StreamUse = new Q55StreamUse();

        int[] mapping = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0}; // Example mapping
        int[] nums = {990, 332, 981}; // Example input array

        int[] sortedNums = q55StreamUse.sortJumbled(mapping, nums);
        System.out.println(Arrays.toString(sortedNums)); // Output sorted array
    }
}
