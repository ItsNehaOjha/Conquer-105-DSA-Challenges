public class q44WaterBottle {
    // 1518. Water Bottles
    // There are numBottles water bottles that are initially full of water.
    // You can exchange numExchange empty water bottles from the market with one full water bottle.
    // The operation of drinking a full water bottle turns it into an empty bottle.
    // Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

    public static void main(String[] args) {
        // Test case 1
        int numBottles1 = 9;
        int numExchange1 = 3;
        System.out.println("Test case 1: " + numWaterBottles(numBottles1, numExchange1)); // Expected output: 13
        
        // Test case 2
        int numBottles2 = 15;
        int numExchange2 = 4;
        System.out.println("Test case 2: " + numWaterBottles(numBottles2, numExchange2)); // Expected output: 19

        // Test case 3
        int numBottles3 = 5;
        int numExchange3 = 5;
        System.out.println("Test case 3: " + numWaterBottles(numBottles3, numExchange3)); // Expected output: 6

        // Test case 4
        int numBottles4 = 2;
        int numExchange4 = 3;
        System.out.println("Test case 4: " + numWaterBottles(numBottles4, numExchange4)); // Expected output: 2
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int totalBottle = numBottles;
        while (numBottles >= numExchange) {
            totalBottle += numBottles / numExchange; // Drink the bottles that can be exchanged
            numBottles = (numBottles / numExchange) + (numBottles % numExchange); // Update the number of full bottles
        }
        return totalBottle;
    }
}
