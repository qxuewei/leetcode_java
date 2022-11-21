package 牛客;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

// https://www.nowcoder.com/practice/c215ba61c8b1443b996351df929dc4d4?tpId=117&tqId=37849&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
public class _NC137_表达式求值 {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>() {
        {
            put('+', 1);
            put('-', 1);
            put('*', 2);
        }
    };
    public int solve(String s) {
        // 去掉空格
        s = s.replace(" ", "");
        char[] cs = s.toCharArray();
        int n = s.length();

        // 存放所有数字
        Deque<Integer> nums = new ArrayDeque<>();
        nums.addLast(0);
        // 存放所有 非数字 以外的操作
        Deque<Character> ops = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == '(') {
                ops.addLast(c);
            } else if (c == ')') {
                // 计算到最后最近一个左括号
                while (!ops.isEmpty()) {
                    if (ops.peekLast() != '(') {
                        calc(nums, ops);
                    } else {
                        ops.pollLast();
                        break;
                    }
                }
            } else {
                if (Character.isDigit(c)) {
                    // 将从 i 开始后面连续数字整体取出， 加入 nums
                    int u = 0;
                    int j = i;
                    while (j < n && Character.isDigit(cs[j])) {
                        u = u * 10 + (cs[j++] - '0');
                    }
                    nums.addLast(u);
                    i = j - 1;
                } else {
                    if (i > 0 && (cs[i - 1] == '(' || cs[i - 1] == '+' || cs[i - 1] == '-')) {
                        nums.addLast(0);
                    }
                    // 有操作符入栈，把能算的都算了
                    while (!ops.isEmpty() && ops.peekLast() != '(') {
                        char pre = ops.peekLast();
                        if (map.get(pre) >= map.get(c)) {
                            calc(nums, ops);
                        } else {
                            break;
                        }
                    }
                    ops.addLast(c);
                }
            }
        }
        // 将剩余的算了
        while (!ops.isEmpty() && ops.peekLast() != '(') {
            calc(nums, ops);
        }
        return nums.peekLast();
    }

    // 计算逻辑
    // 从 nums 里取出两个操作数， 从 ops 取出运算符，根据运算符计算
    private void calc(Deque<Integer> nums, Deque<Character> ops) {
        if (nums.isEmpty() || nums.size() < 2) return;
        if (ops.isEmpty()) return;
        int b = nums.pollLast();
        int a = nums.pollLast();
        char op = ops.pollLast();
        int ans = 0;
        if (op == '+') {
            ans = a + b;
        } else if (op == '-') {
            ans = a - b;
        } else if (op == '*') {
            ans = a * b;
        }
        nums.add(ans);
    }
}
