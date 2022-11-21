package 牛客;
// https://www.nowcoder.com/practice/2cc32b88fff94d7e8fd458b8c7b25ec1?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
public class _NC112_进制转换 {
    // 4 2
    // 100
    public static String solve(int M, int N) {
        if (M == 0) {
            return "";
        }
        boolean hasopt = false;
        if (M < 0) {
            hasopt = true;
            M = -M;
        }
        StringBuffer res = new StringBuffer();
        String appendStr = "";
        while (M != 0) {
            int carry = M % N;
            if (carry > 9) {
                appendStr = String.valueOf((char)(carry - 10 + 'A'));
            } else {
                appendStr = String.valueOf(carry);
            }
            res.append(appendStr);
            M /= N;
        }
        if (hasopt) {
            res.append("-");
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        solve(4,2);
    }
}
