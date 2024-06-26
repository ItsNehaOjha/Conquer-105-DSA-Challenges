import java.util.Arrays;

public class q33NumberOfDiceRoll {

    // 1155. Number of Dice Rolls With Target Sum
    // You have n dice, and each dice has k faces numbered from 1 to k.
    // Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) 
    // to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, 
    // return it modulo 10^9 + 7.

    // Input: n = 2, k = 6, target = 7
    // Output: 6
    // Explanation: You throw two dice, each with 6 faces.
    // There are 6 ways to get a sum of 7: 1+6, 2+5, 3+4, 4+3, 5+2, 6+1.

    private static final int MOD = 1000000007;

    public static int numberToRoll(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        // initialize the dp matrix with -1 , so if there is any other number inside dp that will be the ans
        for (int[] e : dp) {
            Arrays.fill(e, -1);
        }
        return isSafe(n, k, target, dp);
    }

    private static int isSafe(int n, int k, int target, int[][] dp) {
        if (n < 0 || target < 0) return 0;
        if (n == 0 && target == 0) return 1;

        if (dp[n][target] != -1) return dp[n][target];

        int ans = 0;
        for (int i = 1; i <= k; i++) { 
            if (i <= target) {
                ans = (ans + isSafe(n - 1, k, target - i, dp)) % MOD;
            }
        }
        dp[n][target] = ans;
        return ans;
    }

    public static void main(String[] args) {
       
        int n = 2, k = 6, target = 7;
        int result = numberToRoll(n, k, target);
        System.out.println(result); // Output: 6
    }
}
