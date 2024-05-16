// 121. Best Time to Buy and Sell Stock
// You are given an array prices where
//  prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by 
// choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
// Return the maximum profit you can 
// achieve from this transaction. If you cannot achieve any profit, return 0.
// Example 1:
// Input: prices = [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
// Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

public class q18Stocks {

    public static void main(String[] args) {
        
        int[] prices = {7, 1, 5, 3, 6, 4}; 
        int maxProfit = maxProfit(prices);
        
        System.out.println("Maximum profit: " + maxProfit);
    }
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0; 
        }
        
        int buy = prices[0]; 
        int profit = 0; 
        
        for (int i = 1; i < prices.length; i++) {
            int sell = prices[i]; 
             
            int currentProfit = sell - buy;
            
            
            if (currentProfit > profit) {
                profit = currentProfit;
            }
            
           
            if (buy > sell) {
                buy = sell;
            }
        }
        
        return profit;

    }
    public static int stocks(int[] a){
        int mini = a[0];
        int profit=0;
        int n= a.length;
        for(int i=1;i<n;i++){
            int cost =a[i]- mini;
            profit = Math.max(cost, profit);
            mini= Math.min(a[i],mini);

        }
        return profit;
    }
    
}
