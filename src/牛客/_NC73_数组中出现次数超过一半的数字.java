package 牛客;

import java.util.HashMap;

// https://www.nowcoder.com/practice/e8a1b01a2df14cb2b228b30ee6a92163?tpId=117&tqId=37770&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC73_数组中出现次数超过一半的数字 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int halfLength = (int) (array.length / 2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int curNum = array[i];
            int curCount = 1;
            if (map.containsKey(curNum)) {
                curCount = map.get(curNum) + 1;
            }
            if (curCount > halfLength) {
                return array[i];
            } else {
                map.put(array[i], curCount);
            }
        }
        return 0;
    }
}
