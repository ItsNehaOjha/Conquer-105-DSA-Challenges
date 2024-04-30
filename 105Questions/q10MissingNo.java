public class q10MissingNo {

    // Given an array nums containing n distinct numbers in the range [0, n),
    // return the only number in the range that is missing from the array.
    
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        int missing = missingNumber(nums);
        int missing2 = byFormulae(nums);
        int missing3 = byXOR(nums);
        System.out.println("Missing Number: " + missing);  // Output: 2
        System.out.println("Missing Number by Formula: " + missing2);  // Output: 2
        System.out.println("Missing Number by XOR: " + missing3);  // Output: 3
    }
   
    public static int missingNumber(int[] nums) {
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
    
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Method to find missing number using formula
    public static int byFormulae(int[] arr) {
        int n = arr.length;
        int sum = (n * (n + 1)) / 2;
        int sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum2 += arr[i];
        }
        int ans = sum - sum2;
        return ans;
    }

    // As x ^ x = 0 for any number x, and x ^ 0 = x
    //  initialize missing to 0.
    // perform an XOR operation on missing with every number from 0 to n (inclusive), 
    // which will give us missing as the XOR of all numbers in this range.
    // XOR missing with every number in the nums array. Because XOR is commutative and associative,
    // duplicates will cancel out, leaving missing as the missing number.
    //Pehle loop mein [0, n] range ke numbers ke saath XOR kiya jaata hai.
    //Dusre loop mein nums array ke har element ke saath XOR kiya jaata hai.

    public static int byXOR(int[] arr){
        int missing = 0;
        int n=arr.length;
        for(int i=0; i<=n;i++){
            missing^=i;
        }
        for(int num:arr){
            missing^=arr[num];
        }
        return missing;
    }

    //but also we can remove the first loop here and make it O(N) TC and the optimal Solution
    public static int optimalSol(int[] arr){

        int xor1= 0, xor2=0;
        int N=arr.length;
        int n=N-1;
        for(int i=0;i<n;i++){
            xor2 = xor2^arr[i];
            xor1= xor1^(i+1);
        }
        xor1 = xor1^N;
        return xor1^xor2;

    }

}
