public class q46AverageWaitingTime {

    
     // 1701. Average Waiting Time
        // Input: customers = [[1,2],[2,5],[4,3]]
        // Output: 5.00000
        // Explanation:
        // 1) The first customer arrives at time 1, the chef takes his order and starts preparing it immediately at time 1, and finishes at time 3, so the waiting time of the first customer is 3 - 1 = 2.
        // 2) The second customer arrives at time 2, the chef takes his order and starts preparing it at time 3, and finishes at time 8, so the waiting time of the second customer is 8 - 2 = 6.
        // 3) The third customer arrives at time 4, the chef takes his order and starts preparing it at time 8, and finishes at time 11, so the waiting time of the third customer is 11 - 4 = 7.
        // So the average waiting time = (2 + 6 + 7) / 3 = 5.



    public static void main(String[] args) {
        // Test case 1
        int[][] customers1 = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println("Test case 1: " + new Solution().averageWaitingTime(customers1)); // Expected output: 5.0

        // Test case 2
        int[][] customers2 = {{5, 2}, {5, 4}, {10, 3}};
        System.out.println("Test case 2: " + new Solution().averageWaitingTime(customers2)); // Expected output: 4.0

        // Test case 3
        int[][] customers3 = {{1, 2}, {2, 2}, {3, 2}};
        System.out.println("Test case 3: " + new Solution().averageWaitingTime(customers3)); // Expected output: 3.0

        // Test case 4
        int[][] customers4 = {{1, 10}, {5, 10}, {15, 10}};
        System.out.println("Test case 4: " + new Solution().averageWaitingTime(customers4)); // Expected output: 10.0
    }
}

class Solution {
    public double averageWaitingTime(int[][] customers) {
        long idle = 0;
        long totalTime = 0;
        for (int[] cust : customers) {
            if (idle <= cust[0]) {
                idle = cust[0] + cust[1];
            } else {
                idle += cust[1];
            }
            totalTime += idle - cust[0];
        }
        return totalTime / (double) customers.length;
    }
}
