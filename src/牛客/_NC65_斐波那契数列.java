package 牛客;
// https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
public class _NC65_斐波那契数列 {
    // 1 1 2 3 5
    // 迭代
    public int Fibonacci(int n) {
        if (n < 3) {
            return 1;
        }
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    // 记忆化搜索
    public int Fibonacci2(int n) {
        if (n < 3) {
            return 1;
        }
        int[] map = new int[50];
        if (map[n] > 0) return map[n];
        return map[n] = Fibonacci2(n - 1) + Fibonacci2(n - 2);
    }
}
