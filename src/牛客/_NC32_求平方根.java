package 牛客;
// https://www.nowcoder.com/practice/09fbfb16140b40499951f55113f2166c?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
public class _NC32_求平方根 {
    // 5
    public int sprt(int x) {
        // write code here
        if (x < 2) {
            return x;
        }
        // 左闭右开
        int l = 1;
        int r = x / 2;
        int mid = 0;
        int lastMid = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            int tmp = x / mid;
            if (tmp > mid) {
                l = mid + 1;
                lastMid = mid;
            } else if (tmp < mid) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return lastMid;
    }
}
