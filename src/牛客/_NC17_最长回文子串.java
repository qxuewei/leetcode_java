package 牛客;
// https://www.nowcoder.com/practice/b4525d1d84934cf280439aeecc36f4af?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=&gioEnter=menu
public class _NC17_最长回文子串 {
    public int getLongestPalindrome (String A) {
        if (A.length() < 2) {
            return A.length();
        }
        int n = A.length();
        int max = 0;
        for (int i = 0; i < n; i++) {
            int maxLenth1 = maxLenth(A, i, i);
            int maxLenth2 = maxLenth(A, i, i + 1);
            int curMax = Math.max(maxLenth1, maxLenth2);
            max = Math.max(curMax, max);
        }
        return max;
    }

    public int maxLenth(String A, int left, int right) {
        int i = left;
        int j = right;
        while (i >= 0 && j < A.length()) {
            if (A.charAt(i) == A.charAt(j)) {
                i -= 1;
                j += 1;
            } else {
                break;
            }
        }
        return j - i + 1 - 2;
    }

}
