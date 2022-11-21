package 牛客;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// https://www.nowcoder.com/practice/fd711bdfa0e840b381d7e1b82183b3ee?tpId=117&tqId=37809&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC97_字符串出现次数的TopK问题 {
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        if (strings.length == 0) {
            return new String[0][0];
        }
        String[][] res = new String[k][2];
        HashMap <String, Integer> map = new HashMap<>();
        // 统计个数
        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        // 排序
        ArrayList<Map.Entry<String, Integer>> list =
                new ArrayList<>(map.entrySet());
        Collections.sort(list,
                (o1, o2) ->
                        (o1.getValue().compareTo(o2.getValue()) == 0 ?
                                o1.getKey().compareTo(o2.getKey()) :
                                o2.getValue().compareTo(o1.getValue()))
        );

        // 返回topK
        for (int i = 0; i < k; i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = String.valueOf(list.get(i).getValue());
        }
        return res;
    }
}
