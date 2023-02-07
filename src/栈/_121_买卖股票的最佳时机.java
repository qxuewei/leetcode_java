package 栈;
// https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?favorite=2cktkvj
public class _121_买卖股票的最佳时机 {
    // [7,1,5,3,6,4]
    // 输出：5

    public int maxProfit202207_1(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }
}
