package 剑指Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 邱学伟
 * @version V1.0
 * @Package 剑指Offer
 * @date 2020/11/6 下午6:26
 */
public class _38_字符串的排列 {
    /**
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     *
     *  
     *
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     *
     *  
     *
     * 示例:
     *
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     *  
     *
     * 限制：
     *
     * 1 <= s 的长度 <= 8
     *
     *
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    ArrayList<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int index) {
        if (index == c.length - 1) {
            String s = String.valueOf(c);
            res.add(s);
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = index; i < c.length; i++) {
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(i,index);
            dfs(index+1);
            swap(i,index);
        }
    }

    private void swap(int index1, int index2) {
        char temp = c[index1];
        c[index1] = c[index2];
        c[index2] = temp;
    }
}
