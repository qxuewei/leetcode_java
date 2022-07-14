package 牛客;

/*
给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。

数据范围：字符串长度 0\le n \le 100000≤n≤10000
要求：空间复杂度 O(n)O(n)，时间复杂度 O(n)O(n)
示例1
输入：
"()[]{}"
复制
返回值：
true
复制
示例2
输入：
"[]"
复制
返回值：
true
复制
示例3
输入：
"([)]"
复制
返回值：
false
 */

import java.util.HashMap;
import java.util.Stack;

public class _NC52_有效括号序列 {
    public boolean iaValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character last = stack.pop();
                if (map.get(last) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
