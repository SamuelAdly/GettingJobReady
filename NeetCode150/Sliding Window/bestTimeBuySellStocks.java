public class bestTimeBuySellStocks {

    /*
     * Best Time to Buy and Sell Stock is marked as an easy Sliding Window Problem.
     * We want to find the maximum profit we can make by buying a stock and then selling it.
     * The brute force O(n^2) solution involves checking every pair of days to find the maximum profit.
     * This approach is only a couple of lines but takes a long time for larger inputs.
     * The best approach is O(n) time complexity meaning we must pass through the array only once.
     * Since it is a sliding window problem we can use a left and right pointer to find the maximum profit.
     * The left pointer represents the day we buy the stock and the right pointer represents the day we sell it.
     * If the price on the left is greater than the price on the right we move the left pointer to the right and shift right by one
     * If the price on the right is greater than the price on the left we calculate the profit and check if it is greater than the current maximum profit.
     * If it is we update the maximum profit and shift the right pointer to the right and keep going until we reach the end of the array.
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if ((prices[j] - prices[i]) > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    public int maxProfitBest(int[] prices) {
        int left = 0;
        int right = 1;
        int max = 0;
        while (right < prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
                right++;
            } else {
                max = Math.max(max, prices[right] - prices[left]);
                right++;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        bestTimeBuySellStocks sol = new bestTimeBuySellStocks();
        System.out.println("Test for O(n^2) Method:");
        System.out.println("prices = [10,1,5,6,7,1]");
        System.out.println("Max Profit: " + sol.maxProfit(new int[] {10,1,5,6,7,1}));
        System.out.println("prices = [10,8,7,5,2]");
        System.out.println("Max Profit: " + sol.maxProfit(new int[] {10,8,7,5,2}) + "\n");

        System.out.println("Test for O(n) Method:");
        System.out.println("prices = [10,1,5,6,7,1]");
        System.out.println("Max Profit: " + sol.maxProfitBest(new int[] {10,1,5,6,7,1}));
        System.out.println("prices = [10,8,7,5,2]");
        System.out.println("Max Profit: " + sol.maxProfitBest(new int[] {10,8,7,5,2}));
    }
    
}
