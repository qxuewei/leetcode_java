package 牛客;
// https://www.nowcoder.com/practice/e297fdd8e9f543059b0b5f05f3a7f3b2?tpId=117&tqId=37852&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC141_判断是否为回文字符串 {
    // "absba" true
    public boolean judge(String str) {
         char[] chars = str.toCharArray();
         int left = 0;
         int right = chars.length - 1;
         while (left < right) {
             if (chars[left] != chars[right]) {
                 return false;
             }
             left += 1;
             right -= 1;
         }
         return true;
    }
}

