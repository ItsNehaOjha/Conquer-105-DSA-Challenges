class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        
        // Using the two-pointer technique to detect cycles
        do {
            slow = calculateSquare(slow);            
            fast = calculateSquare(calculateSquare(fast));
        } while (fast != slow);
        
        // If we end up at 1, it’s a happy number
        return slow == 1;
    }
    
    // Helper function to calculate the sum of squares of digits
    public int calculateSquare(int num) {
        int ans = 0;
        while (num > 0) {
            int rem = num % 10;
            ans += rem * rem;
            num /= 10;
        }
        return ans;
    }
}

public class q61IsHappy {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int n = 19; // Change this value to check different numbers
        System.out.println("Checking if " + n + " is a happy number:");
        
        // Check if the number is happy and print result
        if (solution.isHappy(n)) {
            System.out.println(n + " is a happy number!");
        } else {
            System.out.println(n + " is not a happy number.");
        }
    }
}
