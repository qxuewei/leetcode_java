package 牛客;
// https://www.nowcoder.com/practice/64b4262d4e6d4f6181cd45446a5821ec?tpId=117&tqId=37717&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC7_买卖股票的最好时机一 {
    //输入：
    //[8,9,2,5,4,7,1]
    //返回值：
    //5
    // 暴力
    public int maxProfit(int[] prices) {
        int res = 0;
        int left, right;
        for (left = 0; left < prices.length - 1; left++) {
            right = prices.length - 1;
            while (right > left) {
                int curProfit = prices[right] - prices[left];
                if (curProfit > res) {
                    res = curProfit;
                }
                right -= 1;
            }
        }
        return res;
    }

    // 贪心
    public int maxProfit1(int[] prices) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                int curProfit = prices[i] - min;
                if (curProfit > res) {
                    res = curProfit;
                }
            }
        }
        return res;
    }
}
