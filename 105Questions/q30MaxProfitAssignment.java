public class q30MaxProfitAssignment {

    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // Find the maximum difficulty level
        int maxDifficulty = 0;
        for (int d : difficulty) {
            maxDifficulty = Math.max(maxDifficulty, d);
        }

        // Array to store the maximum profit for each difficulty level up to maxDifficulty
        int[] maxProfitUpToDifficulty = new int[maxDifficulty + 1];
        for (int i = 0; i < difficulty.length; i++) {
            maxProfitUpToDifficulty[difficulty[i]] = Math.max(maxProfitUpToDifficulty[difficulty[i]], profit[i]);
        }

        // Update the maxProfitUpToDifficulty array to ensure non-decreasing profits up to each difficulty
        for (int i = 1; i <= maxDifficulty; i++) {
            maxProfitUpToDifficulty[i] = Math.max(maxProfitUpToDifficulty[i], maxProfitUpToDifficulty[i - 1]);
        }

        // Calculate total profit by finding the highest possible profit each worker can earn
        int totalProfit = 0;
        for (int ability : worker) {
            // Cap the ability to maxDifficulty if it exceeds the maximum difficulty level
            int cappedAbility = Math.min(ability, maxDifficulty);
            totalProfit += maxProfitUpToDifficulty[cappedAbility];
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[] difficulty = {2, 4, 6, 8, 10};
        int[] profit = {10, 20, 30, 40, 50};
        int[] worker = {4, 5, 6, 7};

        int result = maxProfitAssignment(difficulty, profit, worker);
        System.out.println("The maximum profit is: " + result);
    }
}
