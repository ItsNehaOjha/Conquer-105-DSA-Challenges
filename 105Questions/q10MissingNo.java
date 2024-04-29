public class q10MissingNo {

    // Given an array nums containing n distinct numbers in the range [0, n],
    //  return the only number in the range that is missing from the array.
    
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int missing = missingNumber(nums);
        System.out.println("Missing Number: " + missing);  // Output: 2
    }
   
    private static int missingNumber(int[] nums) {
            int n = nums.length;
    
            for (int i = 0; i < n; i++) {
                while (nums[i] < n && nums[i] != nums[nums[i]]) {
                    swap(nums, i, nums[i]);
                }
            }
    
            // Find the missing number
            for (int i = 0; i < n; i++) {
                if (nums[i] != i) {
                    return i;
                }
            }
    
            // If no missing number found, return n
            return n;
        }
    
        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    
    

