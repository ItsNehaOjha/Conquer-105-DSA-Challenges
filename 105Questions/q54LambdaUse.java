// 1636. Sort Array by Increasing Frequency

// Given an array of integers nums, sort the array in increasing order based on the frequency of the values.
//  If multiple values have the same frequency, sort them in decreasing order.

// Return the sorted array.

// Input: nums = [1,1,2,2,2,3]
// Output: [3,1,1,2,2,2]
// Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.

import java.util.*;

public class Q54LambdaUse {

    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        
        // Yahaan nums array ko temp array mein copy kiya ja raha hai, kyunki hum [Integer] array pe sorting apply karenge. Integer 
        // array isliye use kiya gaya hai kyunki Arrays.sort() method lambda expressions ke sath kaam karta hai sirf Integer[] type pe,
        //  primitive int[] pe nahi.

        Integer[] temp = new Integer[n];
        for (int i = 0; i < n; i++) {
            temp[i] = nums[i];
        }

        // ***8Lambda Expression ki Zarurat*****
        // NOTE :::: Custom sorting logic ko implement karne ke liye hume comparator ki zarurat hoti hai

        int[] freq = new int[201];
        for (int x : nums) {
            freq[v(x)]++;
        }

// Key frequencies:

// freq[101] = 2 (element 1 appears 2 times)
// freq[102] = 3 (element 2 appears 3 times)
// freq[103] = 1 (element 3 appears 1 time)
        

        Arrays.sort(temp, (x, y) -> 
            freq[v(x)] == freq[v(y)] ? y - x : freq[v(x)] - freq[v(y)]
        );

        for (int i = 0; i < n; i++) {
            nums[i] = temp[i];
        }

        return nums;
    }

    private int v(int a) {
        return a + 100;
    }

    public static void main(String[] args) {
        Q54LambdaUse q54LambdaUse = new Q54LambdaUse();
        int[] nums = {1, 1, 2, 2, 2, 3};
        int[] sortedNums = q54LambdaUse.frequencySort(nums);
        System.out.println(Arrays.toString(sortedNums));
    }
}
