// 633. Sum of Square Numbers
// Given a non-negative integer c, decide whether there're two integers a and b such that a^2 + b^2 = c.

// Input: c = 5
// Output: true
// Explanation: 1 * 1 + 2 * 2 = 5

public class q34SumOfSquares {

    public static void main(String[] args) {
        int c = 73;
        System.out.println(judgeSquareSum(c));
    }

    public static boolean judgeSquareSum(int c) {
        if (c < 0) return false;
        
        long l = 0;
        long r = (int) Math.sqrt(c);
        
        while (l <= r) {  // Change this to `<=` to include the case when l and r are the same
            long sum = l * l + r * r; // Use long to prevent overflow
            if (sum == c) {
                return true;
            } else if (sum < c) {
                l++;
            } else {
                r--;
            }
        }
        
        return false;
    }
}
