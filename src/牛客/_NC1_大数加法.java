package 牛客;

/*
以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。

数据范围：s.length,t.length \le 100000s.length,t.length≤100000，字符串仅由'0'~‘9’构成
要求：时间复杂度 O(n)O(n)
示例1
输入：
"1","99"
复制
返回值：
"100"
复制
说明：
1+99=100
示例2
输入：
"114514",""
复制
返回值：
"114514"

https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
 */

public class _NC1_大数加法 {

    public String add(String s, String t) {
        if (s.length() == 0) {
            return t;
        }
        if (t.length() == 0) {
            return t;
        }
        int i = s.length() - 1;
        int j = t.length() - 1;
        int sum = 0;
        StringBuffer buffer = new StringBuffer();
        while (i >= 0 || j >= 0 || sum != 0) {
            sum += (i >= 0 ? s.charAt(i--) - '0' : 0);
            sum += (j >= 0 ? t.charAt(j--) - '0' : 0);
            buffer.append(sum % 10);
            sum = sum / 10;
        }
        return buffer.reverse().toString();
    }

}
