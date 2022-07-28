package 牛客;
// https://www.nowcoder.com/practice/c3a6afee325e472386a1c4eb1ef987f3?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
public class _NC103_反转字符串 {
    // 双指针
    public String reverse(String str) {
        char[] strArray = str.toCharArray();
        int left = 0;
        int right = strArray.length - 1;
        char tmp;
        while (left < right) {
            tmp = strArray[left];
            strArray[left] = strArray[right];
            strArray[right] = tmp;
            left += 1;
            right -= 1;
        }
        return new String(strArray);
    }

    public String reverse2(String str) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            buffer.insert(0, c);
        }
        return buffer.toString();
    }
}
